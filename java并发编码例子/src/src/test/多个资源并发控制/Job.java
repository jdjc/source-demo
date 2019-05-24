package test.多个资源并发控制;

public class Job implements Runnable {
	
	private PrintQueue printQueue;
	public Job(PrintQueue printQueue) {
		this.printQueue= printQueue;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"工作开始 -------------");
		printQueue.printJob(new Object());
	}
	
}
