package test.ForkJoin取消任务;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
/**
 * 借助于辅助类来实现取消任务
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		ArrayGenerator arrayGenerator = new ArrayGenerator();
		int[] array = arrayGenerator.generateArray(1000);
		TaskManager manager = new TaskManager();
		ForkJoinPool pool = new ForkJoinPool(); //默认是八核处理器 所以线程池默认产生8个异步线程处理程序
		SearchNumberTask task = new SearchNumberTask(array, 0, 1000, 5, manager);
		pool.execute(task);
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main : end !");
	}
}
