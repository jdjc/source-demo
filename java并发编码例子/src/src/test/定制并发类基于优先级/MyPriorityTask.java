package test.定制并发类基于优先级;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MyPriorityTask implements Runnable,Comparable<MyPriorityTask> {
	//声明一个名为priority的私有int属性
	private int priority;
	//声明一个名为name的私有String属性
	private String name;
	public MyPriorityTask(String name,int priority) {
		this.name= name;
		this.priority= priority;
	}
	public int getPriority() {
		return priority;
	}
	@Override
	public int compareTo(MyPriorityTask o) {
		if(this.getPriority()< o.getPriority()){
			return 1;
		}
		if(this.getPriority()> o.getPriority()){
			return -1;
		}
		return 0;
	}

	@Override
	public void run() {
		System.out.println("--------"+name+"------"+priority);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
