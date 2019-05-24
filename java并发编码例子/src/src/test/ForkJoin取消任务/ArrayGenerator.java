package test.ForkJoin取消任务;

import java.util.Random;

public class ArrayGenerator {
	
	/**
	 * 生成一个int数据并填充随机数据
	 * @param size
	 * @return
	 */
	public int [] generateArray(int size){
		int array[]=new int[size];
		Random random = new Random();
		for(int i =0;i<size;i++){
			array[i] = random.nextInt(10);
		}
		return array;
	}
	
	
	
	
}
