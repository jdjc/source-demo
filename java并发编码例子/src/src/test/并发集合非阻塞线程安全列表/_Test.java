package test.�������Ϸ������̰߳�ȫ�б�;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * ʵ��:��Ӵ��������ݵ���һ���б���
 * 	       ��ͬһ���б����Ƴ�����������
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
		Thread [] threads = new Thread[100];
		Thread [] threads2 = new Thread[100];
		for(int i =0;i<threads.length;i++){
			AddTask task = new AddTask(list);
			threads[i] =new Thread(task);
			threads[i].start();
		}
		System.out.println("-------------����߳�---------------");
		for(int i =0;i<threads.length;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("����Ӽ�������"+list.size());
		for(int i =0;i<threads2.length;i++){
			PollTask task = new PollTask(list);
			threads2[i] =new Thread(task);
			threads2[i].start();
		}
		for(int i =0;i<threads2.length;i++){
			try {
				threads2[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("����Ӽ�������"+list.size());
		
		
	}
}
