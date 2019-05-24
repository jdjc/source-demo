package test.���ִ�������;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		Random random = new Random();
		for(int i =0;i<10;i++){
			Task task = new Task(random.nextInt(10000));
			executor.submit(task);
		}
		for(int i =0;i<5;i++){
			showLog(executor);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		for(int i =0;i<5;i++){
			showLog(executor);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�߳��Ѿ�����...");
	}

	private static void showLog(ThreadPoolExecutor executor) {
		System.out.println("************************************");
		System.out.println("�̳߳�ά���̵߳��������� �� "+ executor.getCorePoolSize());
		System.out.println("�̳߳ش�С �� " + executor.getPoolSize());
		System.out.println("��������С �� " + executor.getTaskCount());
		System.out.println("�Ѿ���������С �� " + executor.getCompletedTaskCount());
		System.out.println("�̳߳ؼ�� " + executor.getActiveCount());
	}
}
