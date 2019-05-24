package test.threadGroup;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * 案例：
 * 		创建10个线程并让他们休眠一个随机时间（模拟查询），当其中一个线程查找成功的时候，我们将中断其他9个线程
 * @author yangfeng
 *
 */
public class SearchTask implements Runnable {
	private Result result;
	public SearchTask(Result result) {
		this.result = result;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			doTask();
		} catch (InterruptedException e) {
			System.out.println("异常："+Thread.currentThread().getName());
			return ;
		}
		result.setName(Thread.currentThread().getName());
	}
	/**
	 * 随机生成睡眠时间
	 * @throws InterruptedException
	 */
	private void doTask() throws InterruptedException {
		Random random = new Random((new Date()).getTime());
		int value = (int) (random.nextDouble()*100);
		TimeUnit.SECONDS.sleep(value);
	}
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
		for(int i =0;i<10;i++){
			Thread thread =new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--------------------list-----------------------");
		threadGroup.list();
		System.out.println("线程组中包含的线程数:"+threadGroup.activeCount());
		Thread [] threads  = new Thread[threadGroup.activeCount()];
		//这个方法是复制group 中所有活动线程到 线程数组里面
		System.out.println("线程组中线程信息:"+ threadGroup.enumerate(threads));
		for(int i  =0 ;i<threadGroup.activeCount();i++){
			System.out.println("线程名字："+threads[i].getName()+" 线程状态:"+threads[i].getState());
		}
		waitFinish(threadGroup);
		//打断线程组里面活动的线程
		threadGroup.interrupt();
	}
	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount()>9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
