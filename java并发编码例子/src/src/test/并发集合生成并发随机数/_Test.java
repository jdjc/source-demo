package test.并发集合生成并发随机数;
/**
 * 
 * @author yangfeng
 *
 */
public class _Test {
	public static void main(String[] args) {
		Thread [] threads = new Thread [3];
		for(int i =0;i<3;i++){
			TaskLocalRandom random = new TaskLocalRandom();
			threads[i] =new Thread(random);
			threads[i].start();
		}
	
	}
}
