package piece;

import chess.Location;
import chess.Board.Color;
import exception.InvalidColorException;

public class Queen implements Piece {
	private Color color;

	public Queen(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if (Color.WHITE.equals(color))
			return 'q';
		if (Color.BLACK.equals(color))
			return 'Q';
		throw new InvalidColorException("잘못된 Queen의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return true;
	}
}