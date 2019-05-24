package test.ForkJoin�̳߳��кϲ�����Ľ��;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		DocumentMock mock = new DocumentMock();
		String[][] document = mock.generateDocument(100, 1000, "the");
		DocumentTask task = new DocumentTask(document, 0, 100, "the");
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		
		do {
			System.out.println("**********************************************");
			System.out.println("Main: �����߳���:" + pool.getParallelism());
			System.out.println("Main: ���е��߳�:" + pool.getActiveThreadCount());
			System.out.println("Main: ���е�����:" + pool.getQueuedTaskCount());
			System.out.println("Main: �жϵ�����:" + pool.getStealCount());
			System.out.println("**********************************************");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
		
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
