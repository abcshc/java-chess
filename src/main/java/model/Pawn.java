package model;

import exception.InvalidColorException;

public class Pawn implements Piece {
	private String color;
	private MoveChecker moveChecker = new MoveChecker();

	public Pawn(String color) {
		this.color = color;
//		moveChecker.addRule();
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		if ("white".equals(color))
			return 'p';
		if ("black".equals(color))
			return 'P';
		throw new InvalidColorException("잘못된 Pawn의 색상입니다.");
	}

	@Override
	public boolean isMoveable(String currentLocation, String moveLocation) {
		return moveChecker.isMoveable(currentLocation, moveLocation);
	}

	private int checkGoForwardDistance(String currentLocation) {
		if (isFirstMove(color, currentLocation))
			return 2;
		return 1;
	}

	private boolean isFirstMove(String color, String currentLocation) {
		if ("white".equals(color))
			return Location.indexMatchRowLocation(currentLocation) == 1;
		if ("black".equals(color))
			return Location.indexMatchRowLocation(currentLocation) == 6;
		return false;
	}

}