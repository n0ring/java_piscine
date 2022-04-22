public class HenThread implements Runnable {
	private int				TimesToPrint;
	private MyBlockingQueue	myQueue;

	HenThread(int timesToPrint, MyBlockingQueue myQ) {
		TimesToPrint = timesToPrint;
		myQueue = myQ;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < this.TimesToPrint; i++) {
			myQueue.printHen();
		}
	}
}
