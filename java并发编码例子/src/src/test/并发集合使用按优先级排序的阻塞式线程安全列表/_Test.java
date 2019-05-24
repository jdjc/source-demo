package test.并发集合使用按优先级排序的阻塞式线程安全列表;

import java.util.concurrent.PriorityBlockingQueue;
/**
 * 
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue =new PriorityBlockingQueue<>();
		Thread[] tasks = new Thread[5];
		for(int i =0;i<tasks.length;i++){
			Task task2 = new Task(i,queue);
			tasks[i] = new Thread(task2);
		}
		for(int i =0;i<tasks.length;i++){
			tasks[i].start();
		}
		for(int i =0;i<tasks.length;i++){
			try {
				tasks[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("----------队列中取数-----------");
		for(int i =0; i<tasks.length*1000;i++){
			Event poll = queue.poll();
			System.out.println("**"+poll.getPriority()+"**"+poll.getThread());
		}
	}
}
