package model;

import org.junit.Before;
import org.junit.Test;

public class KnightTest {
	Board board;

	@Before
	public void setupBoard() {
		board = new Board();
		board.initialize();
	}

	@Test
	public void knightMoveTest() {
		System.out.println(board.showBoard());
	}

}
