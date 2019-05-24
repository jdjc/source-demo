package test.¼à¿ØÖ´ÐÐÆ÷¿ò¼Ü;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private long milliseconds;
	
	public Task(long milliseconds) {
		this.milliseconds= milliseconds;
	}

	@Override
	public void run() {
		System.out.println("Begin : "+Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end : "+Thread.currentThread().getName());
	}

}
