package test.FindBug分析并发代码;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable{
	private ReentrantLock lock;
	public Task(ReentrantLock lock) {
		this.lock=lock;
	}
	@Override
	public void run() {
		lock.lock();
		try {
			TimeUnit.SECONDS.sleep(2);
			lock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		for(int i =0;i<10;i++){
			Task task = new Task(lock);
			Thread thread = new Thread(task);
			thread.start();
		}
	}

}
