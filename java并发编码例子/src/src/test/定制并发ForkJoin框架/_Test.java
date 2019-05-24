package test.定制并发ForkJoin框架;

import java.util.concurrent.ForkJoinPool;

/**  这个作废 ，自己敲代码没有实现
     a. 一种特殊类型的任务，由ForkJoinTask类来实现。
     b.两种操作，其中通过fork操作将一个任务拆分成多个子任务，而通过join操作等待子任务结束。
     c.工作窃取算法，用来对线程池的使用进行优化，当一个任务等待它的子任务时，执行这个任务的线程可以被用来执行其他任务。
     d.一个任务队列，存放的是等待被执行的任务。
     e.一个执行这些任务的线程池。
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		
		MyWorkerThreadFactory factory = new MyWorkerThreadFactory();
		ForkJoinPool pool = new ForkJoinPool(4,factory,null,false);
		
		int array[] = new int[100000];
		for(int i =0;i<array.length;i++){
			array[i] = 1;
		}
		
		MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);
		pool.execute(task);
		task.join();
		
	}
}
