package test.multiTherad.fork;

import java.util.concurrent.RecursiveTask;

public class RecursiveTaskTest extends RecursiveTask{

	protected String compute() {
		System.out.println("helo");
		return "hello";
	}


}
