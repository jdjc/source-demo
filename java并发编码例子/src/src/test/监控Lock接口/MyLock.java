package test.监控Lock接口;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock extends ReentrantLock {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * getOwner是锁受保护的方法
	 * @return
	 */
	public String getOwnerName(){
		if(this.getOwner()==null){
			return "None";
		}
		return this.getOwner().getName();
	}
	/**
	 * getQueuedThreads是锁受保护的方法
	 * @return
	 */
	public Collection<Thread> geThreads(){
		return this.getQueuedThreads();
	}

}
