package test.multiTherad.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * �̳߳ز����Զ��رգ�
 * Executor ��һ���ӿڣ�ֻ��һ������execute��Runnable��
 * Executors ��һ�������࣬���Դ���Executor��һ��ʵ�ִ����̳߳ء�
 * ExecutorService ��һ���ӿڣ��̳���Executor������˺ö෽��
 * AbstractExecutorService��ExecutorService�ĳ���ʵ����
 * ThreadPoolExecutor ��AbstractExecutorService��ʵ������
 * ThreadFactory �����Զ����̹߳�����Thread ����Runnable��
 * 
 * �̳߳ص����ͣ�
 *     CachedThreadPool   �����޽��̳߳�
 *     FixedThreadPool(int ) �н���̳߳�
 *     SingleThreadExecutor  ��һ�̳߳�
 * ThreadPoolExecutor�Ĺ��췽����
 *    ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler)  
 *    corePoolSize�������̸߳���
 *    maximumPoolSize������̸߳���
 *    keepAliveTime:������е�ǰ�ж��� corePoolSize ���̣߳�����Щ������߳��ڿ���ʱ�䳬�� keepAliveTime ʱ������ֹ��=0������ִ�н�����ɾ��
 *    
 * ���� BlockingQueue �������ڴ���ͱ����ύ�����񡣿���ʹ�ô˶�����ش�С���н����� 
	 *  ������е��߳����� corePoolSize���� Executor ʼ����ѡ����µ��̣߳����������Ŷӡ� 
	 *  ������е��̵߳��ڻ���� corePoolSize���� Executor ʼ����ѡ�����������У���������µ��̡߳� 
	 *  ����޷������������У��򴴽��µ��̣߳����Ǵ������̳߳��� maximumPoolSize������������£����񽫱��ܾ��� 
	 *  �Ŷ�������ͨ�ò��ԣ� 
	 *  ֱ���ύ���������е�Ĭ��ѡ���� SynchronousQueue����������ֱ���ύ���̶߳����������ǡ��ڴˣ���������ڿ�������������������̣߳�����ͼ�����������н�ʧ�ܣ���˻ṹ��һ���µ��̡߳��˲��Կ��Ա����ڴ�����ܾ����ڲ������Ե�����ʱ��������ֱ���ύͨ��Ҫ���޽� maximumPoolSizes �Ա���ܾ����ύ�����񡣵������Գ����������ܴ����ƽ������������ʱ���˲��������޽��߳̾��������Ŀ����ԡ� 
	 *  �޽���С�ʹ���޽���У����磬������Ԥ���������� LinkedBlockingQueue�������������� corePoolSize �̶߳�æʱ�������ڶ����еȴ����������������߳̾Ͳ��ᳬ�� corePoolSize������ˣ�maximumPoolSize ��ֵҲ����Ч�ˡ�����ÿ��������ȫ�������������񣬼�����ִ�л���Ӱ��ʱ���ʺ���ʹ���޽���У����磬�� Web ҳ�������С������Ŷӿ����ڴ���˲̬ͻ�����󣬵������Գ����������ܴ����ƽ������������ʱ���˲��������޽��߳̾��������Ŀ����ԡ� 
	 *  �н���С���ʹ�����޵� maximumPoolSizes ʱ���н���У��� ArrayBlockingQueue�������ڷ�ֹ��Դ�ľ������ǿ��ܽ��ѵ����Ϳ��ơ����д�С�����ش�С������Ҫ�໥���ԣ�ʹ�ô��Ͷ��к�С�ͳؿ�������޶ȵؽ��� CPU ʹ���ʡ�����ϵͳ��Դ���������л����������ǿ��ܵ����˹��������������������Ƶ�����������磬��������� I/O �߽磩����ϵͳ����Ϊ��������ɵĸ����̰߳���ʱ�䡣ʹ��С�Ͷ���ͨ��Ҫ��ϴ�ĳش�С��CPU ʹ���ʽϸߣ����ǿ����������ɽ��ܵĵ��ȿ���������Ҳ�ή����������
 * BlockingQueue ��һ���ӿڣ�����ʵ������
 *    LinkedBlockingQueue
 *    ArrayblockingQueue
 *    SynchronousQueue��  ====������� ����maxsize����ܳ��쳣
 * �̳߳ط�����
 *   shutdown���� δִ�е��߳̽���ִ�У�������µ��߳�-----������
 *   shutdownNow() ��Ҫ�ж��Ƿ�ǰ���ж�״̬������ִ�е��̼߳���ִ�У�ûִ�еĴӶ�����ɾ��
 *   isShutdown()  �Ƿ�رա�ֻҪ������shutdown�ͷ���true ������ʽ�Ĺرա�
 *   isTerminating  �����˹رգ������߳�ִ�� ����true
 *   isTerminated    ��������ִ����ɣ��ر�  ����true
 *   awaitTermination(long ,TimeUnit unit) �ȴ�ִ��ʱ����ж��̳߳��Ƿ���ֹ����====����
 *   setRejectedExceptionHandle   �Զ������񱻾ܾ�����Ϊ
 *   allowCoreThreadTimeOut()====���ú����߳��Ƿ��г�ʱ��Ч��
 *   prestartCoreThread()===�����쳣 ����һ�������߳�  ����true false
 *   prestartAllCoreThreads����===����ȫ�������߳�  ���غ����̵߳ĸ���
 *   getCompletedTaskCount()====ȡ���Ѿ�ִ����ɵ������� 
 *   remove(Thread) ===�Ƴ��̡߳����ҽ����߳�û��ִ�У���ʹ��execute����������submit������  
 *   getActiveCount()====�õ������߳�����ִ��
 *   getCompletedTaskCount����====�õ����������߳���
 *   getPoolSize()
 *   getCorePoolSize()
 *   getMaxmunPoolSize()
 *   getTaskCount();
 * �̵߳Ķ��ƣ�ThreadFactory
 *     setUncaughtExceptionHandler  �Զ����쳣����
 * �̳߳صľܾ����ԣ�
 *    AbortPolicy=====�׳��쳣
 *    CallerRunsPolicy=====�����̳߳����̴߳�������
 *    DiscardOldestPolicy====�����ȴ���õ�����  ����������ȥ
 *    DiscardPolicy=====ֱ�Ӷ������ܾ������� 
 * �̳߳���д���� ��ִ�е��߳̽��м��
 *   ��дafterExecute()
 *   ��дbeforeExecute()
 * �̳߳�����߳�����ķ�����
 *    submit()�����Խ���Callable �� Runnable��===���Է���Futuer �Ჶ���쳣
 *    execute()��ֻ��ִ��Runnable�� ���׳��쳣
 * Callable�ӿ�====���Ա������߳�
 *    ��Runnable�������ǣ�
 *       call �������з���ֵ��ʹ��Future�����ա�   run ����û�з���ֵ�����ؿ������������͡�
 *       call ���������׳��쳣  run ���������׳��쳣
 *    ��ExecutorService �����ӵ�
 *         ExecutorServiceʹ��submit����Callable������callableֻ��submit������executor��submit���Ե���Runnable ��  Callable��
 * Future=====submit�ķ���ֵ�������Ҫ�õ����ؽ�� ���������
 *    get() �õ����صĽ��===������������  
 *    isDone()   ������
 *    cancel()   ��Ҫʹ��if��Thread.currentThread().isInterrupted()��
 *    isCancelled()
 *  �Զ���ܾ����ԣ�
 *   ʵ��RejectedExecutionHandler �ӿ�
 *  Executeִ�����Ҫ�����쳣����Ҫ�߳����ò����쳣�� setUncaugthExecptionHandler
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
