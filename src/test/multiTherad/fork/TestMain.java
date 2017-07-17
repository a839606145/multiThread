package test.multiTherad.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * ForkJoinPool 任务池 使用submit 等提交任务
 * ForkJoinTask 任务执行接口 提交任务返回的类[Future的实现类]
 *      CountedCompleter
 *      RecurisiveAction 无返回值,仅执行一次任务[非阻塞的，如果main线程关闭，其也关闭]
 *      RecursiveTask 有返回值 结合join 和 get 使用[join get 在异常处理时不一样  get子任务异常 main直接捕获 join则直接抛出 ]
 *      RecursiveTask 中的compute 方法不能抛出异常
 *  ForkJoinPool 核心方法：
 *      execute： 线程已异步的方式运行    [可以执行 RecurisiveAction  RecurisiveService  Runnable] 没有返回值
 *      submit：有返回值【可以执行RecursiveAction RecurisiveService Runnable Callable】
 *      submit（线程相关类，返回对象）返回为ForkJoinTask的get获取
 *      invoke具有阻塞，具有返回值。返回值通过对象获取
 *      invokeAll（Collect<> Callable）
 *      shutdown()==不具有中断效果，sleep中的线程没有抛出异常【每个任务正常运行直到结束，不能提交新的任务】[其后调用get不报错]
 *      shutdownNow()===【结合isInterrupted停止当前正在执行的任务，不能提交新任务】【其后，调用get报错】
 *      shutdownNow()===【不结合isInterrupted,当前任务执行结束，不能提交新任务】
 *      isTerminating（）
 *      isTerminated()
 *      isShutdown()
 *      shutdowm 后可以使用awaitTermination 等待一段时间销毁任务
 *      一些线程池状态方法：
 *         get****
 *      
 *
 *      
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String args[]) throws Exception{
		ForkJoinPool pool=new ForkJoinPool();
		//pool.submit(new RecursiveActionTest(5,40));
		/*RecursiveTaskTest test=new RecursiveTaskTest();
		RecursiveTaskTest test2=new RecursiveTaskTest();
		ForkJoinTask task=pool.submit(test);
		ForkJoinTask task2=pool.submit(test2);
		System.out.println(task2.hashCode()+"--"+task2.join()+System.currentTimeMillis());
		System.out.println(task.hashCode()+"--"+task.join()+System.currentTimeMillis());*/
		
		/*RecursiveTask3 task=new RecursiveTask3(2,20);
		pool.execute(task);
		ForkJoinTask<Integer> runTask=pool.submit(task);
		System.out.println(runTask.join());*/
		
		/*RecursiveActionTest action=new RecursiveActionTest(2,10);
		pool.execute(action);*/
		
		/*pool.execute(new Runnable() {
			public void run() {
				 System.out.println("开始执行");
			}
		});*/
		/*RecursiveTask3 task=new RecursiveTask3(2,20);
		pool.execute(task);
		System.out.println(task.get());*/
		UserInfo  userInfo=new UserInfo();
		MyRunnable runa=new MyRunnable(userInfo);
	    Future<UserInfo> future=pool.submit(runa, userInfo);
	    future.get();
	    System.out.println("ddddd"+userInfo.getName());
		
		Thread.sleep(2000);
	}
}
