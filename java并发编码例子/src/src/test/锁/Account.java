package test.锁;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * 银行账户类
 * @author yangfeng
 *
 */
public class Account {
	private double balance;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * 多线程加锁机制 存钱
	 * @param balance
	 */
	public synchronized void addAmount(double balance){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance +=balance;
	}
	/**
	 * 多项成加锁机制  ： 取钱
	 */
	public synchronized void subtrackAmount(double balance){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance -=balance;
	}
}
