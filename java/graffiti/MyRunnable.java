public class MyRunnable implements Runnable {
	private volatile boolean active;
	public void run() {
		active = true;
		while (active) {
			//
		}
	}
	
	public void stop() {
		active = false;
		boolean result = this instanceOf Runable;
	}
}