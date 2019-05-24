package test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印队列
 * @author yangfeng
 *
 */
public class PrintQueue {
	private final Lock queueLock = new ReentrantLock();
	public void printJob(Object document){
		queueLock.lock();
		long duration =(long)(Math.random()*10000);
		System.out.println(Thread.currentThread().getName()+": PrintQueue: 打印一个job话费时间"+duration+"分钟");
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			queueLock.unlock();
		}
	}
	
}
