package test.��������ʹ�ð����ȼ����������ʽ�̰߳�ȫ�б�;

/**
 * 
 * @author yangfeng
 *
 */
public class Event implements Comparable<Event> {
	private int thread;
	private int priority;
	public Event(int thread,int priority) {
		this.priority = priority;
		this.thread = thread;
	}
	public int getPriority() {
		return priority;
	}
	public int getThread() {
		return thread;
	}
	@Override
	public int compareTo(Event o) {
		if(this.priority > o.getPriority()){
			return -1;
		}else if(this.priority < o.getPriority()){
			return 1;
		}
		return 0;
	}
	
	
}
