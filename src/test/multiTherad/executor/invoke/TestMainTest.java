package test.multiTherad.executor.invoke;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestMainTest {
	public static void main(String args[]){
		try{
			ExecutorService service=Executors.newCachedThreadPool();
			List list=new ArrayList();
			list.add(new MyCallableBTest());
			list.add(new MyCallableATest());
			List<Future<String>> s=service.invokeAll(list);
			System.out.println("============");
			System.out.println("------------------");
			for(int i=0;i<s.size();i++){
				System.out.println("Òì³£"+s.get(i).get());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
