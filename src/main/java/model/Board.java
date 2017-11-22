package model;

import java.util.ArrayList;

import exception.InvalidLocationException;
import exception.InvalidMoveException;
import exception.PickNullPieceException;

public class Board {
	private ArrayList<BoardRow> board = new ArrayList<BoardRow>();

	public void initialize() {
		board.add(new BoardRow("back", "white"));
		board.add(new BoardRow("front", "white"));
		for (int i = 0; i < 4; i++)
			board.add(new BoardRow());
		board.add(new BoardRow("front", "black"));
		board.add(new BoardRow("back", "black"));
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

	public void move(String currentLocation, String newLocation) {
		Piece piece = getPieceInLocation(currentLocation);
		if (piece == null)
			throw new PickNullPieceException("해당 좌표에 말이 없습니다.");
		if (!piece.isMoveable(currentLocation, newLocation))
			throw new InvalidMoveException("해당 좌표로 움직일 수 없습니다.");
		setPieceInLocation(newLocation, piece);
		setPieceInLocation(currentLocation, null);
	}

	private void setPieceInLocation(String location, Piece piece) throws InvalidLocationException {
		checkInvalidLocationException(location);
		int rowIndex = Location.indexMatchRowLocation(location);
		BoardRow boardRow = board.get(rowIndex);
		boardRow.setPiece(Location.indexMatchColumnLocation(location), piece);
		board.set(rowIndex, boardRow);
	}

	private Piece getPieceInLocation(String location) {
		checkInvalidLocationException(location);
		BoardRow boardRow = board.get(Location.indexMatchRowLocation(location));
		return boardRow.getLocationValue(Location.indexMatchColumnLocation(location));
	}

	private void checkInvalidLocationException(String location) {
		if (location.length() != 2)
			throw new InvalidLocationException("좌표를 잘 못 입력했습니다.");
	}
}