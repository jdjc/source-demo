package test.定制并发类;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyExecutor myExecutor = new MyExecutor(2, 4, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());
		List<Future<String>> results = new ArrayList<>();
		for(int i =0; i<10;	i++){
			SleepTwoSecondsTask task = new SleepTwoSecondsTask();
			Future<String> result = myExecutor.submit(task);
			results.add(result);
		}
		for(int i =0;i<5;i++){
			String result = results.get(i).get();
			System.out.println("前 5个任务 ：result :"+ result );
		}
		myExecutor.shutdownNow();
		for(int i =5;i<10;i++){
			String result = results.get(i).get();
			System.out.println("后5个任务：result : " +result);
		}
		myExecutor.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("--------------end------------------");
		
	}
}
