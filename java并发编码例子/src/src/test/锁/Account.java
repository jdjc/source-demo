package test.��;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * �����˻���
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
	 * ���̼߳������� ��Ǯ
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
	 * ����ɼ�������  �� ȡǮ
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
