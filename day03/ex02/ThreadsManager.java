import java.util.ArrayList;
public class ThreadsManager {
	private int 				ThreadSize;
	private int					SectionSize;
	private ArrayList<Integer>	ArrNumbers;
	private ArrayList<Thread>	ArrThreads;
	private	MyBlockingQueue		MyQ	= new MyBlockingQueue();

	ThreadsManager(ArrayList<Integer> arr, int threadSize) {
		ThreadSize = threadSize;
		ArrNumbers = arr;
		SectionSize = ArrNumbers.size() / ThreadSize;
	}

	private void createThreads() {
		int i = 0;
		ArrThreads = new ArrayList<>(ThreadSize);
		for (; i < ThreadSize - 1; i++) {
			ArrThreads.add(new Thread(
				new MyRunnable(i, SectionSize * i, SectionSize, ArrNumbers, MyQ)));
			} 
		ArrThreads.add(new Thread(
			new MyRunnable(i, SectionSize * i,
				SectionSize + ArrNumbers.size() % ThreadSize, ArrNumbers, MyQ)));
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
	
	public void printSum() {
		int	sum = 0;
		for (int i = 0; i < ThreadSize; i++) {
			sum += MyQ.getItem();
		}
		System.out.println("Sum by threads: " + sum);

	}
}
