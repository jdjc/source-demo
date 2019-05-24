package test.Lock线程通信;

/**
 * 生产者
 * @author yangfeng
 *
 */
public class Producer implements Runnable {
	private FileMock fileMock;
	private Buffer buffer;
	public Producer(FileMock fileMock , Buffer buffer) {
		this.buffer=buffer;
		this.fileMock=fileMock;
	}
	@Override
	public void run() {
		buffer.setPendingLines(true);
		while (fileMock.hasMoreLines()) {
			String line = fileMock.getLine();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}

}
