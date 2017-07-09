package test.multiTherad.reentrantLock;

public class TestMain {

	public static void main(String args[]){
		ReenTrantLockService service =new ReenTrantLockService();
		while(ReenTrantLockService.number>0){
			ThreadB b=new ThreadB(service);
			b.start();
		}
	}
}
