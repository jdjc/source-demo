package test;
/**
 * 
 * @author yangfeng
 *
 */
public class ThreadTest implements Runnable{

	@Override
	public void run() {
		for(int i =0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"::"+i);
		}
		
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadTest());
		thread.start();
		System.out.println("主线程执行完毕！");
	}
	
}
