package test.等待多个事件完成;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 视频会议类
 * @author yangfeng
 *
 */
public class Videoconference implements Runnable {
	private CountDownLatch controller;
	private Lock lock =new ReentrantLock();
	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}
	@Override
	public void run() {
		System.out.println("这次会议需要"+controller.getCount()+"个人参加会议！");
		try {
			controller.await();
			System.out.println("会议人数已经到齐，开始会议......");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 每一个与会者进入视频会议的时候 这个方法
	 */
	public void arrive(String name){
		lock.lock();
		System.out.println(name +"参加会议 ...");
		//这个方法会降初始化number  -1 
		controller.countDown();
		System.out.println("尚缺"+controller.getCount()+"人参加会议！");
		lock.unlock();
	}

}
