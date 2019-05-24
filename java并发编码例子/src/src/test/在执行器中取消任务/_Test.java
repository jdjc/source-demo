package test.在执行器中取消任务;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Task task = new Task();
		Future<String> submit = executorService.submit(task);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("取消方法执行");
		boolean cancel = submit.cancel(true);
		System.out.println("cancel" + submit.isCancelled());
		System.out.println("down" + submit.isDone());
		executorService.shutdown();
		System.out.println("finish.....");
		
	}
}
