package test.�ȴ�����¼����;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��Ƶ������
 * @author yangfeng
 *
 */
public class Videoconference implements Runnable {
	private CountDownLatch controller;
	private Lock lock =new ReentrantLock();
	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}
	@Override
	public void run() {
		System.out.println("��λ�����Ҫ"+controller.getCount()+"���˲μӻ��飡");
		try {
			controller.await();
			System.out.println("���������Ѿ����룬��ʼ����......");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ÿһ������߽�����Ƶ�����ʱ�� �������
	 */
	public void arrive(String name){
		lock.lock();
		System.out.println(name +"�μӻ��� ...");
		//��������ή��ʼ��number  -1 
		controller.countDown();
		System.out.println("��ȱ"+controller.getCount()+"�˲μӻ��飡");
		lock.unlock();
	}

}
