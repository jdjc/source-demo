package test.在执行器中分离任务的启动与结果的处理;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ReportProcessor implements Runnable {
	private CompletionService<String> service;
	private boolean end;
	public ReportProcessor(CompletionService<String> service) {
		this.service = service;
		end =false;
	}
	@Override
	public void run() {
		while (!end) {
			try {
				//获取一个已经完成任务的Future对象
				Future<String> result = service.poll(20,TimeUnit.SECONDS);
				if(result!=null){
					String report = result.get();
					System.out.println("ReportReceiver: Report Received:已经完成的任务" + report);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
}
