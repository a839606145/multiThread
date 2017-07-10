package test.multiTherad.exchange;

import java.util.concurrent.Exchanger;
/**
 * Exchanger 用于在两个线程之间传递消息
 * 每一个线程 先发送消息 然后等待消息,等到消息后进入下面执行，没有消息时则会阻塞等待消息
 * 这个只可以在两个[双数]线程之间传递，多线呈现则会出现死锁
 * @author Administrator
 *
 */
public class ExchangeerTest {

	public static void main(String args[]){
		Exchanger changer=new Exchanger();
		ExchangeThreadA a=new ExchangeThreadA(changer);
		ExchangeThreadB b=new ExchangeThreadB(changer);
		ExchangeThreadB c=new ExchangeThreadB(changer);
		ExchangeThreadA d=new ExchangeThreadA(changer);
		a.start();
		b.start();
		c.start();
		d.start();
	}
}
