package test.�����Դ��������;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	//�̸߳����࣬�ź���
	private final Semaphore semaphore;
	//��¼��ӡ����״̬
	private boolean [] freePrinters;
	//����������������freePrinters�ķ���
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
			//���Ȼ�ȡ�ź���
			semaphore.acquire();
			//��ȡ��ӡ�����
			int assignedPrinter = getPrinter();
			System.out.println(Thread.currentThread().getName()+"start ����ӡ�����:["+assignedPrinter+"]");
			long duration=(long)(Math.random()*10);
			Thread.sleep(duration);
			freePrinters[assignedPrinter] = true;
			System.out.println(Thread.currentThread().getName()+"end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//�ͷŻ�ȡ�ź���
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
