package test.并发集合使用线程安全可遍历映射;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/**
 * 
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();
		Thread [] threads = new Thread[25];
		int counter =0;
		for(char i ='A';i<'Z';i++){
			Task task = new Task(String.valueOf(i), map);
			threads[counter] = new Thread(task);
			threads[counter].start();
			counter++;
		}
		for(int i =0;i<25;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("map 打大小 ： "+ map.size());
		Map.Entry<String, Contact> entry;
		Contact contact;
		entry = map.firstEntry();
		contact = entry.getValue();
		System.out.println("Contact first : " + contact.getName() + " :" + contact.getPhone());
		entry = map.lastEntry();
		contact = entry.getValue();
		System.out.println("Contact end : " + contact.getName() + " :" + contact.getPhone());
		System.out.println("取部分集合   A1996-----B1002");
		ConcurrentNavigableMap<String,Contact> subMap = map.subMap("A1996", "B1002");
		do {
			entry = subMap.pollFirstEntry();
			if(entry !=null){
				contact = entry.getValue();
				System.out.println("Contact first : " + contact.getName() + " :" + contact.getPhone());
			}
		} while (entry !=null);
	}
}
