package test.ForkJoin线程池中合并任务的结果;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
//处理文档
public class DocumentTask extends RecursiveTask<Integer> {
	private String document[][];
	private int start,end ;
	private String word;
	
	public DocumentTask(String[][] document, int start, int end, String word) {
		this.document = document;
		this.start = start;
		this.end = end;
		this.word = word;
	}

	@Override
	protected Integer compute() {
		int result = 0 ;
		if(end -start<10){
			result = processLines(document,start,end,word);
		}
		else{
			int mid = (start+end)/2;
			DocumentTask task1 = new DocumentTask(document, start, mid, word);
			DocumentTask task2 = new DocumentTask(document, mid, end, word);
			invokeAll(task1, task2);
			try {
				//如果大于10
				result = groupResults(task1.get(),task2.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private int groupResults(Integer number1, Integer number2) {
		int result;
		result = number1+number2;
		return result;
	}

	private int processLines(String[][] document, int start, int end, String word) {
		List<LinkTask> tasks = new ArrayList<>();
		for(int i =start;i<end;i++){
			LinkTask task = new LinkTask(document[i],0,document[i].length,word);
			tasks.add(task);
		}
		invokeAll(tasks);
		int result = 0;
		for(int i =0;i<tasks.size();i++){
			LinkTask linkTask = tasks.get(i);
			try {
				result += linkTask.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
