package test.并发集合阻塞线程安全列表;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {
	private LinkedBlockingDeque<String> list;
	public Client(LinkedBlockingDeque<String> list) {
		this.list = list;
	}
	@Override
	public void run() {
		for(int i =0; i<3;i++){
			for(int j =0; j<5; j++){
				StringBuffer request = new StringBuffer();
				request.append(i);
				request.append(":");
				request.append(j);
				try {
					//插入字符串
					list.put(request.toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Client:" +new Date());
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Client: End......");
	}

}
