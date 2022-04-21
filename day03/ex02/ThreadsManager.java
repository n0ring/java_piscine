import java.util.ArrayList;

public class ThreadsManager {
	private int 				ThreadSize;
	private int					SectionSize;
	private ArrayList			ArrNumbers;
	private ArrayList<Thread>	ArrThreads;

	ThreadsManager(ArrayList arr, int threadSize) {
		ThreadSize = threadSize;
		ArrNumbers = arr;
		SectionSize = ArrNumbers.size() / ThreadSize;
	}

	private void createThreads() {
		int i = 0;
		ArrThreads = new ArrayList<>(ThreadSize);
		for (; i < ThreadSize - 1; i++) {
			ArrThreads.add(new Thread(
				new MyRunnable(i * SectionSize, SectionSize, ArrNumbers)));
			}
/// stop here need for last thread section
			ArrThreads.add(new Thread(
				new MyRunnable(i * SectionSize, SectionSize, ArrNumbers)));
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
