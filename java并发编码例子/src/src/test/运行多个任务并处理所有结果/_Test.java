package test.运行多个任务并处理所有结果;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _Test {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		List<Task> tasks = new ArrayList<>();
		for(int i =0;i<3;i++){
			Task task = new Task("Task"+i);
			tasks.add(task);
		}
		List<Future<Result>> futures = null;
		try {
			futures = newCachedThreadPool.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//调用shutdown方法结束执行器
		newCachedThreadPool.shutdown();
		System.out.println("Main result ");
		for(Future<Result> future : futures){
			Result result = future.get();
			System.out.println("Result" + result.getName()+"::"+result.getValue());
		}
	}
}
