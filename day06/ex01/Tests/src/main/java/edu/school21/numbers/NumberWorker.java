package edu.school21.numbers;

public class NumberWorker {
	public boolean isPrime(int number) throws IllegalNumberException {
		int sqrt_in;

		if (number <= 1) {
			throw new IllegalNumberException("Number is <= 1");
		}
		if (number == 2) {
			return true;
		}
		sqrt_in = get_sqrt(number);
		for (int i = 2; i <= sqrt_in; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int digitsSum(int number) {
		int res = 0;
		while (number != 0) {
			res += number % 10;
			number /= 10;
		}
		return res;
	}

	private static int get_sqrt(int x) {
		for (int i = 2; i < x; i++)
		{
			if (i * i >= x)
				return i;
		}
		return x;
	}

}

class IllegalNumberException extends IllegalArgumentException {
	String S;
	public IllegalNumberException(String s) {
		S = s;
	}

	@Override
	public String toString() {
		return "IllegalNumberException{" +
				"S='" + S + '\'' +
				'}';
	}
}
