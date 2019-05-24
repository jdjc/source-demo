package test.�����׶�����;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable {

	private String initPath;
	//�ļ���չ��
	private String end;
	//����˽���б�List���ԣ������洢���ҵ����ļ�������·��
	private List<String> results;
	//����һ��˽��Phaser���ԣ�������������ͬ�׶εĽ���
	private Phaser phaser;
	
	public FileSearch(String initPath, String end,  Phaser phaser) {
		super();
		this.initPath = initPath;
		this.end = end;
		this.results = new ArrayList<String>();
		this.phaser = phaser;
	}
	//�����ļ�
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
	 * ��һ�ι��˽������24Сʱ���ڵ��ļ�log
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
			System.out.println(Thread.currentThread().getName() + " �ռ��� : "+phaser.getPhase());
			// ����߳��Ѿ������� �����ټ���ִ����
			phaser.arriveAndDeregister();
			return false;
		}else{
			System.out.println(Thread.currentThread().getName()+" �ǿռ��� : "+phaser.getPhase());
			// ����߳�������
			phaser.arriveAndAwaitAdvance();
			return true;	
		}
		
	}
	/**
	 * չʾ��Ϣ
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
		//��������ʼִ�е���Ϣ��ӡ������̨
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
		System.out.println(Thread.currentThread().getName()+" : �߳�ִ�н���...");
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
		//��ӡ�������Ƿ��Ѿ���ֹ
		System.out.println("Terminated :" + phaser.isTerminated());
	}

}
