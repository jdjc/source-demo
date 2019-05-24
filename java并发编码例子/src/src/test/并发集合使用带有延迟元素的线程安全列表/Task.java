package test.并发集合使用带有延迟元素的线程安全列表;

import java.util.Date;
import java.util.concurrent.DelayQueue;
/**
 * 
 * @author yangfeng
 *
 */
public class Task implements Runnable{
	private int id;
	private DelayQueue<Event> quere;
	
	public Task(int id, DelayQueue<Event> quere) {
		super();
		this.id = id;
		this.quere = quere;
	}

	@Override
	public void run() {
		Date now = new Date();
		Date delay = new Date();
		delay.setTime(now.getTime()+(id*1000));
		System.out.printf("Thread %s:%s\n",id,delay);
		for(int i =0;i<100;i++){
			Event event =new Event(delay);
			quere.add(event);
		}
	}

}
