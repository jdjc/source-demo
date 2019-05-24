package test.监控Lock接口;

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
			System.out.println("拥有锁的名字 ： "+ lock.getOwnerName());
			System.out.println("Lock:Queued Threads ："+lock.hasQueuedThreads());
			if(lock.hasQueuedThreads()){
				System.out.println("等待锁的队列的长度" + lock.getQueueLength());
				Collection<Thread> geThreads = lock.geThreads();
				for(Thread thread: geThreads){
					System.out.println("等待锁的队列获取线程数的名字 ： " + thread.getName());
				}
				
			}
			System.out.println("锁的公平模式： "+ lock.isFair());
			System.out.println("锁的状态信息："+lock.isLocked());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
