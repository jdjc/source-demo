package test.定制并发类工厂模式;

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
		return "线程名字:"+getName() +" 创建时间:"+creationDate +" 执行时间："+ getExecutionTime();
	}
}
