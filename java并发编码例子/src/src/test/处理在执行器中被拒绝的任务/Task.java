package test.处理在执行器中被拒绝的任务;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private String name;
	public Task(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		System.out.println("Task "+name+" ： starting....");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task "+name+" ：end....");
	}
	@Override
	public String toString() {
		return name;
	}

}
