package test.�ڼ��ϵ�ͬ��;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * ������
 * @author yangfeng
 *
 */
public class Searcher implements Runnable {
	private int firstRow;
	private int lastRow;
	//����
	private MatrixMock mock;
	//���
	private Results results;
	//���Ҫ���ҵ�����
	private int number;
	//�����̸߳���ͬ����
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
		System.out.println("Thread :" +Thread.currentThread().getName()+" ��Χ firstRow:"+firstRow+" lastRow:"+lastRow);
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
		System.out.println("�߳�ִ�����:"+Thread.currentThread().getName());
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
