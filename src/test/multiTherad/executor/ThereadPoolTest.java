package test.multiTherad.executor;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThereadPoolTest {

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
		
		ThreadPoolExecutor pool=new ThreadPoolExecutor(2,4,5,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		System.out.println(pool.prestartAllCoreThreads());
		pool.execute(able);
		pool.execute(able);
		System.out.println(pool.prestartCoreThread());
		pool.execute(able);
		pool.execute(able);
		Thread.sleep(300);
		System.out.println(pool.getCorePoolSize());
		System.out.println(pool.getPoolSize());
		System.out.println(pool.getQueue().size());
		List list=pool.shutdownNow();
		System.out.println("dddd"+list.size());
		Thread.sleep(1000);
		System.out.println("-------------");
		System.out.println(pool.getCorePoolSize());
		System.out.println(pool.getPoolSize());
		System.out.println(pool.getQueue().size());
		
	}
}
