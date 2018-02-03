package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import chess.Board;
import exception.PickBlankPieceException;

public class BoardMoveTest {
	private Board board;

	@Before
	public void boardSetup() {
		board = new Board();
		board.initialize();
	}

	@Test
	public void boardCreateTest() {
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

	@Test
	public void boardMoveTest1() {
		board.move("B2", "B3");
		assertEquals(
				appendNewLine("rnbqkbnr") + 
				appendNewLine("p.pppppp") + 
				appendNewLine(".p......") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
		board.move("B3", "B4");
		assertEquals(
				appendNewLine("rnbqkbnr") + 
				appendNewLine("p.pppppp") + 
				appendNewLine("........") + 
				appendNewLine(".p......") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
	}

	@Test(expected = PickBlankPieceException.class)
	public void boardMoveExceptionTest() {
		board.move("B3", "B4");
	}

	private String appendNewLine(String value) {
		return value + "\n";
	}
}