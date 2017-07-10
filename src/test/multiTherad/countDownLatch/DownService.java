package test.multiTherad.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class DownService {

	private CountDownLatch downLatch=new CountDownLatch(2);
	public void doMethod(){
		try{
			downLatch.await();
			System.out.println(System.currentTimeMillis()+"2个线程已经到达");
			
		}catch (Exception e) {
		}
	}
	
	public void countDown(){
		System.out.println(System.currentTimeMillis()+Thread.currentThread().getName());
		downLatch.countDown();
	}
}
