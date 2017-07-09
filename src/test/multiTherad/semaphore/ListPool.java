package test.multiTherad.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListPool {

	private int maxpoolSize=3;
	private int semaphorePermits=5;
	private List<String> list=new ArrayList<String>();
	private Semaphore semaphore=new Semaphore(semaphorePermits);
	private  ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
	
	public ListPool(){
		super();
		for(int i=0;i<maxpoolSize;i++){
			list.add("hello"+(i+1));
		}
	}
	public String get(){
		String getString=null;
		try{
			semaphore.acquire();
			lock.lock();
			while(list.size()==0){
				condition.await();
			}
			getString=list.remove(0);
			lock.unlock();
		}catch (Exception e) {
		}
		return getString;
	}
	
	public void put(String s){
		try{
			lock.lock();
			list.add(s);
			condition.signalAll();
			lock.unlock();
		}catch (Exception e) {
		}finally{
			semaphore.release();
		}
	}
}
