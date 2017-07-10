package test.multiTherad.countDownLatch;
/**
 * countDownLatch  判断count是否为0 为0 则执行，不为0 则wait状态 
 * countDownLatch 可以当成一个临界值，控制同步访问自己的count
 * @author Administrator
 *
 */
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DownService service=new DownService();
		ThreadDoTest doTest=new ThreadDoTest(service);
		ThreadDownTest a=new ThreadDownTest(service);
		ThreadDownTest b=new ThreadDownTest(service);
		doTest.start();
		a.start();
		b.start();
	}

}
