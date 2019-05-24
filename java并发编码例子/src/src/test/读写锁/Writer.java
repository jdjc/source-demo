package test.¶ÁÐ´Ëø;

import test.lock.PrintQueue;

public class Writer implements Runnable {
	private PricesInfo pricesInfo ;
	public Writer(PricesInfo info) {
		this.pricesInfo= info;
	}
	@Override
	public void run() {
		for(int i  = 0 ; i<3; i++){
			pricesInfo.setPrice1(Math.random()*10, Math.random()*8);
		}
	}

}
