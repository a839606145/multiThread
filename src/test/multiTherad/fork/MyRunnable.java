package test.multiTherad.fork;

public class MyRunnable implements Runnable{

	private UserInfo userInfo;

	public MyRunnable(UserInfo userInfo){
		this.userInfo=userInfo;
	}
	public void run() {
		try{
			userInfo.setName("����ֵ");
			System.out.println("�������");
			Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
