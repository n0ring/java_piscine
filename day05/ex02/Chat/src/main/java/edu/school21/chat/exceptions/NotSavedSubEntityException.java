package edu.school21.chat.exceptions;

public class NotSavedSubEntityException extends IllegalArgumentException {
	private String S;

	public NotSavedSubEntityException(String s) {
		S = s;
	}

	@Override
	public String toString() {
		return S;
	}
}
