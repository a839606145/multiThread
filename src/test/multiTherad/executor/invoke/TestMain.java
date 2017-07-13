package test.multiTherad.executor.invoke;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService：接口
 * 相应的方法有：submit()====返回Future
 *          execute()
 *          invoke..(Collection<Runnable>)====返回任务的结果
 * invokeAny():
 *     得到第一个结果后，在其他线程中如何使用了ifThread.currentThread.isinruptted 则不会执行【实验失败】
 *      已经返回了结果，其他线程中的异常不会被main捕捉到，需要在自己内部try catch 捕捉
 *      直到最后都没有返回结果，则抛出最后线程的异常信息
 * invokeAll()：
 *     返回会有的结果，如果有一个抛出异常，      
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String[] args) {
		try{
			ExecutorService service=Executors.newCachedThreadPool();
			List list=new ArrayList();
			list.add(new MyCallableA());
			list.add(new MyCallableB());
			List<String> s=service.invokeAll(list);
			System.out.println("============"+s);
			System.out.println("------------------");
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
