package test.multiTherad.fork;

public class MyRunnable implements Runnable{

	private UserInfo userInfo;

	public MyRunnable(UserInfo userInfo){
		this.userInfo=userInfo;
	}
	public void run() {
		try{
			userInfo.setName("设置值");
			System.out.println("设置完成");
			Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
