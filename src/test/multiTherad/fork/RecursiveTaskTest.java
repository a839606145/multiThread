package test.multiTherad.fork;

import java.util.concurrent.RecursiveTask;

public class RecursiveTaskTest extends RecursiveTask{

	protected String compute() {
		try {
			System.out.println(Thread.currentThread().getName()+": beigin: "+System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+": end: "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello";
	}


}
