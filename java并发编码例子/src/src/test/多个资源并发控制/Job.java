package test.�����Դ��������;

public class Job implements Runnable {
	
	private PrintQueue printQueue;
	public Job(PrintQueue printQueue) {
		this.printQueue= printQueue;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"������ʼ -------------");
		printQueue.printJob(new Object());
	}
	
}
