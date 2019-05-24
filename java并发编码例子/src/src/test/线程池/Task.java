package test.线程池;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private Date initDate;
	private String name;
	public Task(String name) {
		this.name= name;
		this.initDate = new Date();
	}
	SimpleDateFormat SimpleDateFormat  =new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
	@Override
	public void run() {
		System.out.println("-----------------------"+name+"----------------------------");
		System.out.println(Thread.currentThread().getName()+"线程: "+name+"start work.....");
		System.out.println(name+"初始化时间"+SimpleDateFormat.format(initDate));
		System.out.println(name+"开始时间"+SimpleDateFormat.format(new Date()));
		
		Long duration =(long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"结束时间"+SimpleDateFormat.format(new Date()));
		System.out.println("------------------------"+name+"---------------------------");
	}

}
