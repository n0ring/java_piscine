public class Program {
	public static void main(String[] args) {
		int timesToAnswer = 5;
		Thread	egg_thread;
		Thread	hen_thread;
		MyBlockingQueue myQ = new MyBlockingQueue();

		if (args.length != 1) {
			System.err.println("Incorrect args");
			System.exit(-1);
		}
		timesToAnswer = getTimesToAnswer(args[0]);
		if (timesToAnswer == -1) {
			System.err.println("Incorrect args");
			System.exit(-1);
		}
		egg_thread = new Thread(new EggThread(timesToAnswer, myQ));
		hen_thread = new Thread(new HenThread(timesToAnswer, myQ));
		egg_thread.start();
		hen_thread.start();

		try {
			egg_thread.join();
			hen_thread.join();
		} catch (Exception e) {
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
