package test.并发集合中的原子变量;

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
	 * 增加balance属性的值
	 * @param amount
	 */
	public void addAccount(long amount){
		this.balance.getAndAdd(amount);
	}
	/**
	 * 减少balance属性的值
	 * @param amount
	 */
	public void substractAmount(long amount){
		this.balance.getAndAdd(-amount);
	}
}
