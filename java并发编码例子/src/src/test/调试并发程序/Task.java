package test.���Բ�������;

public class Task implements Runnable {

	@Override
	public void run() {
		System.out.println( Thread.currentThread().getName()+"����ϵ� start");
		
		System.out.println("����ϵ� end");
	}

}
