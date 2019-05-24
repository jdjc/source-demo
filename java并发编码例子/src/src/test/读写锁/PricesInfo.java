package test.读写锁;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 价格信息类
 * @author yangfeng
 *
 */
public class PricesInfo {
	private double price1;
	private double price2;
	private ReadWriteLock lock;
	public PricesInfo() {
		price1 = 1.0;
		price2 = 2.0;
		lock = new ReentrantReadWriteLock();
	}
	/**
	 * 获取价格
	 * @return
	 */
	public double getPrice1() {
		lock.readLock().lock();
		double value = price1;
		lock.readLock().unlock();
		return value;
	}
	public double getPrice2() {
		lock.readLock().lock();
		System.out.println("lock read start");
		double value = price2;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("lock read end");
		lock.readLock().unlock();
		return value;
	}
	public void setPrice1(double price1,double price2) {
		lock.writeLock().lock();
		System.out.println("lock writer start");
		this.price1 = price1;
		this.price2 = price2;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("lock writer end");
		lock.writeLock().unlock();
	}
}
