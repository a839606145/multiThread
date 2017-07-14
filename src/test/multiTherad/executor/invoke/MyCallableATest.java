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
			System.out.println("A 报错了！");
			throw new Exception("出现异常了");
		}
		return "return A";
	}

}
