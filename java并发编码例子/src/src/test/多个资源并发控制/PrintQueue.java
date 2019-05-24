package test.多个资源并发控制;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	//线程辅助类，信号量
	private final Semaphore semaphore;
	//记录打印机的状态
	private boolean [] freePrinters;
	//锁对象用来保护对freePrinters的访问
	private Lock lockPrinters;
	public PrintQueue() {
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for(int i =0;i<3;i++){
			freePrinters[i] =true;
		}
		lockPrinters = new ReentrantLock();
		}
	public void printJob(Object document){
		try {
			//首先获取信号量
			semaphore.acquire();
			//获取打印机编号
			int assignedPrinter = getPrinter();
			System.out.println(Thread.currentThread().getName()+"start ：打印机编号:["+assignedPrinter+"]");
			long duration=(long)(Math.random()*10);
			Thread.sleep(duration);
			freePrinters[assignedPrinter] = true;
			System.out.println(Thread.currentThread().getName()+"end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//释放获取信号量
			semaphore.release();
		}
	}
	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();
			for(int i =0 ; i < freePrinters.length;i++){
				if(freePrinters[i]){
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}
}
