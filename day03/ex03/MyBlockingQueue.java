import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue {
	private	Queue<String>	MyQ	= new LinkedList<String>();

	public void addUrl(String url) {
			MyQ.add(url);
	}

	public synchronized String getItem() {
		return MyQ.remove();
	}

	public void fillQ() {
		FileInputStream		fileInput;
		Scanner				sc;
		String				line;
		try {
			fileInput = new FileInputStream("files_URLs.txt");
			sc = new Scanner(fileInput);
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.length() > 0) {
					MyQ.add(line);
				}
			}
		} catch (Exception e) {
			System.err.println(e);
			System.exit(-1);
		}
	}

	public void getFile(String url) {
		try {
			InputStream in = new URL(url).openStream();
			Files.copy(in, Paths.get(getFileName(url)),
				StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private String getFileName(String url) {
		String[] arr = url.split("/");
		return arr[arr.length - 1];
	}

	public boolean startDownLoad(int id) {
		String		tmpUrl;
		String[]	urlArr;
		
		synchronized (this) {
			if (MyQ.size() == 0) {
				return false;
			}
			tmpUrl = MyQ.remove();
		}
		urlArr = tmpUrl.split(" ");
		System.out.println("Thread-" + id + " start download file number " + urlArr[0] );
		getFile(urlArr[1]);
		System.out.println("Thread-" + id + " finish download file number " + urlArr[0] );
		return true;
	}
}