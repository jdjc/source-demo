package test.���Ʋ�����;

import java.util.concurrent.Callable;

public class SleepTwoSecondsTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		return "SleepTwoSeconds ....";
	}

}
