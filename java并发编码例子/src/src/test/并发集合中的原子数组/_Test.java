package test.并发集合中的原子数组;

import java.util.concurrent.atomic.AtomicIntegerArray;
/**
 * 
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		final int thread = 100;
		AtomicIntegerArray vector = new AtomicIntegerArray(1000);
		Incrementer incrementer = new Incrementer(vector);
		Decrementer decrementer =  new Decrementer(vector);
		Thread thread2  []= new Thread[thread];
		Thread thread3  []= new Thread[thread];
		for(int i =0; i<thread;i++){
			thread2[i] = new Thread(incrementer);
			thread3[i] = new Thread(decrementer);
			thread2[i].start();
			thread3[i].start();
		}
		for(int i =0;i<100;i++){
			try {
				thread2[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				thread3[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i =0;i<vector.length();i++){
			if(vector.get(i)!=0){
				System.out.println("Vector [" +i+" ] :"+vector.get(i));
			}
		}
		System.out.println("-------------------------------");
	}
}	
