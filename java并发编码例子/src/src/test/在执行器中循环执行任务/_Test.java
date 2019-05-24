package test.在执行器中循环执行任务;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		Task task = new Task("Task");
		ScheduledFuture<?> result = executorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
		for(int i =0; i<10;i++){
			System.out.println("任务下一次将要执行的剩余时间。。。" +result.getDelay(TimeUnit.SECONDS));
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		executorService.shutdown();
		System.out.println("end....");
	}
}
