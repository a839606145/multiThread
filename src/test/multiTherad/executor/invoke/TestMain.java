package test.multiTherad.executor.invoke;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService���ӿ�
 * ��Ӧ�ķ����У�submit()====����Future
 *          execute()
 *          invoke..(Collection<Runnable>)====��������Ľ��
 * invokeAny():
 *     �õ���һ��������������߳������ʹ����ifThread.currentThread.isinruptted �򲻻�ִ�С�ʵ��ʧ�ܡ�
 *      �Ѿ������˽���������߳��е��쳣���ᱻmain��׽������Ҫ���Լ��ڲ�try catch ��׽
 *      ֱ�����û�з��ؽ�������׳�����̵߳��쳣��Ϣ
 * invokeAll()��
 *     ���ػ��еĽ���������һ���׳��쳣��      
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
