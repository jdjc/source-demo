package test.ForkJoin在任务中抛出异常;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Task extends RecursiveTask<Integer> {
	//声明一个array的私有int数组
	private int array[];
	private int start,end;
	public Task(int array[],int start,int end) {
		this.array = array;
		this.start = start;
		this.end   = end;
	}
	@Override
	protected Integer compute() {
		System.out.println("StartTask  start [" +start +"] end ["+end+"]");
		if(end - start <10){
			if((3>start) && (3<end)){
				System.err.println("Exception  start [" +start +"] end ["+end+"]");
				throw new RuntimeException("运行时异常");
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			int mid = (start+end)/2;
			Task task1 = new Task(array, start, mid);
			Task task2 = new Task(array, mid, end);
			invokeAll(task1, task2);
		}
		System.out.println("EndTask  start [" +start +"] end ["+end+"]");
		return 0;
	}

}
