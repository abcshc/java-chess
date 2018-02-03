package chess;

import java.util.ArrayList;

import exception.InvalidLocationException;
import exception.InvalidMoveException;
import piece.Blank;
import piece.Piece;

public class Board {
	private ArrayList<BoardRow> board = new ArrayList<BoardRow>();

	public void initialize() {
		board.add(BoardRow.initializeKingLine(Color.WHITE));
		board.add(BoardRow.initializePawnLine(Color.WHITE));
		for (int i = 0; i < 4; i++)
			board.add(new BoardRow());
		board.add(BoardRow.initializePawnLine(Color.BLACK));
		board.add(BoardRow.initializeKingLine(Color.BLACK));
	}

	public int pieceCount() {
		return board.stream().mapToInt(BoardRow::pieceCount).sum();
	}

	public String showBoard() {
		String result = "";
		for (BoardRow boardRow : board) {
			result += boardRow.getLine() + "\n";
		}
		return result;
	}

	public void move(String currentValue, String newValue) {
		Location currentLocation = new Location(currentValue);
		Location newLocation = new Location(newValue);
		Piece pickPiece = getPieceInLocation(currentLocation);
		Piece attackedPiece = getPieceInLocation(newLocation);
		if (!pickPiece.isMovable(currentLocation, newLocation))
			throw new InvalidMoveException("말 움직임 규칙에 위반됩니다.");
		if (attackedPiece.getColor().equals(pickPiece.getColor()))
			throw new InvalidMoveException("같은 색의 말을 공격할 수 없습니다.");
		setPieceInLocation(newLocation, pickPiece);
		setPieceInLocation(currentLocation, new Blank());
	}

	private void setPieceInLocation(Location location, Piece piece) throws InvalidLocationException {
		int rowIndex = location.getRowIndex();
		BoardRow boardRow = board.get(rowIndex);
		boardRow.setPiece(location.getColumnIndex(), piece);
		board.set(rowIndex, boardRow);
	}

	private Piece getPieceInLocation(Location location) {
		BoardRow boardRow = board.get(location.getRowIndex());
		return boardRow.findPiece(location.getColumnIndex());
	}

	public static enum Color {
		WHITE("white"), BLACK("black"), NONE("none");
		private String value;

		Color(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
}