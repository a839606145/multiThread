package test.multiTherad.phaser;

import java.util.concurrent.Phaser;
/**
 * Phaser 作用和CountDownLatch 一部分重复
 * 方法：
 *     arriveAndAwaitAdvance  到达等待一段时间然后到达条件继续执行【条件就是线程数达到要求】【线程数不够会阻塞】
 *     arriveAndDeregister   到达退出比赛，使parties-1
 *     getPhase() 已经到达第几个屏障
 *     onAdvance() 通过新的屏障时调用
 *     getRegisteredParties  得到注册的parties的数量
 *     register() 动态添加一个parties
 *     bulkRegister 动态批量添加parties的数量
 *     getArrivedParties
 *     getUnarriveredParties
 *     arrive() 添加屏障数，继续执行
 *     awaitAdvance（int ）当传入的值和当前getPhase 一样的时候 等待，否则继续执行 不可中断
 *     awaitAdvanceInterruptibly 可中断 与上面一样 还有 是否满足当前parties数
 *     forceTermination 是屏障功能失效
 *     isTerminated 判断是否呈销毁状态
 *     
 *     
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String[] args) throws InterruptedException {
		Phaser phaser=new Phaser(3){
			protected boolean onAdvance(int phase,int registeredParties){
				System.out.println("onAdvance 被调用");
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
