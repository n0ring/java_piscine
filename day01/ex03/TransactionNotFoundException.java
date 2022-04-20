public class TransactionNotFoundException extends RuntimeException {
	private String errorString;
	TransactionNotFoundException(String s) {
		errorString = s;
	}

	public String toString() {
		return errorString;
	}
}