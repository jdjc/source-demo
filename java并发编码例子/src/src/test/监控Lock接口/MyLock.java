package test.���Lock�ӿ�;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock extends ReentrantLock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * getOwner�����ܱ����ķ���
	 * @return
	 */
	public String getOwnerName(){
		if(this.getOwner()==null){
			return "None";
		}
		return this.getOwner().getName();
	}
	/**
	 * getQueuedThreads�����ܱ����ķ���
	 * @return
	 */
	public Collection<Thread> geThreads(){
		return this.getQueuedThreads();
	}

}
