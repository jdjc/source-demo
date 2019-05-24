package test.��ִ�����п�����������;

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
			System.out.println(name+":���������֮ǰ ���ж��ˡ�������");
		}
		else{
			System.out.println(name+":�����Ѿ�����ˡ�������");
		}
	}

}
