package test.���Բ�������;

public class _Test {
	public static void main(String[] args) {
		Thread thread = new Thread(new Task());
		thread.start();
		Thread thread2 = new Thread(new Task3());
		thread2.start();
		
	}
}
