package test.multiTherad.countDownLatch;

public class ThreadDoTest extends Thread {
	private DownService downService;
	public ThreadDoTest( DownService downService){
		super();
		this.downService=downService;
	}
	
	public void run(){
		downService.doMethod();
	}
	
}
