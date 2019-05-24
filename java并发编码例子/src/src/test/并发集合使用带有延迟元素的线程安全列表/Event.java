package test.并发集合使用带有延迟元素的线程安全列表;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @author yangfeng
 *
 */
public class Event implements Delayed{
	private Date startDate;
	public Event(Date startDate) {
		this.startDate = startDate;
	}
	@Override
	public int compareTo(Delayed o) {
		long result =this.getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS);
		if(result<0){
			result=-1;
		}else if(result>0){
			result=1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		Date now = new Date();
		long diff =startDate.getTime()-now.getTime();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

}
