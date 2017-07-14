package test.multiTherad.scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * ��ʱ�����
 *  Timer���Զ��еķ�ʽ�����̵߳�
 *  ScheduledExecutorService �ӿ�  ��ʱ�����̳߳�
 *  ScheduledThreadPoolExecutor ��ScheduledExecutorService��ʵ���࣬ͬʱ�̳���ThreadPoolExecutor
 * ScheduledThreadPoolExecutor 
 *       ʹ��schedule���������ӳ�ִ��===���ؽ��ʹ��ScheduleFuture����
 *       ʹ��scheduleAtFixedRate  ʵ��������ִ��[����Runnable]
 *       ʹ��scheduleWithFixedDelay  ʵ��������ִ�� ��������֮��ļ��  ���ؽ��ScheduleFuture
 *       ʹ��scheduleAtFixedRate    ʵ������������ ���ؽ��ScheduleFuture
 *      scheduleWithFixedDelay  scheduleAtFixedRate 
 *             ʵ��������������Ը���getQueue�����õ��������е�����,ͨ��remove��ͨ��Future�Ƴ��� �Ƴ���ʱ����
 *    	  setExecuteExistingDelayedTasksAfterShutdownPolicy  ����ִ��shutdown�������Ƿ��������
 *        setContinueExistingPeriodicTasksAfterShutdownPolicy   ����������رպ��ظ�ִ��
 *     ScheduleFuture ���� cancel ȡ�����񣬶����д��ڡ�����ִ�е�����Ҫ���isInterrupe һ��ʹ�ã����������������
 *     setRemoveOnCancelPolicy ����ȡ�����ڶ�����ɾ��
 * @author Administrato
 *
 */
public class TestMain {

	public static void main(String[] args) throws Exception, ExecutionException {
		// TODO Auto-generated method stub
		ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
		List<Callable> list=new ArrayList();
		list.add(new MyCallableBTest());
		list.add(new MyCallableATest());
		service.scheduleAtFixedRate(new MyRunnable(),4l,4L,TimeUnit.SECONDS);
		//ScheduledFuture<String> future2=service.schedule(list.get(1),4L,TimeUnit.SECONDS);
	    //System.out.println(future1.get());
	    //System.out.println(future2.get());
	}

}
