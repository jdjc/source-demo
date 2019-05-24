package test.并发集合使用带有延迟元素的线程安全列表;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		DelayQueue<Event> queue  =new DelayQueue<>();
		Thread [] threads = new Thread[5];
		for(int i =0;i<threads.length;i++){
			Task task = new Task(i+1, queue);
			threads[i]= new Thread(task);
		}
		for(int i =0;i<threads.length;i++){
			threads[i].start();
		}
		for(int i =0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		do {
			int counter = 0;
			Event event;
			do {
				event = queue.poll();
				if(event!=null) {
					counter++;
				}
			} while (event!=null);
			System.out.println("获取event的数量："+counter);
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (queue.size()>0);
	}
}
