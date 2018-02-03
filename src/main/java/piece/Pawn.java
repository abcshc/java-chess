package piece;

import chess.Board.Color;
import chess.Location;
import exception.InvalidColorException;

public class Pawn implements Piece {
	private Color color;

	public Pawn(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if (Color.WHITE.equals(color))
			return 'p';
		if (Color.BLACK.equals(color))
			return 'P';
		throw new InvalidColorException("잘못된 Pawn의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return true;
	}
}