package test.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	private ThreadPoolExecutor executor;
	public Server() {
		executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
	}
	public void executeTask(Task task){
		
		System.out.println("一个新的任务在运行....." );
		executor.execute(task);
		System.out.println("线程池的大小" + executor.getPoolSize());
		System.out.println("线程池运行的大小"+executor.getActiveCount());
		System.out.println("线程池完成的任务数"+executor.getCompletedTaskCount());
	}
	public void endServer(){
		System.out.println("**********线程池关闭");
		executor.shutdown();
	}
}
