package test.�ȴ�����¼����;

/**
 * �μ��� ��ʾ�μӻ������
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
