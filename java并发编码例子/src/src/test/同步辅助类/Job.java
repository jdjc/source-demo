package test.同步辅助类;

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
