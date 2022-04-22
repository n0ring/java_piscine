import java.util.ArrayList;

public class MyRunnable implements Runnable {
	private int					id;
	private MyBlockingQueue		MyQ;

	MyRunnable(MyBlockingQueue myQ, int i ) {;
		MyQ = myQ;
		id = i + 1;
	}

	@Override
	public void run() {
		while (MyQ.startDownLoad(id)) {}
	}
}
