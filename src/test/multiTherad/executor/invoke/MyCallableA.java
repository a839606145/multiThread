package test.multiTherad.executor.invoke;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String>{

	public String call() throws Exception {
		System.out.println("进入A本方法");
		for(int i=0;i<12345;i++){
			//System.out.println("A"+i);
			int a=1;
		}
		int i=Integer.parseInt("a");
		return "A";
	}

}
