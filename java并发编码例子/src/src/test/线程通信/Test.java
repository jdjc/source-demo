package test.线程通信;

public class Test {
	public static void main(String[] args) {
		EventStorage eventStorage =new EventStorage();
		Consumer consumer = new Consumer(eventStorage);
		Producer producer = new Producer(eventStorage);
		Thread thread = new Thread(producer);
		Thread thread2 = new Thread(consumer);
		thread2.start();
		thread.start();
	}
}
