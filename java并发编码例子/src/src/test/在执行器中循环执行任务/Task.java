package test.��ִ������ѭ��ִ������;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Runnable {
	private String name;
	public Task(String name) {
		this.name =name;
	}
	@Override
	public void run() {
		System.out.println("Starting ...."+ name+" �� " +new Date());
	}
	

}
