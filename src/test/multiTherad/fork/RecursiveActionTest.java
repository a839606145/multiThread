package test.multiTherad.fork;

import java.util.concurrent.RecursiveAction;

public class RecursiveActionTest extends RecursiveAction{
	private int beginValue;
	private int endValue;
	public RecursiveActionTest(int beginValue,int endValue){
		super();
		this.beginValue=beginValue;
		this.endValue=endValue;
	}
	protected void compute() {
		System.out.println(Thread.currentThread().getName()+"------------");
		if(endValue-beginValue>2){
			int middelNum=(beginValue+endValue)/2;
			RecursiveActionTest test=new RecursiveActionTest(beginValue, middelNum);
			RecursiveActionTest test2=new RecursiveActionTest(middelNum, endValue);
			this.invokeAll(test,test2);
		}else{
			System.out.println("打印组合为"+beginValue+"-"+endValue);
		}
	}

}
