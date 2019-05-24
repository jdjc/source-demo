package test.并发集合非阻塞线程安全列表;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 实例:添加大量的数据到另一个列表中
 * 	       从同一个列表中移除大量的数据
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
		Thread [] threads = new Thread[100];
		Thread [] threads2 = new Thread[100];
		for(int i =0;i<threads.length;i++){
			AddTask task = new AddTask(list);
			threads[i] =new Thread(task);
			threads[i].start();
		}
		System.out.println("-------------添加线程---------------");
		for(int i =0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("共添加集合数量"+list.size());
		for(int i =0;i<threads2.length;i++){
			PollTask task = new PollTask(list);
			threads2[i] =new Thread(task);
			threads2[i].start();
		}
		for(int i =0;i<threads2.length;i++){
			try {
				threads2[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("共添加集合数量"+list.size());
		
		
	}
}
