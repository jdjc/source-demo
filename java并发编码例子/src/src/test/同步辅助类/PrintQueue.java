package test.同步辅助类;

import java.util.concurrent.Semaphore;

public class PrintQueue {
	//线程辅助类，信号量
	private final Semaphore semaphore;
	public PrintQueue() {
		semaphore = new Semaphore(2);
	}
	public void printJob(Object document){
		try {
			//首先获取信号量
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+"start");
			long duration=(long)(Math.random()*10);
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName()+"end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//释放获取信号量
			semaphore.release();
		}
	}
}
