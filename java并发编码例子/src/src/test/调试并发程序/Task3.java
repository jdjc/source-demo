package test.调试并发程序;

public class Task3 implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"----------------");
	}

}
