package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.PickNullPieceException;

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
				appendNewLine(".n....n.") + 
				appendNewLine("pppppppp") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine(".N....N."), board.showBoard());
	}

	@Test
	public void boardMoveTest1() {
		board.move("B2", "B3");
		assertEquals(
				appendNewLine(".n....n.") + 
				appendNewLine("p.pppppp") + 
				appendNewLine(".p......") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine(".N....N."), board.showBoard());
		
		board.move("B3", "B4");
		assertEquals(
				appendNewLine(".n....n.") + 
				appendNewLine("p.pppppp") + 
				appendNewLine("........") + 
				appendNewLine(".p......") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine(".N....N."), board.showBoard());
	}

	@Test(expected = PickNullPieceException.class)
	public void boardMoveExceptionTest() {
		board.move("B3", "B4");
	}

	private String appendNewLine(String value) {
		return value + "\n";
	}
}