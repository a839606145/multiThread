package test.multiTherad.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReenTrantLock
 * @author lzx
 *
 */
public class ReenTrantLockService {
	public static int number=10;
	private ReentrantLock reentrantlock=new ReentrantLock();
	public void sayHello(){
		System.out.println("进入");
		reentrantlock.lock();
		if(number>0){
			System.out.println(Thread.currentThread().getName()+":"+number--);
		}
		reentrantlock.unlock();
		System.out.println("出去");
	}

}
