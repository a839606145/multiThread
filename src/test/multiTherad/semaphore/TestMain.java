package test.multiTherad.semaphore;
/**
 * semaphore  ����ͬʱ������̸߳���
 * ��Ҫ���� acquire���� release()
 * 		����Ҫ���Ƶķ������ڵ��������Semaphore����
 * 		�ڷ����н�ͬ���ķ��� ʹ��acquire ��release ����
 *    	ͬʱ����ʹ��tryAcquire() ���Ի�ȡ�������ȡ�����򷵻�false������Ƿ������ġ�
 *      ͬʱ����ʹ��tryAcquire(long ,permits) ��ʾ��ָ��ʱ���ڻ�ȡ�������ȡ�����򷵻�false
 * ���췽����
 *        ��ʼ��permits �ǳ�ʼ���ģ����Զ�̬���===ʹ��release(int permits)
 *        ͬʱ���������Ƿ��ǹ�ƽ����
 * acquierʱ �������õ���ȴ����̲߳����жϣ����̵߳�interrupt ������
 * ��ȡ��ز�����
 * 		availablePremits() ===�õ���ǰ�������premits
 * 		drainPermits() ==== ���ؿ��õ��������ͬʱ����Ϊ0
 * 		getQueneLength()===ȡ�õȴ���ɵ��߳���
 * 		hasQueuedThreads()==�ж���û���߳��ڵȴ����
 * 
 * ע�⣺���߳�sleep��ʱ�򣬴�ʱ����interrupt �ᱨ�� 
 * 
 * @author lzx
 *
 */
public class TestMain {

	public static void main(String[] args) throws Exception {
		Service s=new Service();
		ThreadTest a=new ThreadTest(s);
		a.setName("A");
		a.start();
		ThreadTest b=new ThreadTest(s);
		b.setName("B");
		b.start();
		Thread.sleep(2);
		b.interrupt(); 
		System.out.println(" b is interrupt");

	}

}
