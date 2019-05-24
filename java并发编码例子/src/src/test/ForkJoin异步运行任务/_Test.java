package test.ForkJoin异步运行任务;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 在一个文件夹以及子文件夹中搜索带有指定扩展名的文件
 * ForkJoinTask类将实现处理这个文件夹的内容。
 * 而对于这个文件夹中每一个子文件，任务将以异步的方式发送一个新的任务给ForkJoinPool类。
 * 对于每个文件夹中的文件，任务将检查任务文件的扩展名，如果符合条件就将其增加到结果列表中
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		FolderProcessor folderProcessor1 = new FolderProcessor("c:\\windows", "log");
		FolderProcessor folderProcessor2 = new FolderProcessor("c:\\Program Files", "log");
		FolderProcessor folderProcessor3 = new FolderProcessor("c:\\Documents And Settings", "log");
		forkJoinPool.execute(folderProcessor1);
		forkJoinPool.execute(folderProcessor2);
		forkJoinPool.execute(folderProcessor3);
		do {
			System.out.println("线程并行数 ： "+ forkJoinPool.getParallelism());
			System.out.println("正在运行的线程数 ： "+ forkJoinPool.getActiveThreadCount());
			System.out.println("队列中的任务 ： "+ forkJoinPool.getQueuedTaskCount());
			System.out.println("中断的线程数 ： "+ forkJoinPool.getStealCount());
			System.out.println("**************************************************");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while ((!folderProcessor1.isDone())||(!folderProcessor2.isDone())||(!folderProcessor3.isDone()));
		forkJoinPool.shutdown();
		List<String> results =null;
		results = folderProcessor1.join();
		System.out.println("folderProcessor1 产生结果的大小 ："+ results.size());
		results = folderProcessor2.join();
		System.out.println("folderProcessor2 产生结果的大小 ："+ results.size());
		results = folderProcessor3.join();
		System.out.println("folderProcessor3 产生结果的大小 ："+ results.size());
	}
}
