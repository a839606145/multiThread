package test.multiTherad.semaphore;

public class RepastSetThread extends Thread{

	private RepastPool pool;
	public RepastSetThread(RepastPool pool){
		super();
		this.pool=pool;
	}
	public void run(){
		pool.putFood();
	}
}
