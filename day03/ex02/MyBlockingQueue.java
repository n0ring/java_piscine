import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue {
	private	Queue<Integer>	MyQ	= new LinkedList<Integer>();

	public synchronized void addSum(Integer el) {
			MyQ.add(el);
	}

	public int getItem() {
		return (int) MyQ.remove();
	}
}