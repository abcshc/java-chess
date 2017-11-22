package model;

import java.util.ArrayList;

public class BoardRow {
	private ArrayList<Piece> row;

	public BoardRow() {
		row = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			row.add(null);
		}
	}

	public BoardRow(String line, String color) {
		if ("front".equals(line))
			row = initializeFrontLine(color);
		if ("back".equals(line))
			row = initializeBackLine(color);
	}

	public String getLine() {
		String result = "";
		for (int i = 0; i < 8; i++) {
			result += getChar(i);
		}
		return result;
	}

	public int pieceCount() {
		int count = 0;
		for (Piece piece : row) {
			if (piece != null)
				count++;
		}
		return count;
	}

	public void setPiece(int index, Piece piece) {
		row.set(index, piece);
	}

	public Piece getLocationValue(int index) {
		return row.get(index);
	}

	private char getChar(int index) {
		if (row.get(index) == null)
			return '.';
		return row.get(index).getRepresentation();
	}

	private ArrayList<Piece> initializeFrontLine(String color) {
		ArrayList<Piece> inputRow = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			inputRow.add(new Pawn(color));
		}
		return inputRow;
	}

	private ArrayList<Piece> initializeBackLine(String color) {
		ArrayList<Piece> inputRow = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			inputRow.add(null);
		}
		inputRow.set(1, new Knight(color));
		inputRow.set(6, new Knight(color));
		return inputRow;
	}
}