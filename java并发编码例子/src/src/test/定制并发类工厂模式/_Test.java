package test.���Ʋ����๤��ģʽ;
/**
 * ʵ��ThreadFactory�ӿ����ɶ����߳�
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
