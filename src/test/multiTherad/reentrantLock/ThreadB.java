package test.multiTherad.reentrantLock;

public class ThreadB extends Thread{

	ReenTrantLockService service;
	public ThreadB(ReenTrantLockService service){
		super();
		this.service=service;
	}
	public void run(){
		service.sayHello();
	}
}
