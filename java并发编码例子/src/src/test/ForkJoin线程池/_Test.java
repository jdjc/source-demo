package test.ForkJoin线程池;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import javax.swing.text.PlainDocument;

/**
 * 更新产品价格的任务 更新表中所有元素 ，使用10来作为参考，
 * 如果一个任务需要更新大于10个元素。它会将这个列表分解成为两个部分，然后分别创建两个任务用来更新各自部分的价格
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
		 * 记录一些线程的状态 以及新生成的子线程
		 */
		do{
			System.out.println("线程数量 ：" +pool.getActiveThreadCount());
			System.out.println("线程中断steal " + pool.getStealCount());
			System.out.println("线程并行数parallelism " +pool.getParallelism());
			TimeUnit.SECONDS.sleep(3);
		}while(!task.isDone());
		
		pool.shutdown();
		
		/**
		 * 调用isCompletedNormally()方法，检查任务是否已经完成并且没有错误
		 */
		if(task.isCompletedNormally()){
			System.out.println("任务正常完成......");
		}
		
		for(int i  = 0 ; i<generate.size();i++){
			Product product = generate.get(i);
			if(product.getPrice()!=12)
			System.out.println();
		}
		
	}
}
