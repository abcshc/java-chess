package piece;

import chess.Board.Color;
import chess.Location;

public interface Piece {
	Color getColor();
	char getRepresentation();
	boolean isMovable(Location currentLocation, Location moveLocation);
}