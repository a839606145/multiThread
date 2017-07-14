package test.multiTherad.scheduled;

import java.util.concurrent.Callable;

public class MyCallableATest implements Callable<String>{

	public String call() throws Exception {
		System.out.println("A begin "+System.currentTimeMillis());
		Thread.sleep(3000);
		System.out.println("A end "+System.currentTimeMillis());
		return "return A";
	}

}
