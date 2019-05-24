package test;

import java.util.Date;
import java.util.Deque;
/**
 * 
 * @author yangfeng
 *
 */
public class WriterTask implements Runnable{
	
	private Deque<Event> deque;
	public WriterTask(Deque<Event> deque) {
		this.deque= deque;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent("Event:"+Thread.currentThread().getId());
			deque.addFirst(event);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
