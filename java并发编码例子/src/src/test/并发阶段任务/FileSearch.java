package test.并发阶段任务;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable {

	private String initPath;
	//文件扩展名
	private String end;
	//声明私有列表List属性，用来存储查找到的文件的完整路径
	private List<String> results;
	//声明一个私有Phaser属性，用来控制任务不同阶段的进行
	private Phaser phaser;
	
	public FileSearch(String initPath, String end,  Phaser phaser) {
		super();
		this.initPath = initPath;
		this.end = end;
		this.results = new ArrayList<String>();
		this.phaser = phaser;
	}
	//查找文件
	private void directoryProcess(File file){
		File list[] = file.listFiles();
		if(list !=null){
			for(int i = 0; i<list.length;i++){
				if(list[i].isDirectory()){
					directoryProcess(list[i]);
				} else{
					fileProcess(list[i]);
				}
			}
		}
	}
	private void fileProcess(File file) {
		if(file.getName().endsWith(end)){
			results.add(file.getAbsolutePath());
		}
		
	}
	/**
	 * 第一次过滤结果查找24小时以内的文件log
	 */
	private void filterResults(){
		List<String> newResults = new ArrayList<String>();
		long actualDate = new Date().getTime();
		for(int i =0;i<results.size();i++){
			File file = new File(results.get(i));
			long lastModified = file.lastModified();
			if(actualDate-lastModified < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)){
				newResults.add(results.get(i));
			}
		}
		results = newResults;
	}
	private boolean checkResults(){
		if(results.isEmpty()){
			System.out.println(Thread.currentThread().getName() + " 空集合 : "+phaser.getPhase());
			// 这个线程已经结束了 不会再继续执行了
			phaser.arriveAndDeregister();
			return false;
		}else{
			System.out.println(Thread.currentThread().getName()+" 非空集合 : "+phaser.getPhase());
			// 这个线程阻塞了
			phaser.arriveAndAwaitAdvance();
			return true;	
		}
		
	}
	/**
	 * 展示信息
	 */
	private void showInfo(){
		for(int i =0;i<results.size();i++){
			File file = new File(results.get(i));
			System.out.println(Thread.currentThread().getName()+" : " + file.getAbsolutePath());
		}
		phaser.arriveAndAwaitAdvance();
	}
	@Override
	public void run() {
		//查找任务开始执行的信息打印到控制台
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName()+" : " +  "Starting ......");
		File file = new File(initPath);
		if(file.isDirectory()){
			directoryProcess(file);
		}
		if(!checkResults()){
			return;
		}
		filterResults();
		if(!checkResults()){
			return;
		}
		showInfo();
		phaser.arriveAndDeregister();
		System.out.println(Thread.currentThread().getName()+" : 线程执行结束...");
	}
	public static void main(String[] args) {
		Phaser phaser =new Phaser(3);
		FileSearch system =new FileSearch("C:\\windows", "log", phaser);
		FileSearch apps =new FileSearch("C:\\Program Files", "log", phaser);
		FileSearch document =new FileSearch("C:\\Users", "log", phaser);
		Thread thread1 = new Thread(system,"System");
		Thread thread2 = new Thread(apps,"Apps");
		Thread thread3 = new Thread(document,"Document");
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//打印出对象是否已经终止
		System.out.println("Terminated :" + phaser.isTerminated());
	}

}
