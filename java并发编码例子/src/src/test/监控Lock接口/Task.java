package test.监控Lock接口;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Task implements Runnable {
	private Lock lock;
	public Task(Lock lock) {
		this.lock  = lock;
	}
	@Override
	public void run() {
		for(int i=0;i<5;i++){
			lock.lock();
			System.out.println("当前线程的名字加锁 ： "+ Thread.currentThread().getName());
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			System.out.println("当前线程的名字解锁："+ Thread.currentThread().getName());
			
		}
	}

}
