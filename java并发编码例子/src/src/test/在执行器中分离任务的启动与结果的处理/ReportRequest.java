package test.在执行器中分离任务的启动与结果的处理;

import java.util.concurrent.CompletionService;
/**
 * 模拟请求获取报告
 * @author yangfeng
 *
 */
public class ReportRequest implements Runnable {
	private String name;
	private CompletionService<String> service;
	public ReportRequest(String name,CompletionService<String> service) {
		this.name = name;
		this.service = service;
	}
	@Override
	public void run() {
		ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
		service.submit(reportGenerator);
	}

}
