package test.���ж�����񲢴������н��;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
	private String name ;
	public Task(String name) {
		this.name = name;
	}
	@Override
	public Result call() throws Exception {
		System.out.println(name+"����ʼ....");
		TimeUnit.SECONDS.sleep((int)Math.random()*10);
		int value = 0;
		for(int i=0; i<10;i++){
			value +=(int)(Math.random()*100);
		}
		Result result = new Result();
		result.setName(name);
		result.setValue(value);
		System.out.println(this.name +" : end");
		return result;
	}

}
