package test.在执行器中控制任务的完成;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		ResultTask[]  resultTasks = new ResultTask [5];
		for(int i =0;i<5;i++){
			ExecutableTask executableTask = new ExecutableTask("Task"+i);
			resultTasks[i] =new ResultTask(executableTask);
			newCachedThreadPool.submit(resultTasks[i]);
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i =0;i<resultTasks.length;i++){
			resultTasks[i].cancel(true);
		}
		for(int i =0;i<resultTasks.length;i++){
			if(!resultTasks[i].isCancelled()){
				try {
					System.out.println("----"+resultTasks[i].get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		newCachedThreadPool.shutdown();
	}
}
