package test.multiTherad.executor.invoke;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String>{

	public String call() throws Exception {
		System.out.println("����B������");
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
		//��������������ִ��
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
				System.out.println("�׳��쳣");
				throw new InterruptedException();
			}*/
		return "B";
	}

}
