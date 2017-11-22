package model;

public interface Piece {
	public String getColor();
	public char getRepresentation();
	public boolean isMoveable(String currentLocation, String moveLocation);
}