import java.util.ArrayList;

public class MyRunnable implements Runnable {
	private int				StartIndex;
	private int				SectionSize;
	private ArrayList		ArrNumbers;
	private int				sum = 0;

	MyRunnable(int start, int size, ArrayList arr) {
		StartIndex = start;
		SectionSize = size;
		ArrNumbers = arr;
	}

	@Override
	public void run() {
		for (int i = 0; i < SectionSize; i++) {
			sum += (int) ArrNumbers.get(StartIndex + i);
		}
		System.out.println("sum from thread " + sum);
	}
	
}
