package test.Lock线程通信;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 缓冲区
 * @author yangfeng
 *
 */
public class Buffer {
	//用来存放共享数据
	private LinkedList<String> buffer;
	//用来存放buffer的长度
	private int maxSize;
	//锁 用来对修改的buffer的代码进行控制  
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	//用来表明缓冲区中是否还有数据
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
			System.out.println(Thread.currentThread().getName() +" 存入一条数据");
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
