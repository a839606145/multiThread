package test.multiTherad.executor.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestMain {

	public static void main(String args[]) throws Exception, ExecutionException{
	    Callable call=new Callable<String>() {
	
			public String call() throws Exception {
				if(Thread.currentThread().isInterrupted()==true){
					throw new InterruptedException();
				}
				Thread.sleep(10000);
				return "ok";
			}
		};
		
		ThreadPoolExecutor pool=new ThreadPoolExecutor(1,1,5,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		Future f=pool.submit(call);
		Future f2=pool.submit(call);
		System.out.println(f2.cancel(true));
		System.out.println(f.get());
		System.out.println("end");
		
	}
}
