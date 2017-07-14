package test.multiTherad.scheduled;

import java.util.concurrent.Callable;

public class MyCallableBTest  implements Callable<String>{

	public String call() throws Exception {
		System.out.println("B begin "+System.currentTimeMillis());
		System.out.println("B end "+System.currentTimeMillis());
		return "return B";
	}

}
