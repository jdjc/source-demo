package test.��ִ������ѭ��ִ������;

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
			System.out.println("������һ�ν�Ҫִ�е�ʣ��ʱ�䡣����" +result.getDelay(TimeUnit.SECONDS));
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
