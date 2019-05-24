package test.在执行器中控制任务的完成;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {
	private String name ;
	public String getName() {
		return name;
	}
	public ExecutableTask(String name) {
		this.name = name;
	}
	@Override
	public String call() throws Exception {
		long duration =(long)(Math.random()*10);
		System.out.println(name+"  :start : time" + duration );
		TimeUnit.SECONDS.sleep(duration);
		return "Hello world ,I am "+ name;
	}
	
}
