package chess;

import java.util.ArrayList;

public class MoveChecker {
	private ArrayList<Movement> rules = new ArrayList<Movement>();

	public void addRule(Movement movement) {
		rules.add(movement);
	}

	public boolean isMovable(Location currentLocation, Location moveLocation) {
		Movement direction = getMovementByLocation(currentLocation, moveLocation);
		return rules.stream().anyMatch(rule -> rule.equals(direction));
	}

	public Movement getMovementByLocation(Location currentLocation, Location moveLocation) {
		return new Movement(currentLocation, moveLocation);
	}
}