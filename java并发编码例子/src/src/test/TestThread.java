package test;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 
 * @author yangfeng
 *
 */
public class TestThread {
	public static void main(String[] args) {
		Deque<Event> deque = new ArrayDeque<Event>();
		WriterTask writerTask =new WriterTask(deque);
		for(int i  = 0 ; i < 3; i++){
			Thread thread = new Thread(writerTask);
			thread.start();
		}
		CleanerTask cleanerTask = new CleanerTask(deque);
		cleanerTask.start();
		
	}
}
