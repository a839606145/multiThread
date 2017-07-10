package test.multiTherad.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 具有CountDownLatch的功能 同时可以阶段性同步,
 *               同时他可以重用，即当满足个数之后，重置为0，可以继续等待执行
 *  多个线程之间，任何一个没有完成任务，所在线程等待
 *  与CountDownLatch不同的是，线程在等待某件事的发生后才能执行
 *  举例：教练线程再等运动员到达后去执行启跑命令【await方法 主要还是等别的线程】
 *      运动员在等所有人到达后才一起出发【await方法，主要还是互相之间查看满足条件不】
 *  CyclicBarrier  是加法操作，满足一定数量后 执行（本身可以含有一个线程操作）,也包含一个临界值
 *  CyclicBarrier具有屏障重置性
 *  相关属性方法：
 *  getNumberWaiting() 有几个线程已经到达屏障点
 *  isBroken() 看屏障是否属于损坏状态
 *  getPartie() 取得partis的个数
 *  reset()  重置屏障点，则已经进入的线程会离开屏障点 抛出异常
 *  注意：当线程使用interrupt时，离开了屏障点，其他线程都会抛出异常
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         CyclicBarrier cyc=new CyclicBarrier(5,new Runnable(){
        	 public void run(){
        		 System.out.println("开饭了");
        	 }
         });
         for(int i=0;i<10;i++){
        	 new ThreadTest(cyc).start();
         }
	}

}
