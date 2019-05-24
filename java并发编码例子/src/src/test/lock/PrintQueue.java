package test.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��ӡ����
 * @author yangfeng
 *
 */
public class PrintQueue {
	private final Lock queueLock = new ReentrantLock();
	public void printJob(Object document){
		queueLock.lock();
		long duration =(long)(Math.random()*10000);
		System.out.println(Thread.currentThread().getName()+": PrintQueue: ��ӡһ��job����ʱ��"+duration+"����");
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
