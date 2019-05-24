package test.Lock线程通信;

public class Test {
	public static void main(String[] args) {
		FileMock fileMock = new FileMock(100, 10);
		Buffer buffer = new Buffer(20);
		Producer producer = new Producer(fileMock, buffer);
		Thread thread = new Thread(producer, "Producer");
		Consumer consumer [] =new Consumer[3];
		Thread thread2 []= new Thread[3];
		for(int i =0 ; i<3;i++){
			consumer[i] = new Consumer(buffer);
			thread2[i] = new Thread(consumer[i],"Consumer " + i);
		}
		thread.start();
		for(int i =0;i<3;i++){
			thread2[i].start();
		}
	}
}
