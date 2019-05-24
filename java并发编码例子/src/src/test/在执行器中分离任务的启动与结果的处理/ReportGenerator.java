package test.��ִ�����з�����������������Ĵ���;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String> {
	private String sender;
	private String title;
	public ReportGenerator(String sender,String title) {
		this.sender = sender;
		this.title = title;
	}
	@Override
	public String call() throws Exception {
		long duration =(long)(Math.random()*10);
		System.out.println(Thread.currentThread().getName() + ":" + this.sender+":"+this.title);
		TimeUnit.SECONDS.sleep(duration);
		return sender +" : "+title;
	}

}
