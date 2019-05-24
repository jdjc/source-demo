package test.定制并发Lock锁;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private MyLock lock;
	private String name;
	public Task(String name,MyLock lock) {
		this.name = name;
		this.lock = lock;
	}
	@Override
	public void run() {
		lock.lock();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

}
