package test.multiTherad.scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务池
 *  Timer是以队列的方式管理线程的
 *  ScheduledExecutorService 接口  定时任务线程池
 *  ScheduledThreadPoolExecutor 是ScheduledExecutorService的实现类，同时继承了ThreadPoolExecutor
 * ScheduledThreadPoolExecutor 
 *       使用schedule（）进行延迟执行===返回结果使用ScheduleFuture接收
 *       使用scheduleAtFixedRate  实现周期性执行[必须Runnable]
 *       使用scheduleWithFixedDelay  实现周期性执行 两个任务之间的间隔  返回结果ScheduleFuture
 *       使用scheduleAtFixedRate    实现周期性任务 返回结果ScheduleFuture
 *      scheduleWithFixedDelay  scheduleAtFixedRate 
 *             实现周期性任务可以根据getQueue方法得到将来运行的任务,通过remove【通过Future移除】 移除定时任务
 *    	  setExecuteExistingDelayedTasksAfterShutdownPolicy  设置执行shutdown后，任务是否继续运行
 *        setContinueExistingPeriodicTasksAfterShutdownPolicy   周期性任务关闭后重复执行
 *     ScheduleFuture 方法 cancel 取消任务，队列中存在【正在执行的任务要结合isInterrupe 一起使用，可以让任务结束】
 *     setRemoveOnCancelPolicy 任务取消后在队列中删除
 * @author Administrato
 *
 */
public class TestMain {

	public static void main(String[] args) throws Exception, ExecutionException {
		// TODO Auto-generated method stub
		ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
		List<Callable> list=new ArrayList();
		list.add(new MyCallableBTest());
		list.add(new MyCallableATest());
		service.scheduleAtFixedRate(new MyRunnable(),4l,4L,TimeUnit.SECONDS);
		//ScheduledFuture<String> future2=service.schedule(list.get(1),4L,TimeUnit.SECONDS);
	    //System.out.println(future1.get());
	    //System.out.println(future2.get());
	}

}
