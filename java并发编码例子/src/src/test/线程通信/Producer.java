package test.�߳�ͨ��;

public class Producer implements Runnable{

	private EventStorage eventStorage;
	public Producer(EventStorage eventStorage) {
		this.eventStorage= eventStorage;
	}
	@Override
	public void run() {
		for(int i =0; i<100;i++){
			eventStorage.set();
		}
	}

}
