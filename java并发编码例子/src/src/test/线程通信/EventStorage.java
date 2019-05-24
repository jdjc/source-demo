package test.线程通信;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 数据存储类
 * @author yangfeng
 *
 */
public class EventStorage {
	private int maxSize;
	private List<Date> storage;
	public EventStorage() {
		this.maxSize =10;
		this.storage = new LinkedList<Date>();
	}
	/**
	 * 设置日期
	 */
	public synchronized void set(){
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		storage.add(new Date());
		System.out.println("set storage size  : "+ storage.size());
		notifyAll();
	}
	/**
	 * 删除日期
	 */
	public synchronized void get(){
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		((LinkedList<?>)storage).poll();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("get storage size  : "+ storage.size());
		notifyAll();
	}
}
