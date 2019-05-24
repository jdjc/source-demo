package test.¼à¿ØLogSystem;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("["+record.getLevel()+"]");
		stringBuffer.append(new Date(record.getMillis()));
		stringBuffer.append(record.getSourceClassName()+"." + record.getSourceMethodName()+":");
		stringBuffer.append(record.getMessage());
		return stringBuffer.toString();
	}

}
