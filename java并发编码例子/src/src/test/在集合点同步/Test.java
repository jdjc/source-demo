package test.在集合点同步;

import java.util.concurrent.CyclicBarrier;

import javax.swing.TransferHandler;

public class Test {
	public static void main(String[] args) {
		final int ROWS 		= 	1000;
		final int NUMBER 	=	1000;
		final int SEARCH	=	5;
		final int PARTICIPANTS =5;
		final int LINKS_PARTICIPANTS	=200;
		MatrixMock mock = new MatrixMock(ROWS, NUMBER, SEARCH);
		Results results = new Results(ROWS);
		Grouper grouper = new Grouper(results);
		//这个声明会自动调用要run的线程的方法。
		CyclicBarrier barrier= new CyclicBarrier(PARTICIPANTS, grouper);
		Searcher[] searcher = new Searcher [PARTICIPANTS];
		for(int i =0; i<PARTICIPANTS;i++){
			searcher[i] = new Searcher(i*LINKS_PARTICIPANTS, (i*LINKS_PARTICIPANTS)+LINKS_PARTICIPANTS, mock, results, 5, barrier);
			Thread thread = new Thread(searcher[i]);
			thread.start();
		}
		System.out.println("线程彻底结束。。。");
	}
}
