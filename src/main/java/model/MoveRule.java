package model;

public class MoveRule {
	String direction;
	int moveDistance = 0;

	public MoveRule(String direction) {
		this.direction = direction;
	}

	public MoveRule(String direction, int moveDistance) {
		this.direction = direction;
		this.moveDistance = moveDistance;
	}

	public String getDirection() {
		return direction;
	}
	
	public boolean isMove(String moveDirection) {
		return direction.equals(moveDirection);
	}
}