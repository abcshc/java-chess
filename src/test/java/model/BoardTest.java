package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board board;

	@Before
	public void boardSetup() {
		board = new Board();
	}

	@Test
	public void boardCreateTest() throws Exception {
		board.initialize();

		assertEquals(16, board.pieceCount());

		String blankRank = appendNewLine("........");
		assertEquals(appendNewLine("........") + appendNewLine("pppppppp") + blankRank + blankRank + blankRank + blankRank
				+ appendNewLine("PPPPPPPP") + blankRank, board.showBoard());
	}

	private String appendNewLine(String value) {
		return value + "\n";
	}
}