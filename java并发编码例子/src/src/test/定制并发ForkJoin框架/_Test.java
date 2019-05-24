package test.���Ʋ���ForkJoin���;

import java.util.concurrent.ForkJoinPool;

/**  ������� ���Լ��ô���û��ʵ��
     a. һ���������͵�������ForkJoinTask����ʵ�֡�
     b.���ֲ���������ͨ��fork������һ�������ֳɶ�������񣬶�ͨ��join�����ȴ������������
     c.������ȡ�㷨���������̳߳ص�ʹ�ý����Ż�����һ������ȴ�����������ʱ��ִ�����������߳̿��Ա�����ִ����������
     d.һ��������У���ŵ��ǵȴ���ִ�е�����
     e.һ��ִ����Щ������̳߳ء�
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		
		MyWorkerThreadFactory factory = new MyWorkerThreadFactory();
		ForkJoinPool pool = new ForkJoinPool(4,factory,null,false);
		
		int array[] = new int[100000];
		for(int i =0;i<array.length;i++){
			array[i] = 1;
		}
		
		MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);
		pool.execute(task);
		task.join();
		
	}
}
