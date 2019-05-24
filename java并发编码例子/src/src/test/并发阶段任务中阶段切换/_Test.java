package test.并发阶段任务中阶段切换;

public class _Test {
	public static void main(String[] args) {
		Myphaser myphaser = new Myphaser();
		Student [] students = new Student [5];
		for(int i =0;i<students.length;i++){
			students[i] = new Student(myphaser);
			myphaser.register();
		}
		Thread thread [] = new Thread[students.length];
		for(int i =0; i<students.length;i++){
			thread[i] = new Thread(students[i],"Student"+i);
			thread[i].start();
		}
		for(int i =0; i<students.length;i++){
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main: is end " +myphaser.isTerminated());
	}
}
