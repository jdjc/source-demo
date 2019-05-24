package test.Ëø;

public class Test {
	public static void main(String[] args) {
		Account account  = new Account();
		account.setBalance(1000);
		System.out.println("³õÊ¼Óà¶î£º"+account.getBalance());
		
		Company company = new Company(account);
		AtmBank atmBank = new AtmBank(account);
		Thread companyThread =  new Thread(company);
		Thread atmBankThread  = new Thread(atmBank);
		companyThread.start();
		atmBankThread.start();
		
		try {
			companyThread.join();
			atmBankThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("×îÖÕÓà¶î£º"+account.getBalance());
	}
}
