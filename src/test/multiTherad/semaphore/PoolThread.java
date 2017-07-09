package test.multiTherad.semaphore;

public class PoolThread extends Thread{

	private ListPool listPool;
	public PoolThread(ListPool pool){
		super();
		this.listPool=pool;
	}
	public void run(){
		for(int i=0;i<Integer.MAX_VALUE;i++){
			String getString=listPool.get();
			System.out.println(Thread.currentThread().getName()+"::"+getString);
			listPool.put(getString);
		}
	}
}
