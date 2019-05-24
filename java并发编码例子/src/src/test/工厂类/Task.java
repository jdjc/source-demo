package test.π§≥ß¿‡;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		for(int i  =  0 ; i < 10; i ++){
			Thread newThread = myThreadFactory.newThread(task);
			newThread.start();
		}
		System.out.println(myThreadFactory.getStatsListInfo());
	}

}
