
public class Program {
	private static final int DELIMITER = 10;
	public static void main(String[] args) {
		int res = 0;
		int start_value = 479598;

		res += start_value % DELIMITER;
		start_value /= DELIMITER;

		res += start_value % DELIMITER;
		start_value /= DELIMITER;

		res += start_value % DELIMITER;
		start_value /= DELIMITER;

		res += start_value % DELIMITER;
		start_value /= DELIMITER;

		res += start_value % DELIMITER;
		start_value /= DELIMITER;

		res += start_value % DELIMITER;
		start_value /= DELIMITER;

		System.out.print(res);
	}
}
