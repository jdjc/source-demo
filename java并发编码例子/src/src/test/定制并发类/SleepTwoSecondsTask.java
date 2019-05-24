package test.定制并发类;

import java.util.concurrent.Callable;

public class SleepTwoSecondsTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		return "SleepTwoSeconds ....";
	}

}
