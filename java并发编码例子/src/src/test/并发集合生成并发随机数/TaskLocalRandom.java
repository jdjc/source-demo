package test.并发集合生成并发随机数;

import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author yangfeng
 *
 */
public class TaskLocalRandom implements Runnable{
	public TaskLocalRandom() {
		ThreadLocalRandom.current();
	}
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i =0;i<10;i++){
			System.out.println("name : " +name +"  10以内的随机数:" +ThreadLocalRandom.current().nextInt(10));
		}
	}

}
