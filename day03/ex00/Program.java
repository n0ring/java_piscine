public class Program {
	public static void main(String[] args) {
		int timesToAnswer;
		MyThread egg, hen;

		if (args.length != 1) {
			System.err.println("Incorrect args");
			System.exit(-1);
		}

		timesToAnswer = getTimesToAnswer(args[0]);

		if (timesToAnswer == -1) {
			System.err.println("Incorrect args");
			System.exit(-1);
		}
		egg = new MyThread("egg", timesToAnswer);
		hen = new MyThread("hen", timesToAnswer);
		
		egg.start();
		hen.start();

		try {
			egg.join();
			hen.join();
		} catch (Exception e) {
		}
		for (int i = 0; i < timesToAnswer; i++) {
			System.out.println("Human");
		}
	}

	public static int getTimesToAnswer(String args) {
		try {
			String[] argsArr = args.split("=");
			int		n;
			if (argsArr.length != 2) {
				return -1;
			}
			n = Integer.parseInt(argsArr[1]);
			if (!argsArr[0].equals("--count") || n < 1) {
				return -1;
			}
			return n;
		} catch (Exception e) {
			System.err.println(e);
			return -1;
		}
	}
}
