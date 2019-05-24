package test.���ж�����񲢷��ص�һ�����;

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
			System.out.println("�û���û���ҵ� �� "+ user);
			throw new Exception("�û���֤����"+user);
		}
		System.out.println("�û�����֤ͨ���� " + user);
		return validator.getName();
	}

}
