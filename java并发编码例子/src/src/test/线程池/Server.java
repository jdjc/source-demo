package test.�̳߳�;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	private ThreadPoolExecutor executor;
	public Server() {
		executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
	}
	public void executeTask(Task task){
		
		System.out.println("һ���µ�����������....." );
		executor.execute(task);
		System.out.println("�̳߳صĴ�С" + executor.getPoolSize());
		System.out.println("�̳߳����еĴ�С"+executor.getActiveCount());
		System.out.println("�̳߳���ɵ�������"+executor.getCompletedTaskCount());
	}
	public void endServer(){
		System.out.println("**********�̳߳عر�");
		executor.shutdown();
	}
}
