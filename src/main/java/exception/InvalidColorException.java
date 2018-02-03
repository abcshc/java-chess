package exception;

public class InvalidColorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidColorException(String message) {
		super(message);
	}
}