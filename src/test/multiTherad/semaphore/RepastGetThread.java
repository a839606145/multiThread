package test.multiTherad.semaphore;

public class RepastGetThread extends Thread{

	private RepastPool pool;
	public RepastGetThread(RepastPool pool){
		super();
		this.pool=pool;
	}
	public void run(){
		pool.getFood();
	}
}
