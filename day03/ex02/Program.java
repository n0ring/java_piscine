import java.util.ArrayList;

public class Program {
	private static final int MAX_MODULO = 1000;
	private static final int MAX_ARRAY_NUMBER = 2000000;
	public static void main(String[] args) {
		int					arrSize, threadCount, sum = 0;
		ArrayList<Integer>	arr;
		ThreadsManager		manager;

		if (args.length != 2) {
			errorExit("Incorrect args (not 2)");
		}
		arrSize = getParams(args[0], "--arraySize");
		threadCount = getParams(args[1], "--threadsCount");
		if (arrSize > MAX_ARRAY_NUMBER || threadCount > arrSize) {
			errorExit("Params incorrect");
		}
		arr = createArray(arrSize);
		for (Integer i : arr) {
			sum += i;
		}
		System.out.println("Sum: " + sum);
		manager = new ThreadsManager(arr, threadCount);
		manager.startThreads();
		manager.printSum();
	}

	private static int getParams(String arg, String flagName) {
		String[]	arrArgs = arg.split("=");
		int			param;

		if (arrArgs == null || arrArgs.length != 2) {
			errorExit("Params incorrect");
		}
		if (!arrArgs[0].equals(flagName)) {
			errorExit("Param name incorrect");
		}		param = Integer.parseInt(arrArgs[1]);
		if (param <= 0) {
			System.err.println("Incorrect param");
			System.exit(-1);
		}
		return param;
	}

	private static void errorExit(String msg) {
		System.err.println(msg);
		System.exit(-1);
	}

	private static int getRandomValue(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}

	private static ArrayList<Integer> createArray(int size) {
		ArrayList<Integer> arr = new ArrayList<Integer>(size);

		for (int i = 0; i < size; i++) {
			arr.add(getRandomValue(-MAX_MODULO, MAX_MODULO));
		}
		return arr;
	}
}


