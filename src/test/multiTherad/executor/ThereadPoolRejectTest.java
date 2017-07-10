package test.multiTherad.executor;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThereadPoolRejectTest {

	public static void main(String  args[]) throws Exception{
		Runnable able=new Runnable() {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		ThreadPoolExecutor pool=new ThreadPoolExecutor(2,2,5,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(1),new ThreadPoolExecutor.DiscardOldestPolicy());
		pool.execute(able);
		pool.execute(able);
		pool.execute(able);
		pool.execute(able);
		Thread.sleep(300);
		System.out.println(pool.getCorePoolSize());
		System.out.println(pool.getPoolSize());
		System.out.println(pool.getQueue().size());
		Thread.sleep(1000);
		System.out.println("-------------");
		System.out.println(pool.getCorePoolSize());
		System.out.println(pool.getPoolSize());
		System.out.println(pool.getQueue().size());
		
	}
}
