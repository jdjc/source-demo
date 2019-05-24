package test.监控Phaser类;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private int time;
	private Phaser phaser;
	public Task(int time,Phaser phaser) {
		this.time = time;
		this.phaser = phaser;
	}
	@Override
	public void run() {
		phaser.arrive();
		System.out.println("Entering phase " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing phase " + Thread.currentThread().getName());
		//该方法是同步方法 表示要同步一次
		phaser.arriveAndAwaitAdvance();
		
		phaser.arrive();
		System.out.println("Entering phase " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing phase " + Thread.currentThread().getName());
		//该方法是同步方法 表示要同步一次
		phaser.arriveAndAwaitAdvance();
		
		phaser.arrive();
		System.out.println("Entering phase " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing phase " + Thread.currentThread().getName());
		//该方法是同步方法 表示要同步一次
		phaser.arriveAndDeregister();
		
		
	}
	
}
