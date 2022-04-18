import java.util.Scanner;

public class Program {
	private static final int EXIT_ERROR = -1;
	private static final int EXIT_SUCCESS = 0;

	public static void main(String[] args) {
		Scanner	sc		= new Scanner(System.in);
		int		input	= sc.nextInt();
		boolean	isPrime = true;
		int		steps	= 0;
		int		sqrt_in;

		if (input <= 1) {
			sc.close();
			System.out.print("Illegal Argument\n");
			System.exit(EXIT_ERROR);
		}
		else if (input == 2) {
			sc.close();
			System.out.print("true " + 1 + '\n');
			System.exit(EXIT_SUCCESS);
		}
		sqrt_in = get_sqrt(input);
		for (int i = 2; i <= sqrt_in; i++) {
			steps++;
			if (input % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.print("true " + steps + '\n');
		}
		else {
			System.out.print("false " + steps + '\n');
		}
		sc.close();
	}

	private static int get_sqrt(int x) {
		for (int i = 2; i < x; i++) {
			if (i * i >= x) {
				return i;
			}
		}
		return x;
	}
}