package test.���������е�ԭ�ӱ���;

import java.util.concurrent.atomic.AtomicLong;
/**
 * 
 * @author yangfeng
 *
 */
public class Account {
	private AtomicLong balance;
	public Account() {
		balance = new AtomicLong();
	}
	public long getBalance() {
		return balance.get();
	}
	public void setBalance(long balance) {
		this.balance.set(balance);
	}
	/**
	 * ����balance���Ե�ֵ
	 * @param amount
	 */
	public void addAccount(long amount){
		this.balance.getAndAdd(amount);
	}
	/**
	 * ����balance���Ե�ֵ
	 * @param amount
	 */
	public void substractAmount(long amount){
		this.balance.getAndAdd(-amount);
	}
}
