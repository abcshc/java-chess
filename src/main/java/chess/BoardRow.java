package chess;

import java.util.ArrayList;

import chess.Board.Color;
import piece.Bishop;
import piece.Blank;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class BoardRow {
	private ArrayList<Piece> row;

	public BoardRow() {
		row = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			row.add(new Blank());
		}
	}

	private BoardRow(ArrayList<Piece> row) {
		this.row = row;
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
			if (!"Blank".equals(piece.getClass().getSimpleName()))
				count++;
		}
		return count;
	}

	public void setPiece(int index, Piece piece) {
		row.set(index, piece);
	}

	public Piece findPiece(int index) {
		return row.get(index);
	}

	private char getChar(int index) {
		if (row.get(index) == null)
			return '.';
		return row.get(index).getRepresentation();
	}

	public static BoardRow initializePawnLine(Color color) {
		ArrayList<Piece> inputRow = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			inputRow.add(new Pawn(color));
		}
		return new BoardRow(inputRow);
	}

	public static BoardRow initializeKingLine(Color color) {
		ArrayList<Piece> inputRow = new ArrayList<Piece>();
		inputRow.add(new Rook(color));
		inputRow.add(new Knight(color));
		inputRow.add(new Bishop(color));
		inputRow.add(new Queen(color));
		inputRow.add(new King(color));
		inputRow.add(new Bishop(color));
		inputRow.add(new Knight(color));
		inputRow.add(new Rook(color));
		return new BoardRow(inputRow);
	}
}