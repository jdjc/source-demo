package test.局部变量;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		protected Date initialValue() {
			return new Date();
		};
	};
	@Override
	public void run() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		System.out.println("当前线程startID: \t"+Thread.currentThread().getId()+"\t || startDate" +simpleDateFormat.format(startDate.get()));
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("当前线程endID: \t"+Thread.currentThread().getId()+"\t || startDate" +simpleDateFormat.format(startDate.get()));
		
	}
	public static void main(String[] args) {
		UnsafeTask unsafeTask  = new UnsafeTask();
		for(int i =0; i<10; i++){
			Thread thread = new Thread(unsafeTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
