package test;

import java.util.Date;
import java.util.Deque;
/**
 * 
 * @author yangfeng
 *
 */
public class CleanerTask extends Thread {
	private Deque<Event> deque;
	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		setDaemon(true);
	}
	@Override
	public void run() {
		while (true) {
			Date date =new Date();
			clean(date);
			
		}
	}
	private void clean(Date date) {
		if(deque.size()==0){
			return;
		}
		boolean delete  =false;
		long difference ;
		do {
			Event event = deque.getLast();
			difference = date.getTime() -event.getDate().getTime();
			if(difference > 10000){
				System.out.printf("Cleaner : ",event.getEvent());
				deque.removeLast();
				delete = true;
			}
		} while (difference>10000);
		if(delete){
			System.out.println("队列的长度:"+deque.size());
		}
	}
}
