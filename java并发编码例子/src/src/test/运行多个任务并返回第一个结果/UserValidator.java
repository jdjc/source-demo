package test.运行多个任务并返回第一个结果;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author yangfeng
 *
 */
public class UserValidator {
	private String name;
	public UserValidator(String name) {
		this.name = name;
	}
	public boolean validate(String name,String password){
		Random random = new Random();
		try {
			long duration =(long)(Math.random()*10);
			System.out.println("Validator :" +this.name + ":time:"+duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return random.nextBoolean();
	}
	public String getName() {
		return name;
	}
}
