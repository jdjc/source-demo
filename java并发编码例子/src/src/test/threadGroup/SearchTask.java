package test.threadGroup;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 * ������
 * 		����10���̲߳�����������һ�����ʱ�䣨ģ���ѯ����������һ���̲߳��ҳɹ���ʱ�����ǽ��ж�����9���߳�
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
			System.out.println("�쳣��"+Thread.currentThread().getName());
			return ;
		}
		result.setName(Thread.currentThread().getName());
	}
	/**
	 * �������˯��ʱ��
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
		System.out.println("�߳����а������߳���:"+threadGroup.activeCount());
		Thread [] threads  = new Thread[threadGroup.activeCount()];
		//��������Ǹ���group �����л�̵߳� �߳���������
		System.out.println("�߳������߳���Ϣ:"+ threadGroup.enumerate(threads));
		for(int i  =0 ;i<threadGroup.activeCount();i++){
			System.out.println("�߳����֣�"+threads[i].getName()+" �߳�״̬:"+threads[i].getState());
		}
		waitFinish(threadGroup);
		//����߳����������߳�
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
