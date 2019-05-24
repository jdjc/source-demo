package test.ForkJoin�첽��������;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * ��һ���ļ����Լ����ļ�������������ָ����չ�����ļ�
 * ForkJoinTask�ཫʵ�ִ�������ļ��е����ݡ�
 * ����������ļ�����ÿһ�����ļ����������첽�ķ�ʽ����һ���µ������ForkJoinPool�ࡣ
 * ����ÿ���ļ����е��ļ������񽫼�������ļ�����չ����������������ͽ������ӵ�����б���
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
			System.out.println("�̲߳����� �� "+ forkJoinPool.getParallelism());
			System.out.println("�������е��߳��� �� "+ forkJoinPool.getActiveThreadCount());
			System.out.println("�����е����� �� "+ forkJoinPool.getQueuedTaskCount());
			System.out.println("�жϵ��߳��� �� "+ forkJoinPool.getStealCount());
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
		System.out.println("folderProcessor1 ��������Ĵ�С ��"+ results.size());
		results = folderProcessor2.join();
		System.out.println("folderProcessor2 ��������Ĵ�С ��"+ results.size());
		results = folderProcessor3.join();
		System.out.println("folderProcessor3 ��������Ĵ�С ��"+ results.size());
	}
}
