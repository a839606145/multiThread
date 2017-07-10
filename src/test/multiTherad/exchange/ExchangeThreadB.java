package test.multiTherad.exchange;

import java.util.concurrent.Exchanger;

public class ExchangeThreadB extends Thread{

	private Exchanger exchange;
	public ExchangeThreadB(Exchanger x){
		super();
		exchange=x;
	}
	
	public void run(){
		try {
			System.out.println("ThreadB收到信息"+exchange.exchange("helloB"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
