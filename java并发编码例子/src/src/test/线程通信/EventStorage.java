package test.�߳�ͨ��;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * ���ݴ洢��
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
	 * ��������
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
	 * ɾ������
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
