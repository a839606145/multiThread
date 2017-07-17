package test.multiTherad.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * ForkJoinPool ����� ʹ��submit ���ύ����
 * ForkJoinTask ����ִ�нӿ� �ύ���񷵻ص���[Future��ʵ����]
 *      CountedCompleter
 *      RecurisiveAction �޷���ֵ,��ִ��һ������[�������ģ����main�̹߳رգ���Ҳ�ر�]
 *      RecursiveTask �з���ֵ ���join �� get ʹ��[join get ���쳣����ʱ��һ��  get�������쳣 mainֱ�Ӳ��� join��ֱ���׳� ]
 *      RecursiveTask �е�compute ���������׳��쳣
 *  ForkJoinPool ���ķ�����
 *      execute�� �߳����첽�ķ�ʽ����    [����ִ�� RecurisiveAction  RecurisiveService  Runnable] û�з���ֵ
 *      submit���з���ֵ������ִ��RecursiveAction RecurisiveService Runnable Callable��
 *      submit���߳�����࣬���ض��󣩷���ΪForkJoinTask��get��ȡ
 *      invoke�������������з���ֵ������ֵͨ�������ȡ
 *      invokeAll��Collect<> Callable��
 *      shutdown()==�������ж�Ч����sleep�е��߳�û���׳��쳣��ÿ��������������ֱ�������������ύ�µ�����[������get������]
 *      shutdownNow()===�����isInterruptedֹͣ��ǰ����ִ�е����񣬲����ύ�����񡿡���󣬵���get����
 *      shutdownNow()===�������isInterrupted,��ǰ����ִ�н����������ύ������
 *      isTerminating����
 *      isTerminated()
 *      isShutdown()
 *      shutdowm �����ʹ��awaitTermination �ȴ�һ��ʱ����������
 *      һЩ�̳߳�״̬������
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
				 System.out.println("��ʼִ��");
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
