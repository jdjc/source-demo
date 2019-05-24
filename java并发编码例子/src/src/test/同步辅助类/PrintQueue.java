package test.ͬ��������;

import java.util.concurrent.Semaphore;

public class PrintQueue {
	//�̸߳����࣬�ź���
	private final Semaphore semaphore;
	public PrintQueue() {
		semaphore = new Semaphore(2);
	}
	public void printJob(Object document){
		try {
			//���Ȼ�ȡ�ź���
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+"start");
			long duration=(long)(Math.random()*10);
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName()+"end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//�ͷŻ�ȡ�ź���
			semaphore.release();
		}
	}
}
