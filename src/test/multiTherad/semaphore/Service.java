package test.multiTherad.semaphore;

import java.util.concurrent.Semaphore;
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
public class Service {

	private Semaphore semaphore=new Semaphore(1);
	
	public void testMehod(){
		try{
			//semaphore.acquire();
			semaphore.acquireUninterruptibly();//�����ж�
			System.out.println(Thread.currentThread().getName()+":in:"+System.currentTimeMillis());
		    Thread.sleep(3000);
		    System.out.println(Thread.currentThread().getName()+":out:"+System.currentTimeMillis());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
	}
}
