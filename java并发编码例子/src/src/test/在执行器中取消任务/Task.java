package test.��ִ������ȡ������;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	@Override
	public String call() throws Exception {
		while (true) {
			System.out.println("Task������");
			Thread.sleep(100);
		}
	}

}
