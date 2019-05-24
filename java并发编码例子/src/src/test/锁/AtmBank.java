package test.锁;
/**
 * 银行 模拟ATM取款模型
 * @author yangfeng
 *
 */
public class AtmBank implements Runnable {
	private Account account;
	public AtmBank(Account account) {
		this.account = account;
	}
	@Override
	public  void run() {
		//取钱操作啦
		for(int i = 0 ; i < 100 ; i++){
			account.subtrackAmount(1000);
		}
	}

}
