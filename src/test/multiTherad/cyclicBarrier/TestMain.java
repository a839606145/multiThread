package test.multiTherad.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier ����CountDownLatch�Ĺ��� ͬʱ���Խ׶���ͬ��,
 *               ͬʱ���������ã������������֮������Ϊ0�����Լ����ȴ�ִ��
 *  ����߳�֮�䣬�κ�һ��û��������������̵߳ȴ�
 *  ��CountDownLatch��ͬ���ǣ��߳��ڵȴ�ĳ���µķ��������ִ��
 *  �����������߳��ٵ��˶�Ա�����ȥִ���������await���� ��Ҫ���ǵȱ���̡߳�
 *      �˶�Ա�ڵ������˵�����һ�������await��������Ҫ���ǻ���֮��鿴������������
 *  CyclicBarrier  �Ǽӷ�����������һ�������� ִ�У�������Ժ���һ���̲߳�����,Ҳ����һ���ٽ�ֵ
 *  CyclicBarrier��������������
 *  ������Է�����
 *  getNumberWaiting() �м����߳��Ѿ��������ϵ�
 *  isBroken() �������Ƿ�������״̬
 *  getPartie() ȡ��partis�ĸ���
 *  reset()  �������ϵ㣬���Ѿ�������̻߳��뿪���ϵ� �׳��쳣
 *  ע�⣺���߳�ʹ��interruptʱ���뿪�����ϵ㣬�����̶߳����׳��쳣
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         CyclicBarrier cyc=new CyclicBarrier(5,new Runnable(){
        	 public void run(){
        		 System.out.println("������");
        	 }
         });
         for(int i=0;i<10;i++){
        	 new ThreadTest(cyc).start();
         }
	}

}
