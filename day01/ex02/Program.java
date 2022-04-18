import java.util.Scanner;

public class Program
{
	private static final int END_OF_INPUT = 42;
	public static void main(String[] args) {
		Scanner sc		= new Scanner(System.in);
		int		coffee = 0;
		int		input;
		
		while (true) {
			input = sc.nextInt();
			if (input == END_OF_INPUT) {
				break ;
			}
			if (input <= 1) {
				System.out.print("Illegal Argument\n");
				System.exit(1);
			}
			if (isPrime(getSum(input))) {
				coffee++;
			}
		}
		System.out.print("Count of coffee-request - " + coffee + '\n');
		sc.close();
	}

	private static int getSum(int x) {
		int res = 0;
		while (x != 0) {
			res += x % 10;
			x /= 10;
		}
		return res;
	}

	private static boolean isPrime(int x) {
		int sqrt_in;

		if (x == 1) {
			return false;
		}
		if (x == 2) {
			return true;
		}
		sqrt_in = sqrt(x);
		for (int i = 2; i <= sqrt_in; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int sqrt(int x) {
		for (int i = 2; i < x; i++)
		{
			if (i * i >= x)
				return i;
		}
		return x;
	}
}