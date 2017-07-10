package test.multiTherad.completion;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CompletionService的使用
 *   是以异步的方式一边生产新任务，一边处理结果=====
 * ExecutorCompletionService ====实现类
 * 方法：
 *    take===则得到了Future 去得最先完成任务的Future对象===  阻塞的
 *    submit ===提交线程任务
 *    poll() 获取并移除下个已完成任务的Future
 * 整体思路：使用CompletionService 包装ExecuteService
 * 对异常的处理：一旦有异常后面的程序也不会执行了
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
