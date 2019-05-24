package test.并发集合中的原子变量;
/**
 * 
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		
		Account account = new Account();
		account.setBalance(1000);
		
		Company company =new Company(account);
		Thread companyThread = new Thread(company);
		
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		System.out.println(account.getBalance());
		
		companyThread.start();
		bankThread.start();
		try {
			companyThread.join();
			bankThread.join();
			System.out.println("Account : " + account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
