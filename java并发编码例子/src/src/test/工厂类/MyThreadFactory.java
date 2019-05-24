package test.������;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	//�������ÿ���̵߳�����
	private String name ;
	//�����洢�̶߳��������
	private int counter;
	//�ַ����б�stats
	private List<String> stats;
	public MyThreadFactory(String name) {
		counter= 0;
		this.name = name ;
		stats = new ArrayList<String>();
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r, name + "-Thread_"+counter);
		//�������̵߳�ͳ��
		counter++;
		stats.add("Threadinfo: [id"+thread.getId()+"] [name"+thread.getName()+"] ����ʱ��:"+new Date());
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
