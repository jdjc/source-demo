package test.���ж�����񲢷��ص�һ�����;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����߳�ͬʱ��֤һ���û��������һ���߳���֤�ɹ����򷵻ؽ�������������߳�
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
			//������list���뵽�̳߳���
			result=newCachedThreadPool.invokeAny(list);
			System.out.println("Main  result : " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		newCachedThreadPool.shutdown();
		System.out.println("�Ѿ�����......");
		
	}
}
