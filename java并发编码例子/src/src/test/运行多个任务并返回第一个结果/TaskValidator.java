package test.运行多个任务并返回第一个结果;

import java.util.concurrent.Callable;


public class TaskValidator implements Callable<String>{
	private UserValidator validator;
	private String user;
	private String password;
	public TaskValidator(UserValidator validator , String user,String password) {
		this.password = password;
		this.user =user;
		this.validator = validator;
	}
	@Override
	public String call() throws Exception {
		if(!validator.validate(user, password)){
			System.out.println("用户名没有找到 ： "+ user);
			throw new Exception("用户验证错误："+user);
		}
		System.out.println("用户名验证通过： " + user);
		return validator.getName();
	}

}
