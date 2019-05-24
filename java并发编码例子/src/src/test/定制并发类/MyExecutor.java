package test.定制并发类;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutor extends ThreadPoolExecutor {
	private ConcurrentHashMap<String, Date> startTime;
	
	public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		startTime = new ConcurrentHashMap<>();
	}
	@Override
	public void shutdown() {
		System.out.println("shutdown...");
		System.out.println("已经完成的任务."+ getCompletedTaskCount());
		System.out.println("运行的线程数." + getActiveCount());
		System.out.println("线程池队列的大小" +getQueue().size());
		super.shutdown();
	}
	@Override
	public List<Runnable> shutdownNow() {
		System.out.println("now shutdown...");
		System.out.println("已经完成的任务."+ getCompletedTaskCount());
		System.out.println("运行的线程数." + getActiveCount());
		System.out.println("线程池队列的大小" +getQueue().size());
		return super.shutdownNow();
	}
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("线程名称："+t.getName() +"[:]"+r.hashCode());
		startTime.put(String.valueOf(r.hashCode()), new Date());
		super.beforeExecute(t, r);
	}
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		Future<?> result = (Future<?>) r;
		try {
			System.out.println("MyExcutor :  A task is finishing ...");
			System.out.println("Result : "+result.get());
			Date startDate=startTime.remove(String.valueOf(r.hashCode()));
			Date finishDate = new Date();
			long diff = finishDate.getTime()-startDate.getTime();
			System.out.println("任务执行时间 ："+diff);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		super.afterExecute(r, t);
	}
}
