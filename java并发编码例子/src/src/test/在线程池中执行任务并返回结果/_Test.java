package test.在线程池中执行任务并返回结果;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _Test {
	public static void main(String[] args) {
		ThreadPoolExecutor newFixedThreadPool = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		//Future这个接口声明了一些方法来获取Callable对象产生的结果，并管理他们的状态
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		Random random = new Random();
		for(int i =0;i<10;i++){
			Integer number = random.nextInt(10);
			FactorialCalculator calculator = new FactorialCalculator(number);
			Future<Integer> submit = newFixedThreadPool.submit(calculator);
			resultList.add(submit);
		}
		do {
			System.out.println("完成的任务数："+ newFixedThreadPool.getCompletedTaskCount());
			for(int i =0; i<resultList.size();i++){
				Future<Integer> future = resultList.get(0);
				System.out.println("Task"+i+":  "+future.isDone());
			}
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (newFixedThreadPool.getCompletedTaskCount()<resultList.size());
		//在控制台打印出各个线程返回的结果
		for (int i = 0; i < resultList.size(); i++) {
			Future<Integer> future = resultList.get(i);
			Integer number =null;
			try {
				number =future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println("Main : "+number);
		}
		newFixedThreadPool.shutdown();
	}
}
