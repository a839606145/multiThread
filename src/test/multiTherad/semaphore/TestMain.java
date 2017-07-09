package test.multiTherad.semaphore;

public class TestMain {

	public static void main(String[] args) throws Exception {
		Service s=new Service();
		ThreadTest a=new ThreadTest(s);
		a.setName("A");
		a.start();
		ThreadTest b=new ThreadTest(s);
		b.setName("B");
		b.start();
		Thread.sleep(2);
		b.interrupt(); 
		System.out.println(" b is interrupt");

	}

}
