package test.并发集合中的原子数组;

import java.util.concurrent.atomic.AtomicIntegerArray;
/**
 * 
 * @author yangfeng
 *
 */
public class Decrementer implements Runnable {
	private AtomicIntegerArray vector;
	public Decrementer(AtomicIntegerArray vector) {
		this.vector = vector;
	}
	@Override
	public void run() {
		for(int i =0 ; i<vector.length(); i++){
			vector.getAndDecrement(i);
		}
	}

}
