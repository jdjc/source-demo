package test.并发集合使用线程安全可遍历映射;
/**
 * 
 * @author yangfeng
 *
 */
public class Contact {
	private String name;
	private String phone;
	public Contact(String name,String phone) {
		this.name = name;
		this.phone = phone;
	}
	public String getName() {
		return name;
	} 
	public String getPhone() {
		return phone;
	}
	
}
