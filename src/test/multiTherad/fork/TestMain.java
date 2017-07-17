package test.multiTherad.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * ForkJoinPool �����
 * ForkJoinTask ����ִ�нӿ�
 *      CountedCompleter
 *      RecurisiveAction �޷���ֵ,��ִ��һ������[�������ģ����main�̹߳رգ���Ҳ�ر�]
 *      RecursiveTask �з���ֵ ���join �� get ʹ��[join get ���쳣����ʱ��һ��  get�������쳣 mainֱ�Ӳ��� join��ֱ���׳� ]
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
