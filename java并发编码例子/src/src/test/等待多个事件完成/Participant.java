package test.等待多个事件完成;

/**
 * 参加者 表示参加会议的类
 * @author yangfeng
 *
 */
public class Participant implements Runnable {
	
	private Videoconference videoconference;
	private String name;
	public Participant(Videoconference videoconference,String name) {
		this.videoconference=videoconference;
		this.name= name;
	}
	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		videoconference.arrive(name);
	}

}
