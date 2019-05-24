package test.���Lock�ӿ�;

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
			System.out.println("��ǰ�̵߳����ּ��� �� "+ Thread.currentThread().getName());
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			System.out.println("��ǰ�̵߳����ֽ�����"+ Thread.currentThread().getName());
			
		}
	}

}
