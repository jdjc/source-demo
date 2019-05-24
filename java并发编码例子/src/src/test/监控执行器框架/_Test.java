package test.监控执行器框架;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		Random random = new Random();
		for(int i =0;i<10;i++){
			Task task = new Task(random.nextInt(10000));
			executor.submit(task);
		}
		for(int i =0;i<5;i++){
			showLog(executor);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		for(int i =0;i<5;i++){
			showLog(executor);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程已经结束...");
	}

	private static void showLog(ThreadPoolExecutor executor) {
		System.out.println("************************************");
		System.out.println("线程池维护线程的最少数量 ： "+ executor.getCorePoolSize());
		System.out.println("线程池大小 ： " + executor.getPoolSize());
		System.out.println("任务数大小 ： " + executor.getTaskCount());
		System.out.println("已经任务数大小 ： " + executor.getCompletedTaskCount());
		System.out.println("线程池激活： " + executor.getActiveCount());
	}
}
