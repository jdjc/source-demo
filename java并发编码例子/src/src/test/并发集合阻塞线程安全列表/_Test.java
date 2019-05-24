package test.并发集合阻塞线程安全列表;

import java.sql.Time;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
		Client client =new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		/**
		 * 使用take方法 每300毫秒从列表中取出3个字符串对象，重复5次
		 */
		for(int i =0;i<5;i++){
			for(int j =0;j<3;j++){
				String take = list.take();
				System.out.println("Main :list size: "+ list.size());
				System.out.println("Take :" + take);
			}
			TimeUnit.MILLISECONDS.sleep(300);
		}
		System.out.println("Main: end of the program.");
	}
}
