package chess;

import exception.InvalidMoveException;

public class Movement {
	private Direction moveDirection;
	private int moveDistance;

	public Movement(Location currentLocation, Location moveLocation) {
		int rowDistance = rowDistance(currentLocation, moveLocation);
		int columnDistance = columnDistance(currentLocation, moveLocation);
		this.moveDirection = moveDirection(rowDistance, columnDistance);
		moveDistance = moveDistance(rowDistance, columnDistance);
	}

	public Movement(Direction moveDirection, int moveDistance) {
		this.moveDirection = moveDirection;
		this.moveDistance = moveDistance;
	}

	public Movement(Direction moveDirection) {
		this.moveDirection = moveDirection;
	}

	public Direction getMoveDirection() {
		return moveDirection;
	}

	public int getMoveDistance() {
		return moveDistance;
	}

	public boolean equals(Movement move) {
		Direction direction = move.getMoveDirection();
		int distance = move.getMoveDistance();
		if (move.getMoveDistance() > 0)
			return moveDirection.equals(direction) && moveDistance == distance;
		return moveDirection.equals(direction);
	}

	private int moveDistance(int rowDistance, int columnDistance) {
		int row = Math.abs(rowDistance);
		int column = Math.abs(columnDistance);
		if (row == 0)
			return column;
		if (column == 0)
			return Math.abs(row);
		if (row == column)
			return row;
		return 0;
	}

	private int rowDistance(Location currentLocation, Location moveLocation) {
		return moveLocation.getRowIndex() - currentLocation.getRowIndex();
	}

	private int columnDistance(Location currentLocation, Location moveLocation) {
		return moveLocation.getColumnIndex() - currentLocation.getColumnIndex();
	}

	private Direction moveDirection(int rowDistance, int columnDistance) {
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
		return Direction.valueOf(direction);
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

	private Direction eightDirection(int columnDistance, int rowDistance) {
		String direction = "";
		direction += rowDirection(rowDistance);
		direction += columnDirection(columnDistance);
		return Direction.valueOf(direction);
	}

	public static enum Direction {
		N("N"), S("S"), E("E"), W("W"), NE("NE"), NW("NW"), SE("SE"), SW("SW"), NNE("NNE"), NNW("NNW"), NEE("NEE"), NWW(
				"NWW"), SSE("SSE"), SSW("SSW"), SEE("SEE"), SWW("SWW");

		private String direction;

		Direction(String direction) {
			this.direction = direction;
		}

		public String getDirection() {
			return direction;
		}
	}
}