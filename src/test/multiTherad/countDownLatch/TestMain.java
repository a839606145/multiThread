package test.multiTherad.countDownLatch;
/**
 * countDownLatch  �ж�count�Ƿ�Ϊ0 Ϊ0 ��ִ�У���Ϊ0 ��wait״̬ 
 * countDownLatch ���Ե���һ���ٽ�ֵ������ͬ�������Լ���count
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
