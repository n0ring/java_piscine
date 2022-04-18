import java.util.Scanner;

public class Program {
	private static final int EXIT_ERROR = -1;

	public static void main(String[] args) {
		Scanner	sc		= new Scanner(System.in);
		boolean	isPrime = true;
		int		steps	= 0;
		int		input;
		int		sqrt_in;

		if (!sc.hasNextInt()) {
			error_exit(sc);
		}
		input	= sc.nextInt();
		if (input <= 1) {
			error_exit(sc);
		}
		else if (input == 2) {
			sc.close();
			System.out.println("true " + 1);
			return ;
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
			System.out.println("true " + steps);
		}
		else {
			System.out.println("false " + steps);
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

	private static void error_exit(Scanner sc)
	{
		sc.close();
		System.err.println("Illegal Argument");
		System.exit(EXIT_ERROR);
	}
}