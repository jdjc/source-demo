package test.在线程池中执行任务并返回结果;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/**
 * 多线程的另一种方式
 * @author yangfeng
 *
 */
public class FactorialCalculator implements Callable<Integer> {
	private Integer number;
	public FactorialCalculator(Integer number) {
		this.number = number;
	}
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if(number ==1 || number ==0){
			result = 1;
		}
		else{
			for(int i = 2;i<=number;i++){
				result*=i;
				TimeUnit.SECONDS.sleep(5);
			}
		}
		System.out.println(Thread.currentThread().getName()+":result="+result);
		return result;
	}

}
