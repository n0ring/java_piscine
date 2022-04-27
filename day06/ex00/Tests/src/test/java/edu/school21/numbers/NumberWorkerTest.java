package edu.school21.numbers;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {
	NumberWorker numberWorker;

	@BeforeEach
	void setUp() {
		numberWorker = new NumberWorker();
	}

	@Test
	@DisplayName("isPrimeForPrimes")
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 37, 9973})
	public void isPrimeForPrimes(int number) {
		assertTrue(numberWorker.isPrime(number));}

	@Test
	@DisplayName("isPrimeForNotPrimes")
	@ParameterizedTest
	@ValueSource(ints = {4, 99, 111000, 2000, 2002})
	public void isPrimeForNotPrimes(int number) {
		assertFalse(numberWorker.isPrime(number));
	}


	@Test
	@DisplayName("isPrimeForIncorrectNumbers")
	@ParameterizedTest
	@ValueSource(ints = {-10, -1, 0, 1})
	public void isPrimeForIncorrectNumbers(int number) {
		IllegalNumberException thrown = assertThrows(IllegalNumberException.class,
				()-> {
			numberWorker.isPrime(number);
		});
		assertTrue(thrown.toString().contains("Number is <= 1"));
	}

	@Test
	@DisplayName("digitsSumSetNumber")
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv")
	public void digitsSumSetNumber(int number, int sum) {
		assertEquals(sum, numberWorker.digitsSum(number));
	}
}
