package test.���Ʋ����๤��ģʽ;

import java.util.Date;

public class MyThread extends Thread{
	private Date creationDate;
	private Date startDate;
	private Date finishDate;
	
	public MyThread(Runnable runnable,String name) {
		super(runnable,name);
		setCreationDate();
	}
	@Override
	public void run() {
		setStartDate();
		super.run();
		setFinishDate();
	}
	public void setCreationDate() {
		this.creationDate = new Date();
	}
	public void setStartDate() {
		this.startDate = new Date();
	}
	public void setFinishDate() {
		this.finishDate = new Date();
	}
	public long getExecutionTime(){
		return finishDate.getTime() - startDate.getTime();
	}
	@Override
	public String toString() {
		return "�߳�����:"+getName() +" ����ʱ��:"+creationDate +" ִ��ʱ�䣺"+ getExecutionTime();
	}
}
