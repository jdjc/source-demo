package test.ForkJoin取消任务;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class SearchNumberTask extends RecursiveTask<Integer> {
	private int numbers[];
	//声明两个分别名为start end的私有属性 这两个属性决定任务要处理的数组的元素
	private int start,end;
	//声明一个名为number的私有int属性 用来存储将要寻找的数字
	private int number;
	//这个对象用来取消所有任务
	private TaskManager manager;
	//当任务找不到数字时将返回这个常量
	private final static int NOT_FOUND = -1;
	
	public SearchNumberTask(int[] numbers, int start, int end, int number, TaskManager manager) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
		this.number = number;
		this.manager = manager;
	}

	@Override
	protected Integer compute() {
		System.out.println("Task: " + start+ ":" + end);
		int ret;
		if(end - start >10){
			ret =launchTasks();
		}
		else{
			ret = lookForNumber();
		}
		return ret;
	}

	private int lookForNumber() {
		for(int i = start; i<end;i++){
			if(numbers[i] ==  number){
				System.out.println("找到元素 ： 位置" +  i + " ： number : "+number);
				manager.cancelTasks(this);
				return i;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return NOT_FOUND;
	}

	private int launchTasks() {
		int mid =(start + end) /2;
		SearchNumberTask task1 = new SearchNumberTask(numbers, start, mid, number, manager);
		SearchNumberTask task2 = new SearchNumberTask(numbers, start, mid, number, manager);
		manager.addTask(task1);
		manager.addTask(task2);
		task1.fork();
		task2.fork();
		int returnValue ;
		returnValue = task1.join();
		if(returnValue !=-1){
			return returnValue;
		}
		returnValue = task2.join();
		return returnValue;
	}
	/**
	 * 将结束任务的信息打印出来
	 */
	public void writeCanelMessage() {
		System.out.println("Task: 任务取消啦　　：　"+start+":"+end);
	}

}
