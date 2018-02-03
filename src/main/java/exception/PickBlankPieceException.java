package exception;

public class PickBlankPieceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PickBlankPieceException(String message) {
		super(message);
	}
}