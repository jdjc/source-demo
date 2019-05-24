package test.¼à¿ØLogSystem;

import java.util.logging.Level;
import java.util.logging.Logger;

public class _Test {
	public static void main(String[] args) {
		Logger logger = MyLogger.getLogger("Core");
		logger.entering("Core", "main()",args);
		Thread [] threads= new Thread[5];
		for(int i =0;i<threads.length;i++){
			logger.log(Level.INFO, "THREAD"+i);
			Task task = new Task();
			threads[i] = new Thread(task);
			logger.log(Level.INFO, "create"+threads[i].getName());
			threads[i].start();
		}
		
	}
}
