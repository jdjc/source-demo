package test.���̳߳���ִ�����񲢷��ؽ��;

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
		//Future����ӿ�������һЩ��������ȡCallable��������Ľ�������������ǵ�״̬
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		Random random = new Random();
		for(int i =0;i<10;i++){
			Integer number = random.nextInt(10);
			FactorialCalculator calculator = new FactorialCalculator(number);
			Future<Integer> submit = newFixedThreadPool.submit(calculator);
			resultList.add(submit);
		}
		do {
			System.out.println("��ɵ���������"+ newFixedThreadPool.getCompletedTaskCount());
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
		//�ڿ���̨��ӡ�������̷߳��صĽ��
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
