package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import chess.Board;

public class BoardTest {
	private Board board;

	@Before
	public void boardSetup() {
		board = new Board();
	}

	@Test
	public void boardCreateTest() throws Exception {
		board.initialize();

		assertEquals(32, board.pieceCount());

		assertEquals(
				appendNewLine("rnbqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("........") +
				appendNewLine("........") +
				appendNewLine("........") +
				appendNewLine("........") +
				appendNewLine("PPPPPPPP") +
				appendNewLine("RNBQKBNR"), board.showBoard());
	}

	private String appendNewLine(String value) {
		return value + "\n";
	}
}