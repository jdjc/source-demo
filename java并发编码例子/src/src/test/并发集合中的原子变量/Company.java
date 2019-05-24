package test.并发集合中的原子变量;
/**
 * 
 * @author yangfeng
 *
 */
public class Company implements Runnable {
	private Account account;
	public Company(Account account) {
		this.account =account;
	}
	@Override
	public void run() {
		for(int i =0;i<10;i++){
			account.addAccount(1000);
		}
	}

}
