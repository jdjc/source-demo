package test.并发阶段的数据交换;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class _Test {
	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<String>();
		List<String> buffer2 = new ArrayList<String>();
		Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
		Product product = new Product(buffer1, exchanger);
		Consumer consumer = new Consumer(buffer2, exchanger);
		Thread thread = new Thread(product);
		Thread thread2 =new Thread(consumer);
		thread.start();
		thread2.start();
	}
}
