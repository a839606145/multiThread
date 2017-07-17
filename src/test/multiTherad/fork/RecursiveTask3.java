package test.multiTherad.fork;

import java.util.concurrent.RecursiveTask;

public class RecursiveTask3 extends RecursiveTask<Integer>{

	private int beginValue;
	private int endValue;
	public RecursiveTask3(int beginValue,int endValue){
		this.beginValue=beginValue;
		this.endValue=endValue;
	}
	protected Integer compute() {
		System.out.println(Thread.currentThread().getName()+"-------");
		if(endValue-beginValue>2){
			int midValue=(endValue+beginValue)/2;
			RecursiveTask3 task1=new RecursiveTask3(beginValue, midValue);
			RecursiveTask3 task2=new RecursiveTask3(midValue+1, endValue);
			this.invokeAll(task1,task2);
			return task1.join()+task2.join();
		}else{
			Integer retureString=0;
			for(int i=beginValue;i<=endValue;i++){
				retureString=retureString+i;
			}
			return retureString;
		}
	}

}
