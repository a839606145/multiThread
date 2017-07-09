package test.multiTherad.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RepastPool {
	
	private int getSemiphoreSize=20;
	private int setSemiphoreSize=10;
	private Semaphore setSemi=new Semaphore(setSemiphoreSize);
	private Semaphore getSemi=new Semaphore(getSemiphoreSize);
	private ReentrantLock lock=new ReentrantLock();
	private Condition setCondition=lock.newCondition();
	private Condition getCondition=lock.newCondition();
	private String[] obj=new String[4];
	
	public boolean isFull(){
		boolean falg=true;
		for(int i=0;i<4;i++){
			if(obj[i]==null){
				falg=false;
				break;
			}
		}
		return falg;
	}
	
	public boolean isEmpty(){
		boolean falg=true;
		for(int i=0;i<4;i++){
			if(obj[i]!=null){
				falg=false;
				break;
			}
		}
		return falg;
	}
	
	public void putFood(){
		try{
			setSemi.acquire();
			lock.lock();
			while(isFull()){
				setCondition.await();
			}
			for(int i=0;i<4;i++){
				if(obj[i]==null){
					obj[i]=new String();
					System.out.println(Thread.currentThread().getName()+"putFood():"+Thread.currentThread().getName());
					obj[i]=Thread.currentThread().getName();
					break;
				}
			}
			getCondition.signalAll();
		   lock.unlock();
			
		}catch (Exception e) {
		}finally{
			setSemi.release();
		}
	}
	
	public String getFood(){
		String result=null;
		try{
			getSemi.acquire();
			lock.unlock();
			while(isEmpty()){
				getCondition.await();
			}
			for(int i=0;i<4;i++){
				if(obj[i]!=null){
					result=obj[i];
					System.out.println(Thread.currentThread().getName()+"getFood():"+result);
					obj[i]=null;
					break;
				}
			}
			setCondition.signalAll();
			lock.unlock();
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			getSemi.release();
		}
		return result;
	}
}
