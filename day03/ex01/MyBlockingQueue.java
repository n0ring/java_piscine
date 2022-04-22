public class MyBlockingQueue {

	private Object	shared		= new Object();
	private	boolean sharedData	= false;

	public void printEgg() {
		synchronized (shared) {
			if (sharedData == true) {
				try {
					shared.wait();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
			sharedData = true;
			System.out.println("Egg");
			synchronized (shared) {
				shared.notifyAll();
			}
		}
	}

	public void printHen() {
		synchronized (shared) {
			if (sharedData == false) {
				try {
					shared.wait();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
			sharedData = false;
			System.out.println("Hen");
			synchronized (shared) {
				shared.notifyAll();
			}
		}
	}
}