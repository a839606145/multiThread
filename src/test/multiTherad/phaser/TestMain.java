package test.multiTherad.phaser;

import java.util.concurrent.Phaser;
/**
 * Phaser ���ú�CountDownLatch һ�����ظ�
 * ������
 *     arriveAndAwaitAdvance  ����ȴ�һ��ʱ��Ȼ�󵽴���������ִ�С����������߳����ﵽҪ�󡿡��߳���������������
 *     arriveAndDeregister   �����˳�������ʹparties-1
 *     getPhase() �Ѿ�����ڼ�������
 *     onAdvance() ͨ���µ�����ʱ����
 *     getRegisteredParties  �õ�ע���parties������
 *     register() ��̬���һ��parties
 *     bulkRegister ��̬�������parties������
 *     getArrivedParties
 *     getUnarriveredParties
 *     arrive() ���������������ִ��
 *     awaitAdvance��int ���������ֵ�͵�ǰgetPhase һ����ʱ�� �ȴ����������ִ�� �����ж�
 *     awaitAdvanceInterruptibly ���ж� ������һ�� ���� �Ƿ����㵱ǰparties��
 *     forceTermination �����Ϲ���ʧЧ
 *     isTerminated �ж��Ƿ������״̬
 *     
 *     
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String[] args) throws InterruptedException {
		Phaser phaser=new Phaser(3){
			protected boolean onAdvance(int phase,int registeredParties){
				System.out.println("onAdvance ������");
				return true;
			}
		};
		PrintTools.phaser=phaser;
		ThreadA a=new ThreadA(phaser);
		a.setName("A");
		a.start();
		ThreadB b=new ThreadB(phaser);
		b.setName("B");
		b.start();
		Thread.sleep(1000);
	/*	ThreadC C=new ThreadC(phaser);
		C.setName("C");
		C.start();*/
		phaser.forceTermination();
		System.out.println(phaser.isTerminated());
		

	}

}
