
public class TestThread extends Thread {
	String message;
	volatile boolean work = true;

	public TestThread(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		while (work) {
			Main.test(message);
		}
	}
}
