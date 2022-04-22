import java.util.ArrayList;

public class MyRunnable implements Runnable {
	private int					StartIndex;
	private int					SectionSize;
	private ArrayList<Integer>	ArrNumbers;
	private int					sum = 0;
	private int					id;
	private MyBlockingQueue		MyQ;

	MyRunnable( int i, int start, int size, ArrayList<Integer> arr, MyBlockingQueue myQ) {
		StartIndex = start;
		SectionSize = size;
		ArrNumbers = arr;
		id = i + 1;
		MyQ = myQ;
	}

	@Override
	public void run() {
		for (int i = 0; i < SectionSize; i++) {
			sum += (int) ArrNumbers.get(StartIndex + i);
		}
		MyQ.addSum(sum);
		System.out.println("Thread " + id + ": from " + StartIndex
			+ " to " + (StartIndex + SectionSize - 1) + " sum is " + sum);
	}
}
