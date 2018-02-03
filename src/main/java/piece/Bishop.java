package piece;

import chess.Location;
import chess.Board.Color;
import exception.InvalidColorException;

public class Bishop implements Piece {
	private Color color;

	public Bishop(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if (Color.WHITE.equals(color))
			return 'b';
		if (Color.BLACK.equals(color))
			return 'B';
		throw new InvalidColorException("잘못된 Bishop의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return true;
	}
}