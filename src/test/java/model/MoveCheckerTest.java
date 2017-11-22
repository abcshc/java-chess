package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidMoveException;

public class MoveCheckerTest {
	private MoveChecker moveChecker = new MoveChecker();

	@Test
	public void moveDistanceTest() {
		assertEquals(1, moveChecker.rowDistance("B2", "B3"));
		assertEquals(4, moveChecker.rowDistance("B2", "B6"));
		assertEquals(1, moveChecker.columnDistance("B2", "C2"));
		assertEquals(5, moveChecker.columnDistance("B2", "G3"));
	}

	@Test
	public void moveCheckerTest() {
		// 4방향
		assertEquals("S", moveChecker.getDirectionMoveLocation("B2", "B3"));
		assertEquals("E", moveChecker.getDirectionMoveLocation("B2", "C2"));
		assertEquals("N", moveChecker.getDirectionMoveLocation("B2", "B1"));
		assertEquals("W", moveChecker.getDirectionMoveLocation("B2", "A2"));
		// 4방향 2이상
		assertEquals("S", moveChecker.getDirectionMoveLocation("B2", "B4"));
		assertEquals("E", moveChecker.getDirectionMoveLocation("B2", "D2"));
		assertEquals("N", moveChecker.getDirectionMoveLocation("B3", "B1"));
		assertEquals("W", moveChecker.getDirectionMoveLocation("C2", "A2"));
		// 8방향
		assertEquals("NE", moveChecker.getDirectionMoveLocation("B2", "C1"));
		assertEquals("SW", moveChecker.getDirectionMoveLocation("B2", "A3"));
		assertEquals("NW", moveChecker.getDirectionMoveLocation("B2", "A1"));
		assertEquals("SE", moveChecker.getDirectionMoveLocation("B2", "C3"));
		// 8방향 2이상
		assertEquals("NE", moveChecker.getDirectionMoveLocation("B3", "D1"));
		assertEquals("SW", moveChecker.getDirectionMoveLocation("C1", "A3"));
		assertEquals("NW", moveChecker.getDirectionMoveLocation("C3", "A1"));
		assertEquals("SE", moveChecker.getDirectionMoveLocation("A1", "C3"));

		// Knight(8개)
		assertEquals("NNE", moveChecker.getDirectionMoveLocation("B3", "C1"));
		assertEquals("NNW", moveChecker.getDirectionMoveLocation("B3", "A1"));
		assertEquals("SSE", moveChecker.getDirectionMoveLocation("B3", "C5"));
		assertEquals("SSW", moveChecker.getDirectionMoveLocation("B3", "A5"));
		assertEquals("NEE", moveChecker.getDirectionMoveLocation("B2", "D1"));
		assertEquals("NWW", moveChecker.getDirectionMoveLocation("C2", "A1"));
		assertEquals("SEE", moveChecker.getDirectionMoveLocation("B3", "D4"));
		assertEquals("SWW", moveChecker.getDirectionMoveLocation("C3", "A4"));
	}

	@Test(expected = InvalidMoveException.class)
	public void moveCheckerException() {
		moveChecker.getDirectionMoveLocation("B2", "B2");
	}
}
