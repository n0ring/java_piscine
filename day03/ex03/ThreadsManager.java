import java.util.ArrayList;
public class ThreadsManager {
	private int 				ThreadSize;
	private ArrayList<Thread>	ArrThreads;
	private	MyBlockingQueue		MyQ;

	ThreadsManager(MyBlockingQueue q, int threadSize) {
		ThreadSize = threadSize;
		MyQ = q;
	}

	private void createThreads() {
		ArrThreads = new ArrayList<>(ThreadSize);
		for (int i = 0; i < ThreadSize; i++) {
			ArrThreads.add(new Thread(
				new MyRunnable(MyQ, i) ) );
			}
	}

	public void startThreads() {
		createThreads();
		for (Thread thread : ArrThreads) {
			thread.start();
		}
		try {
			for (Thread thread : ArrThreads) {
				thread.join();
			}
		} catch (Exception e) {

		}
	}
}
