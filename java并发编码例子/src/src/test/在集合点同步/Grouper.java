package test.�ڼ��ϵ�ͬ��;

public class Grouper implements Runnable {
	private Results results;
	public Grouper(Results results) {
		this.results= results;
	}
	@Override
	public void run() {
		int finalResult = 0;
		for(int num:results.getData()){
			finalResult +=num;
		}
		System.out.println("�ܹ�������" + finalResult+"�Σ�");
	}

}
