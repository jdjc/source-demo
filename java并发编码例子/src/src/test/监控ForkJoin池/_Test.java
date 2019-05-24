package test.监控ForkJoin池;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		int array[] =new int[10000];
		Task task1 = new Task(array, 0, array.length);
		pool.execute(task1);
		while (!task1.isDone()) {
			showLog(pool);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		showLog(pool);
		System.out.println("Main:End");
	}

	private static void showLog(ForkJoinPool pool) {
		System.out.println("******************************");
		System.out.println("pool并行的线程数："+ pool.getParallelism());
		System.out.println("pool池大小："+ pool.getPoolSize());
	}
}
