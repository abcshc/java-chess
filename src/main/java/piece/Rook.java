package piece;

import chess.Board.Color;
import chess.Location;
import exception.InvalidColorException;

public class Rook implements Piece {
	private Color color;

	public Rook(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if (Color.WHITE.equals(color))
			return 'r';
		if (Color.BLACK.equals(color))
			return 'R';
		throw new InvalidColorException("잘못된 Rook의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return true;
	}
}