package test.multiTherad.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 线程池不会自动关闭，
 * Executor 是一个接口，只有一个方法execute（Runnable）
 * Executors 是一个工厂类，可以创建Executor【一般实现创建线程池】
 * ExecutorService 是一个接口，继承了Executor，添加了好多方法
 * AbstractExecutorService是ExecutorService的抽象实现类
 * ThreadPoolExecutor 是AbstractExecutorService的实现子类
 * ThreadFactory 可以自定义线程工厂【Thread 含有Runnable】
 * 
 * 线程池的类型：
 *     CachedThreadPool   创建无界线程池
 *     FixedThreadPool(int ) 有界的线程池
 *     SingleThreadExecutor  单一线程池
 * ThreadPoolExecutor的构造方法：
 *    ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler)  
 *    corePoolSize：空闲线程个数
 *    maximumPoolSize：最大线程个数
 *    keepAliveTime:如果池中当前有多于 corePoolSize 的线程，则这些多出的线程在空闲时间超过 keepAliveTime 时将会终止，=0则任务执行结束即删除
 *    
 * 所有 BlockingQueue 都可用于传输和保持提交的任务。可以使用此队列与池大小进行交互： 
	 *  如果运行的线程少于 corePoolSize，则 Executor 始终首选添加新的线程，而不进行排队。 
	 *  如果运行的线程等于或多于 corePoolSize，则 Executor 始终首选将请求加入队列，而不添加新的线程。 
	 *  如果无法将请求加入队列，则创建新的线程，除非创建此线程超出 maximumPoolSize，在这种情况下，任务将被拒绝。 
	 *  排队有三种通用策略： 
	 *  直接提交。工作队列的默认选项是 SynchronousQueue，它将任务直接提交给线程而不保持它们。在此，如果不存在可用于立即运行任务的线程，则试图把任务加入队列将失败，因此会构造一个新的线程。此策略可以避免在处理可能具有内部依赖性的请求集时出现锁。直接提交通常要求无界 maximumPoolSizes 以避免拒绝新提交的任务。当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。 
	 *  无界队列。使用无界队列（例如，不具有预定义容量的 LinkedBlockingQueue）将导致在所有 corePoolSize 线程都忙时新任务在队列中等待。这样，创建的线程就不会超过 corePoolSize。（因此，maximumPoolSize 的值也就无效了。）当每个任务完全独立于其他任务，即任务执行互不影响时，适合于使用无界队列；例如，在 Web 页服务器中。这种排队可用于处理瞬态突发请求，当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性。 
	 *  有界队列。当使用有限的 maximumPoolSizes 时，有界队列（如 ArrayBlockingQueue）有助于防止资源耗尽，但是可能较难调整和控制。队列大小和最大池大小可能需要相互折衷：使用大型队列和小型池可以最大限度地降低 CPU 使用率、操作系统资源和上下文切换开销，但是可能导致人工降低吞吐量。如果任务频繁阻塞（例如，如果它们是 I/O 边界），则系统可能为超过您许可的更多线程安排时间。使用小型队列通常要求较大的池大小，CPU 使用率较高，但是可能遇到不可接受的调度开销，这样也会降低吞吐量。
 * BlockingQueue 是一个接口，它的实现类有
 *    LinkedBlockingQueue
 *    ArrayblockingQueue
 *    SynchronousQueue：  ====这个队列 超过maxsize则会跑出异常
 * 线程池方法：
 *   shutdown（） 未执行的线程进行执行，不添加新的线程-----非阻塞
 *   shutdownNow() 需要判断是否当前的中断状态，正在执行的线程继续执行，没执行的从队列中删除
 *   isShutdown()  是否关闭【只要调用了shutdown就返回true 不是正式的关闭】
 *   isTerminating  调用了关闭，还有线程执行 返回true
 *   isTerminated    所有任务执行完成，关闭  返回true
 *   awaitTermination(long ,TimeUnit unit) 等待执行时间后判断线程池是否终止工作====阻塞
 *   setRejectedExceptionHandle   自定义任务被拒绝的行为
 *   allowCoreThreadTimeOut()====设置核心线程是否有超时的效果
 *   prestartCoreThread()===调用异常 创建一个核心线程  返回true false
 *   prestartAllCoreThreads（）===创建全部核心线程  返回核心线程的个树
 *   getCompletedTaskCount()====取得已经执行完成的任务数 
 *   remove(Thread) ===移除线程【当且仅当线程没有执行，且使用execute发布而不是submit方法】  
 *   getActiveCount()====得到多少线程正在执行
 *   getCompletedTaskCount（）====得到完成任务的线程数
 *   getPoolSize()
 *   getCorePoolSize()
 *   getMaxmunPoolSize()
 *   getTaskCount();
 * 线程的定制：ThreadFactory
 *     setUncaughtExceptionHandler  自定义异常处理
 * 线程池的拒绝策略：
 *    AbortPolicy=====抛出异常
 *    CallerRunsPolicy=====调用线程池中线程处理任务
 *    DiscardOldestPolicy====放弃等待最久的任务  添加新任务进去
 *    DiscardPolicy=====直接丢弃被拒绝的任务 
 * 线程池重写方法 对执行的线程进行监控
 *   重写afterExecute()
 *   重写beforeExecute()
 * 线程池添加线程任务的方法：
 *    submit()【可以接收Callable 和 Runnable】===可以返回Futuer 会捕获异常
 *    execute()【只能执行Runnable】 会抛出异常
 * Callable接口====可以比拟与线程
 *    与Runnable的区别是：
 *       call 方法个有返回值【使用Future来接收】   run 方法没有返回值【返回可以是任意类型】
 *       call 方法可以抛出异常  run 方法不能抛出异常
 *    与ExecutorService 的连接点
 *         ExecutorService使用submit接收Callable的任务【callable只能submit，不能executor，submit可以调用Runnable 和  Callable】
 * Future=====submit的返回值【如果想要得到返回结果 则会阻塞】
 *    get() 得到返回的结果===具有阻塞特性  
 *    isDone()   无阻塞
 *    cancel()   需要使用if（Thread.currentThread().isInterrupted()）
 *    isCancelled()
 *  自定义拒绝策略：
 *   实现RejectedExecutionHandler 接口
 *  Execute执行如果要捕获异常，需要线程设置捕获异常及 setUncaugthExecptionHandler
 *  
 *  
 *  
 *    
 */
public class TestMain {

	public static void main(String args[]){
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.execute(new Runnable(){

			public void run() {
				try{
					System.out.println(Thread.currentThread().getName()+"executor");
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		});
		
	}
}
