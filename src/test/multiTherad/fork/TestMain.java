package test.multiTherad.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * ForkJoinPool 任务池
 * ForkJoinTask 任务执行接口
 *      CountedCompleter
 *      RecurisiveAction 无返回值,仅执行一次任务[非阻塞的，如果main线程关闭，其也关闭]
 *      RecursiveTask 有返回值 结合join 和 get 使用[join get 在异常处理时不一样  get子任务异常 main直接捕获 join则直接抛出 ]
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String args[]) throws Exception{
		ForkJoinPool pool=new ForkJoinPool();
		//pool.submit(new RecursiveActionTest(5,40));
		RecursiveTaskTest test=new RecursiveTaskTest();
		System.out.println(test.hashCode());
		ForkJoinTask task=pool.submit(test);
		System.out.println(task.hashCode()+"--"+task.join());
		Thread.sleep(5000);
	}
}
