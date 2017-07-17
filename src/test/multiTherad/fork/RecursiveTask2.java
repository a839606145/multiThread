package test.multiTherad.fork;

import java.util.concurrent.RecursiveTask;

public class RecursiveTask2 extends RecursiveTask<String>{

	private int beginValue;
	private int endValue;
	public RecursiveTask2(int beginValue,int endValue){
		this.beginValue=beginValue;
		this.endValue=endValue;
	}
	protected String compute() {
		System.out.println(Thread.currentThread().getName()+"-------");
		if(endValue-beginValue>2){
			int midValue=(endValue+beginValue)/2;
			RecursiveTask2 task1=new RecursiveTask2(beginValue, midValue);
			RecursiveTask2 task2=new RecursiveTask2(midValue+1, endValue);
			this.invokeAll(task1,task2);
			return task1.join()+task2.join();
		}else{
			String retureString="";
			for(int i=beginValue;i<=endValue;i++){
				retureString=retureString+i;
			}
			System.out.println("·µ»Ø");
			return retureString;
		}
	}

}
