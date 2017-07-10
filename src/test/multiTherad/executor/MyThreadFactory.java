package test.multiTherad.executor;

import java.io.UncheckedIOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	public Thread newThread(Runnable arg0) {
		Thread thread=new Thread(arg0);
		thread.setName("hello"+System.currentTimeMillis());
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("自定义异常处理");
			}
		});
		return thread;
	}

	

}
