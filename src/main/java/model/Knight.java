package model;

import exception.InvalidColorException;

public class Knight implements Piece {
	private String color;
	private MoveChecker moveChecker = new MoveChecker();

	public Knight(String color) {
		this.color = color;
		moveChecker.addRule("NNE");
		moveChecker.addRule("NNW");
		moveChecker.addRule("SSE");
		moveChecker.addRule("SSW");
		moveChecker.addRule("NEE");
		moveChecker.addRule("NWW");
		moveChecker.addRule("SEE");
		moveChecker.addRule("SWW");
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if ("white".equals(color))
			return 'n';
		if ("black".equals(color))
			return 'N';
		throw new InvalidColorException("잘못된 Knight의 색상입니다.");
	}

	@Override
	public boolean isMoveable(String currentLocation, String moveLocation) {
		return moveChecker.isMoveable(currentLocation, moveLocation);
	}
}