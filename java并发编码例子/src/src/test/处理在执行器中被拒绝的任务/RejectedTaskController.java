package test.处理在执行器中被拒绝的任务;

import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler{
	/**
	 * 获取在线程池中拒绝的任务
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
