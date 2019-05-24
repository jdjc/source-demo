package test.定制并发类工厂模式;
/**
 * 实现ThreadFactory接口生成定制线程
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
		MyTask task = new MyTask();
		Thread thread =myThreadFactory.newThread(task);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main ...");
		System.out.println(thread);
	}
}
