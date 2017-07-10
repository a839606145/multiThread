package test.multiTherad.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class ThreadTest extends Thread{

	private CyclicBarrier cyc;
	public ThreadTest(CyclicBarrier cyc){
		super();
		this.cyc=cyc;
	}
	public void run(){
		try{
			System.out.println(Thread.currentThread().getName()+"µ½´ï");
			cyc.await();
			
		}catch (Exception e) {
		}
	}
	
}
