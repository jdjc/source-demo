package test.在执行器中取消任务;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	@Override
	public String call() throws Exception {
		while (true) {
			System.out.println("Task。。。");
			Thread.sleep(100);
		}
	}

}
