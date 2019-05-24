package test.运行多个任务并返回第一个结果;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多个线程同时验证一个用户，如果有一个线程验证成功，则返回结果，结束其他线程
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		String username ="test";
		String password ="test";
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DataBase");
		
		TaskValidator taskValidator1 = new TaskValidator(ldapValidator, username, password);
		TaskValidator taskValidator2 = new TaskValidator(dbValidator, username, password);
		
		List<TaskValidator> list = new ArrayList<TaskValidator>(); 
		list.add(taskValidator1);
		list.add(taskValidator2);
		
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		String result ;	
		try {
			//批量将list放入到线程池中
			result=newCachedThreadPool.invokeAny(list);
			System.out.println("Main  result : " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		newCachedThreadPool.shutdown();
		System.out.println("已经结束......");
		
	}
}
