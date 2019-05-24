package test.工厂类;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	//用来存放每个线程的名称
	private String name ;
	//用来存储线程对象的数量
	private int counter;
	//字符串列表stats
	private List<String> stats;
	public MyThreadFactory(String name) {
		counter= 0;
		this.name = name ;
		stats = new ArrayList<String>();
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r, name + "-Thread_"+counter);
		//可以做线程的统计
		counter++;
		stats.add("Threadinfo: [id"+thread.getId()+"] [name"+thread.getName()+"] 创建时间:"+new Date());
		return thread;
	}
	public String getStatsListInfo() {
		StringBuffer stringBuffer = new StringBuffer();
		Iterator<String> iterator = stats.iterator();
		while (iterator.hasNext()) {
			stringBuffer.append(iterator.next()+"\n");
		}
		return stringBuffer.toString();
	}

}
