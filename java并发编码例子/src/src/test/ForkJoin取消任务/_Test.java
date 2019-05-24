package test.ForkJoinȡ������;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
/**
 * �����ڸ�������ʵ��ȡ������
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		ArrayGenerator arrayGenerator = new ArrayGenerator();
		int[] array = arrayGenerator.generateArray(1000);
		TaskManager manager = new TaskManager();
		ForkJoinPool pool = new ForkJoinPool(); //Ĭ���ǰ˺˴����� �����̳߳�Ĭ�ϲ���8���첽�̴߳������
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
