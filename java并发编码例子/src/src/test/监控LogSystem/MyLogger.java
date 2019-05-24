package test.¼à¿ØLogSystem;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
	private static Handler handler;
	public static Logger getLogger (String name){
		Logger logger = Logger.getLogger(name);
		logger.setLevel(Level.ALL);
		if(handler==null){
			try {
				handler = new FileHandler("recipe8.log");
				Formatter formatter = new MyFormatter();
				handler.setFormatter(formatter);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(logger.getHandlers().length==0){
			logger.addHandler(handler);
		}
		return logger;
	}
}
