import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		MyBlockingQueue		MyQ = new MyBlockingQueue();
		int					threadCount;
		ThreadsManager		manager;


		if (args.length != 1) {
			errorExit("Incorrect args (not 1)");
		}
		threadCount = getParams(args[0], "--threadsCount");
		MyQ.fillQ();		
		manager = new ThreadsManager(MyQ, threadCount);
		manager.startThreads();
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


}

// get urls from files
// create a queue 
// add urls to queue
// download files
// start threads to take from q urls

