package test.multiTherad.executor.invoke;

import java.util.concurrent.Callable;

public class MyCallableBTest  implements Callable<String>{

	public String call() throws Exception {
		System.out.println("B begin "+System.currentTimeMillis());
		for(int i=0;i<123456;i++){
			Math.random();
			Math.random();
			Math.random();
			Math.random();
			System.out.println("B"+(i+1));
		}
		System.out.println("B end "+System.currentTimeMillis());
		/*if(1==1){
			System.out.println("B �����ˣ�");
			throw new Exception("�����쳣��");
		}*/
		return "return B";
	}

}
