public class UserNotFoundException extends RuntimeException {
	String errorString;
	UserNotFoundException(String s) {
		errorString = s;
	}

	public String toString() {
		return errorString;
	}
}