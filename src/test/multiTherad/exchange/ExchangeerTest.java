package test.multiTherad.exchange;

import java.util.concurrent.Exchanger;
/**
 * Exchanger �����������߳�֮�䴫����Ϣ
 * ÿһ���߳� �ȷ�����Ϣ Ȼ��ȴ���Ϣ,�ȵ���Ϣ���������ִ�У�û����Ϣʱ��������ȴ���Ϣ
 * ���ֻ����������[˫��]�߳�֮�䴫�ݣ����߳�������������
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
