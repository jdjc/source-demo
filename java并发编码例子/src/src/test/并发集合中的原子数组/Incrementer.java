package test.���������е�ԭ������;

import java.util.concurrent.atomic.AtomicIntegerArray;
/**
 * 
 * @author yangfeng
 *
 */
public class Incrementer implements Runnable{
	private AtomicIntegerArray vector;
	public Incrementer(AtomicIntegerArray array) {
		this.vector = array;
	}
	
	@Override
	public void run() {
		for(int i =0;i<vector.length() ; i++){
			vector.getAndIncrement(i);
		}
	}

}
