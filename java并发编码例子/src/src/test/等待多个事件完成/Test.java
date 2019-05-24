package test.等待多个事件完成;

public class Test {
	public static void main(String[] args) {
		Videoconference videoconference = new Videoconference(10);
		Thread thread = new Thread(videoconference);
		thread.start();
		
		for(int i =0;i<10;i++){
			Participant participant =new Participant(videoconference, "Participant"+i);
			Thread thread2 = new Thread(participant);
			thread2.start();
		}
		
	}
}
