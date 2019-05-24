package test.在执行器中控制任务的完成;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class ResultTask extends FutureTask<String> {
	private String name;
	public ResultTask(Callable<String> callable) {
		super(callable);
		this.name = ((ExecutableTask)callable).getName();
	}
	@Override
	protected void done() {
		if(isCancelled()){
			System.out.println(name+":任务在完成之前 被中断了。。。。");
		}
		else{
			System.out.println(name+":任务已经完成了。。。。");
		}
	}

}
