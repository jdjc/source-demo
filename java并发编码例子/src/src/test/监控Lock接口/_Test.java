package test.���Lock�ӿ�;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class _Test {
	
	public static void main(String[] args) {
		MyLock lock = new MyLock();
		Thread threads [] = new Thread[5];
		for(int i =0;i<5;i++){
			Task task = new Task(lock);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		for(int i =0;i<15;i++){
			System.out.println("ӵ���������� �� "+ lock.getOwnerName());
			System.out.println("Lock:Queued Threads ��"+lock.hasQueuedThreads());
			if(lock.hasQueuedThreads()){
				System.out.println("�ȴ����Ķ��еĳ���" + lock.getQueueLength());
				Collection<Thread> geThreads = lock.geThreads();
				for(Thread thread: geThreads){
					System.out.println("�ȴ����Ķ��л�ȡ�߳��������� �� " + thread.getName());
				}
				
			}
			System.out.println("���Ĺ�ƽģʽ�� "+ lock.isFair());
			System.out.println("����״̬��Ϣ��"+lock.isLocked());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
