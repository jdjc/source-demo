package test.���Ʋ���ForkJoin���;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;

public class MyWorkerThreadFactory implements ForkJoinWorkerThreadFactory {

	@Override
	public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
		MyWorkerThread myWorkerThread = new MyWorkerThread(pool);
		return myWorkerThread;
	}
	
}
