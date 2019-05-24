package test.在集合点同步;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 查找类
 * @author yangfeng
 *
 */
public class Searcher implements Runnable {
	private int firstRow;
	private int lastRow;
	//矩阵
	private MatrixMock mock;
	//结果
	private Results results;
	//存放要查找的数字
	private int number;
	//声明线程辅助同步类
	private CyclicBarrier barrier;
	public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.mock = mock;
		this.results = results;
		this.number = number;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println("Thread :" +Thread.currentThread().getName()+" 范围 firstRow:"+firstRow+" lastRow:"+lastRow);
		for(int i = firstRow;i<lastRow;i++){
			int counter =0;
			int row[]=mock.getRow(i);
			for(int j =0;j<row.length;j++){
				if(row[j]==number){
					counter++;
				}
			}
			try {
				results.setData(i, counter);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("线程执行完毕:"+Thread.currentThread().getName());
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
