package test.¶ÁÐ´Ëø;

public class Reader implements Runnable{
	
	private PricesInfo info;
	public Reader(PricesInfo pricesInfo) {
		this.info = pricesInfo;
	}
	/**
	 * ½øÐÐ¶Á²Ù×÷
	 */
	@Override
	public void run() {
		for(int i =0; i<10; i++){
			info.getPrice1();
			info.getPrice2();
		}
	}

}
