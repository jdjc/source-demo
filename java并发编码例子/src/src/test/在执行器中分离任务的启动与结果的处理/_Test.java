package test.在执行器中分离任务的启动与结果的处理;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		//创建一个线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletionService<String> service = new ExecutorCompletionService<>(executorService);
		
		ReportRequest reportRequest1 = new ReportRequest("Face", service);
		ReportRequest reportRequest2 = new ReportRequest("Online", service);
		Thread thread1 = new Thread(reportRequest1);
		Thread thread2 = new Thread(reportRequest2);
		ReportProcessor processor = new ReportProcessor(service);
		Thread thread3 = new Thread(processor);
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("shutdown...");
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		processor.setEnd(true);
		System.out.println("end .....");
	}
}