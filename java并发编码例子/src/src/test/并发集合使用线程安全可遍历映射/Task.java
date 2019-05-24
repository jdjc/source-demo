package test.��������ʹ���̰߳�ȫ�ɱ���ӳ��;

import java.util.concurrent.ConcurrentSkipListMap;
/**
 * 
 * @author yangfeng
 *
 */
public class Task implements Runnable {
	private ConcurrentSkipListMap<String, Contact> map;
	private String id;
	public Task(String id , ConcurrentSkipListMap<String, Contact> map) {
		this.id =id;
		this.map =map;
	}
	@Override
	public void run() {
		for(int i =	0;i<1000;i++){
			Contact contact = new Contact(id, String.valueOf(i+1000));
			map.put(id+contact.getPhone(), contact);
		}
	}

}
