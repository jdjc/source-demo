package test.调试并发程序;

public class Task implements Runnable {

	@Override
	public void run() {
		System.out.println( Thread.currentThread().getName()+"进入断点 start");
		
		System.out.println("进入断点 end");
	}

}
