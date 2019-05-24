package test.并发阶段任务中阶段切换;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Student implements Runnable{
	private Myphaser myphaser;
	public Student(Myphaser myphaser) {
		this.myphaser = myphaser;
	}
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
	@Override
	public void run() {
		//阶段性任务
		System.out.println(Thread.currentThread().getName()+" student has arrived to do the exam... "+simpleDateFormat.format(new Date()));
		myphaser.arriveAndAwaitAdvance();
		//阶段性任务
		System.out.println(Thread.currentThread().getName()+" student has done first exercise... "+simpleDateFormat.format(new Date()));
		doExercise1();
		myphaser.arriveAndAwaitAdvance();
		//阶段性任务
		System.out.println(Thread.currentThread().getName()+" student has done second exercise... "+simpleDateFormat.format(new Date()));
		doExercise2();
		myphaser.arriveAndAwaitAdvance();
		//阶段性任务
		System.out.println(Thread.currentThread().getName()+" student has done finish exercise... "+simpleDateFormat.format(new Date()));
		doExercise3();
		myphaser.arriveAndAwaitAdvance();
	}
	private void doExercise2(){
		long duration  =(long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void doExercise3(){
		long duration  =(long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void doExercise1(){
		long duration  =(long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
