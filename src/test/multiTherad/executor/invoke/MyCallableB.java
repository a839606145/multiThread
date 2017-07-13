package test.multiTherad.executor.invoke;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String>{

	public String call() throws Exception {
		System.out.println("进入B本方法");
		for(int i=0;i<12345;i++){
			Math.random();
			Math.random();
			Math.random();
			Math.random();
			Math.random();
			System.out.println("B"+(i+1));
		}
		if(1==1){
			try{
			int i=Integer.parseInt("a");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//不含有这个会继续执行
			/*if(Thread.currentThread().isInterrupted()==false){
				for(int i=0;i<223456;i++){
					Math.random();
					Math.random();
					Math.random();
					Math.random();
					Math.random();
					System.out.println("B"+(i+1));
				}
			}else{
				System.out.println("抛出异常");
				throw new InterruptedException();
			}*/
		return "B";
	}

}
