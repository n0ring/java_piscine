
public class Program {
	private static final int DELIMITER = 10;

	public static void main(String[] args) {
		int res = 0;
		int number = 479598;

		res += number % DELIMITER;
		number /= DELIMITER;

		res += number % DELIMITER;
		number /= DELIMITER;

		res += number % DELIMITER;
		number /= DELIMITER;

		res += number % DELIMITER;
		number /= DELIMITER;

		res += number % DELIMITER;
		number /= DELIMITER;

		res += number % DELIMITER;
		number /= DELIMITER;

		System.out.println(res);
	}
}
