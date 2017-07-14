package test.multiTherad.scheduled;

public class MyRunnable implements Runnable{

	public void run() { 
		System.out.println("beigin=" + System.currentTimeMillis());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end=" + System.currentTimeMillis());
	}

}
