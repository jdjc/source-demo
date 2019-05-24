package test.�����׶ε����ݽ���;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Product implements Runnable{
	//�������������߽��������ݽṹ
	private List<String> buffer;
	//����ͬ�������ߺ������ߵĽ�������
	private final Exchanger<List<String >> exchanger;
	public Product(List<String > buffer, Exchanger<List<String>> exchanger) {
		this.buffer =buffer;
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		int cycle = 1;
		for(int i =0; i<10;i++){
			System.out.println("Product cycle :"+i+"�Σ�");
			for(int j =0;j<10;j++){
				String meassge = "Event "+ ((i*10)+j);
				buffer.add(meassge);
			}
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer ���� :" + buffer.size());
			cycle++;
		}
		
		
	}

}
