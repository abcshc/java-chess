package model;

import java.util.ArrayList;

import exception.InvalidMoveException;

public class MoveChecker {
	private ArrayList<MoveRule> rules = new ArrayList<MoveRule>();

	public void addRule(String direction) {
		rules.add(new MoveRule(direction));
	}

	public void addRule(String direction, int moveDistance) {
		rules.add(new MoveRule(direction, moveDistance));
	}

	public boolean isMoveable(String currentLocation, String moveLocation) {
		String direction = getDirectionMoveLocation(currentLocation, moveLocation);
		return rules.stream().allMatch(rule -> rule.isMove(direction));
	}

	public String getDirectionMoveLocation(String currentLocation, String moveLocation) {
		int moveRowDistance = rowDistance(currentLocation, moveLocation);
		int moveColumnDistance = columnDistance(currentLocation, moveLocation);
		return moveDirection(moveRowDistance, moveColumnDistance);
	}

	public int rowDistance(String currentLocation, String moveLocation) {
		return Location.indexMatchRowLocation(moveLocation) - Location.indexMatchRowLocation(currentLocation);
	}

	public int columnDistance(String currentLocation, String moveLocation) {
		return Location.indexMatchColumnLocation(moveLocation) - Location.indexMatchColumnLocation(currentLocation);
	}

	public String moveDirection(int rowDistance, int columnDistance) {
		if (columnDistance == 0 && rowDistance == 0)
			throw new InvalidMoveException("잘못된 이동입니다. (이동거리가 없습니다.)");
		if (Math.abs(columnDistance) == Math.abs(rowDistance) || columnDistance == 0 || rowDistance == 0)
			return eightDirection(columnDistance, rowDistance);
		String direction = "";
		for (int i = 0; i < Math.abs(rowDistance); i++) {
			direction += rowDirection(rowDistance);
		}
		for (int i = 0; i < Math.abs(columnDistance); i++) {
			direction += columnDirection(columnDistance);
		}

		return direction;
	}

	private String rowDirection(int rowDistance) {
		if (rowDistance < 0)
			return "N";
		if (rowDistance > 0)
			return "S";
		return "";
	}

	private String columnDirection(int columnDistance) {
		if (columnDistance > 0)
			return "E";
		if (columnDistance < 0)
			return "W";
		return "";
	}

	private String eightDirection(int columnDistance, int rowDistance) {
		String direction = "";
		direction += rowDirection(rowDistance);
		direction += columnDirection(columnDistance);
		return direction;
	}
}