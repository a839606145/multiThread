package test.multiTherad.semaphore;
/**
 * semaphore  允许同时进入的线程个数
 * 主要方法 acquire（） release()
 * 		在需要限制的方法所在的类中添加Semaphore对象
 * 		在方法中将同步的方法 使用acquire 和release 控制
 *    	同时可以使用tryAcquire() 尝试获取，如果获取不到则返回false；因此是非阻塞的。
 *      同时可以使用tryAcquire(long ,permits) 表示在指定时间内获取，如果获取不到则返回false
 * 构造方法：
 *        初始的permits 是初始化的，可以动态添加===使用release(int permits)
 *        同时可以设置是否是公平的锁
 * acquier时 可以设置登入等待的线程不能中断，即线程的interrupt 不管用
 * 获取相关参数：
 * 		availablePremits() ===得到当前可允许的premits
 * 		drainPermits() ==== 返回可用的许可数，同时这是为0
 * 		getQueneLength()===取得等待许可的线程数
 * 		hasQueuedThreads()==判断有没有线程在等待许可
 * 
 * 注意：当线程sleep的时候，此时调用interrupt 会报错 
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
