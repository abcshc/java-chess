package piece;

import chess.Board.Color;
import chess.Movement.Direction;
import chess.Location;
import chess.MoveChecker;
import chess.Movement;
import exception.InvalidColorException;

public class Knight implements Piece {
	private Color color;
	private MoveChecker moveChecker = new MoveChecker();

	public Knight(Color color) {
		this.color = color;
		moveChecker.addRule(new Movement(Direction.NNE));
		moveChecker.addRule(new Movement(Direction.NNW));
		moveChecker.addRule(new Movement(Direction.SSE));
		moveChecker.addRule(new Movement(Direction.SSW));
		moveChecker.addRule(new Movement(Direction.NEE));
		moveChecker.addRule(new Movement(Direction.NWW));
		moveChecker.addRule(new Movement(Direction.SEE));
		moveChecker.addRule(new Movement(Direction.SWW));
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if (Color.WHITE.equals(color))
			return 'n';
		if (Color.BLACK.equals(color))
			return 'N';
		throw new InvalidColorException("잘못된 Knight의 색상입니다.");
	}

	@Override
	public boolean isMovable(Location currentLocation, Location moveLocation) {
		return moveChecker.isMovable(currentLocation, moveLocation);
	}
}