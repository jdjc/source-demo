package test.Lock�߳�ͨ��;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ������
 * @author yangfeng
 *
 */
public class Buffer {
	//������Ź�������
	private LinkedList<String> buffer;
	//�������buffer�ĳ���
	private int maxSize;
	//�� �������޸ĵ�buffer�Ĵ�����п���  
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	//�����������������Ƿ�������
	private boolean pendingLines;
	public Buffer(int max) {
		this.maxSize =max;
		buffer = new LinkedList<String>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines =true;
	}
	public void insert(String line){
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
					space.await();
			}
			buffer.offer(line);
			System.out.println(Thread.currentThread().getName() +" ����һ������");
			lines.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public String get(){
		String line = null;
		lock.lock();
		try {
			while(buffer.size() ==0 && (hasPendingLines())){
					lines.await();
			}
			if(hasPendingLines()){
				line= buffer.poll();
				space.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		return null;
	}
	public void setPendingLines(boolean pendingLines){
		this.pendingLines = pendingLines;
		
	}
	public boolean hasPendingLines() {
		return pendingLines || buffer.size()>0;
	}
}
