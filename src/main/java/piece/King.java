package piece;

import chess.Board.Color;
import chess.Location;
import chess.MoveChecker;
import chess.Movement;
import chess.Movement.Direction;
import exception.InvalidColorException;

public class King implements Piece {
	private Color color;
	private MoveChecker moveChecker = new MoveChecker();

	public King(Color color) {
		this.color = color;
		moveChecker.addRule(new Movement(Direction.S, 1));
		moveChecker.addRule(new Movement(Direction.E, 1));
		moveChecker.addRule(new Movement(Direction.N, 1));
		moveChecker.addRule(new Movement(Direction.W, 1));
		moveChecker.addRule(new Movement(Direction.NE, 1));
		moveChecker.addRule(new Movement(Direction.SW, 1));
		moveChecker.addRule(new Movement(Direction.NW, 1));
		moveChecker.addRule(new Movement(Direction.SE, 1));
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if (Color.WHITE.equals(color))
			return 'k';
		if (Color.BLACK.equals(color))
			return 'K';
		throw new InvalidColorException("잘못된 Kinght의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return moveChecker.isMovable(currentLocation, moveLocation);
	}
}