package test.在执行器中延迟执行任务;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
		System.out.println("Main Starting at " + new Date());
		for(int i =0;i<5;i++){
			Task task = new Task("Task" +i);
			newScheduledThreadPool.schedule(task, i+1, TimeUnit.SECONDS);
		}
		newScheduledThreadPool.shutdown();
		try {
			newScheduledThreadPool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end " + new Date());
		
	}
}
