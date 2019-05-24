package test.������ִ�����б��ܾ�������;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class _Test {
	public static void main(String[] args) {
		RejectedTaskController rejectedTaskController = new RejectedTaskController();
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		//�������ڱ��ܾ�������Ĵ������
		threadPoolExecutor.setRejectedExecutionHandler(rejectedTaskController);
		for(int i =0;i<3; i++){
			Task task = new Task("Task "+i);
			threadPoolExecutor.submit(task);
		}
		System.out.println("Main  shutdown ....");
		threadPoolExecutor.shutdown();
		Task task = new Task("RejectedTask");
		threadPoolExecutor.submit(task);
		System.out.println("end ");
	}
}
