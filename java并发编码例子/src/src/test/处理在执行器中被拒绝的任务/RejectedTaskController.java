package test.������ִ�����б��ܾ�������;

import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler{
	/**
	 * ��ȡ���̳߳��оܾ�������
	 */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		Thread thread = new Thread(r);
		thread.start();
		System.out.println("Runnable info: " +r.toString());
		System.out.println("ThreadPoolExecutor info: " +executor.toString());
		System.out.println("ThreadPoolExecutor.isTerminating info: " +executor.isTerminating());
		System.out.println("ThreadPoolExecutor.isTerminated info: " +executor.isTerminated());
	}

}
