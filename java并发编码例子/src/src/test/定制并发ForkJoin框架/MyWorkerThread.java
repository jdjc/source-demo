package test.���Ʋ���ForkJoin���;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

import test.�������Ϸ������̰߳�ȫ�б�.AddTask;

public class MyWorkerThread extends ForkJoinWorkerThread {
	private static ThreadLocal<Integer> taskCounter = new ThreadLocal<Integer>();
	protected MyWorkerThread(ForkJoinPool pool) {
		super(pool);
	}
	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("MyWorkerThread...getId:" + getId());
		taskCounter.set(0);
	}
	@Override
	protected void onTermination(Throwable exception) {
		System.out.println("MyWorkerThread...getId:" +getId()+" : " +taskCounter.get());
		super.onTermination(exception);
	}
	public void addTask(){
		int counter = taskCounter.get().intValue();
		counter++;
		taskCounter.set(counter);
	}
	
	
}
