package test.multiTherad.countDownLatch;

public class ThreadDownTest extends Thread{

	private DownService downService;
	public ThreadDownTest(DownService downService){
	    super();
		this.downService=downService;
	}
	
	public void run(){
		downService.countDown();
	}
	
}
