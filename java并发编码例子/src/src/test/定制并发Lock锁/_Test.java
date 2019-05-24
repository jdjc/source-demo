package test.���Ʋ���Lock��;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		MyLock lock = new MyLock();
		for(int i =0;i<10;i++){
			Task task = new Task("Task-"+i, lock);
			Thread thread =new Thread(task);
			thread.start();
		}
		boolean value;
		do{
			try {
				value = lock.tryLock(1,TimeUnit.SECONDS);
				if(!value){
					System.out.println("û�л�ȡ����");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				value =false;
			}
		} while(!value);
		System.out.println("�Ѿ���ȡ����");
		lock.unlock();
		System.out.println("�߳̽���....");
	}
}
