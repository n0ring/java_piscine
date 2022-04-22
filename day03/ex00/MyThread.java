public class MyThread extends Thread {
	private String	Answer;
	private int		TimesToPrint;

	MyThread(String answer, int timesToPrint) {
		Answer = answer;
		TimesToPrint = timesToPrint;
	}
	
	public void run() {
		for (int i = 0; i < this.TimesToPrint; i++) {
			System.out.println(Answer);
		}
	}
}
