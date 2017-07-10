package test.multiTherad.completion;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String>{

	private String userName;

	public MyCallableB(String userName){
		super();
		this.userName=userName;
	}
	public String call() throws Exception {
		int i=1;
		Thread.sleep(3000);
		return userName;
	}

}
