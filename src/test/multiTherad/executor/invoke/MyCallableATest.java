package test.multiTherad.executor.invoke;

import java.util.concurrent.Callable;

public class MyCallableATest implements Callable<String>{

	public String call() throws Exception {
		System.out.println("A begin "+System.currentTimeMillis());
		for(int i=0;i<123;i++){
			Math.random();
			Math.random();
			Math.random();
			Math.random();
			System.out.println("A"+(i+1));
		}
		System.out.println("A end "+System.currentTimeMillis());
		if(1==1){
			System.out.println("A �����ˣ�");
			throw new Exception("�����쳣��");
		}
		return "return A";
	}

}
