package test.multiTherad.semaphore;

public class ThreadTest extends Thread {
	
	private Service service;
	
	public ThreadTest(Service service){
		super();
		this.service=service;
	}

	public void run() {
		service.testMehod();
	}

}
