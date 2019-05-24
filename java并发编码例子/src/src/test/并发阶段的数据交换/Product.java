package test.并发阶段的数据交换;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Product implements Runnable{
	//生产者与消费者交换的数据结构
	private List<String> buffer;
	//用于同步生产者和消费者的交换对象
	private final Exchanger<List<String >> exchanger;
	public Product(List<String > buffer, Exchanger<List<String>> exchanger) {
		this.buffer =buffer;
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		int cycle = 1;
		for(int i =0; i<10;i++){
			System.out.println("Product cycle :"+i+"次！");
			for(int j =0;j<10;j++){
				String meassge = "Event "+ ((i*10)+j);
				buffer.add(meassge);
			}
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer 交换 :" + buffer.size());
			cycle++;
		}
		
		
	}

}
