package app.exceptions;

public class UserCredentialsIncorrectException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserCredentialsIncorrectException(String message) {
		super(message);
	}
}
