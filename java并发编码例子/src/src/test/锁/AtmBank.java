package test.��;
/**
 * ���� ģ��ATMȡ��ģ��
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
		//ȡǮ������
		for(int i = 0 ; i < 100 ; i++){
			account.subtrackAmount(1000);
		}
	}

}
