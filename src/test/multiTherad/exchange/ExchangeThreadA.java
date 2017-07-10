package test.multiTherad.exchange;

import java.util.concurrent.Exchanger;

public class ExchangeThreadA extends Thread{

	private Exchanger exchange;
	public ExchangeThreadA(Exchanger x){
		super();
		exchange=x;
	}
	
	public void run(){
		try {
			System.out.println("ThreadA收到信息"+exchange.exchange("helloA"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
