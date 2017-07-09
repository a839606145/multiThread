package test.multiTherad.semaphore;

public class PoolMain {

	public static void main(String args[]){
		PoolThread[] threadArray=new PoolThread[10];
		ListPool pool= new ListPool();
		for(int i=0;i<threadArray.length;i++){
			threadArray[i]=new PoolThread(pool);
		}
		for(int i=0;i<threadArray.length;i++){
			threadArray[i].start();
		}
	}
}
