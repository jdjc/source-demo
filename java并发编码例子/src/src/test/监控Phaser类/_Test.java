package test.¼à¿ØPhaserÀà;

import java.util.concurrent.Phaser;

public class _Test {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		for(int i =0;i<3;i++){
			Task task = new Task(i+1, phaser);
			Thread thread = new Thread(task);
			thread.start();
		}
		for(int i =0;i<10;i++){
			System.out.println("**********************************");
			System.out.println("getPhaser:" + phaser.getPhase());
			System.out.println("getRegisteredParties :"+phaser.getRegisteredParties());
			System.out.println("getArrivedParties:"+phaser.getArrivedParties());
			System.out.println("getUnarrivedParties:"+phaser.getUnarrivedParties());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
