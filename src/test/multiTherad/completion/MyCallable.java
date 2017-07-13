package test.multiTherad.completion;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private String userName;

	public MyCallable(String userName){
		super();
		this.userName=userName;
	}
	public String call() throws Exception {
		int i=1;
		Thread.sleep(3000);
		if(Thread.currentThread().isInterrupted()){
			throw new Exception("Å×³öÒì³£");
		}
		return userName;
	}

}
