package test.�̳߳�;

public class _Test {
	public static void main(String[] args) {
		Server server = new Server();
		for(int i =0;i<10;i++){
			Task task = new Task("Task" +i);
			server.executeTask(task);
		}
		server.endServer();
	}
}
