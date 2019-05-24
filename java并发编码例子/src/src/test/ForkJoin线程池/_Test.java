package test.ForkJoin�̳߳�;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import javax.swing.text.PlainDocument;

/**
 * ���²�Ʒ�۸������ ���±�������Ԫ�� ��ʹ��10����Ϊ�ο���
 * ���һ��������Ҫ���´���10��Ԫ�ء����Ὣ����б�ֽ��Ϊ�������֣�Ȼ��ֱ𴴽����������������¸��Բ��ֵļ۸�
 * @author yangfeng 191
 *
 */
public class _Test {
	public static void main(String[] args) throws InterruptedException {
		ProductListGenerator productListGenerator = new ProductListGenerator();
		List<Product> generate = productListGenerator.generate(10000);
		Task task = new Task(generate, 0, generate.size(), 0.20);
		ForkJoinPool pool = new ForkJoinPool(2);
		pool.execute(task);
		
		/**
		 * ��¼һЩ�̵߳�״̬ �Լ������ɵ����߳�
		 */
		do{
			System.out.println("�߳����� ��" +pool.getActiveThreadCount());
			System.out.println("�߳��ж�steal " + pool.getStealCount());
			System.out.println("�̲߳�����parallelism " +pool.getParallelism());
			TimeUnit.SECONDS.sleep(3);
		}while(!task.isDone());
		
		pool.shutdown();
		
		/**
		 * ����isCompletedNormally()��������������Ƿ��Ѿ���ɲ���û�д���
		 */
		if(task.isCompletedNormally()){
			System.out.println("�����������......");
		}
		
		for(int i  = 0 ; i<generate.size();i++){
			Product product = generate.get(i);
			if(product.getPrice()!=12)
			System.out.println();
		}
		
	}
}
