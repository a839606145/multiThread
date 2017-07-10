package test.multiTherad.completion;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CompletionService��ʹ��
 *   �����첽�ķ�ʽһ������������һ�ߴ�����=====
 * ExecutorCompletionService ====ʵ����
 * ������
 *    take===��õ���Future ȥ��������������Future����===  ������
 *    submit ===�ύ�߳�����
 *    poll() ��ȡ���Ƴ��¸�����������Future
 * ����˼·��ʹ��CompletionService ��װExecuteService
 * ���쳣�Ĵ���һ�����쳣����ĳ���Ҳ����ִ����
 * 
 * @author Administrator
 *
 */
public class TestMain {
	
	public static void main(String args[]){
		MyCallable call=new MyCallable("jjk");
		MyCallableB call2=new MyCallableB("llo");
		ThreadPoolExecutor pool=new ThreadPoolExecutor(2,4,5,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		ExecutorCompletionService service=new ExecutorCompletionService(pool);
		service.submit(call2);
		service.submit(call);
		try{
			for(int i=0;i<2;i++){
				System.out.println(service.take().get());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end");
	}

}
