public class TransactionListEmptyException extends RuntimeException {
	private String errorString;
	TransactionListEmptyException(String s) {
		errorString = s;
	}

	public String toString() {
		return errorString;
	}
}