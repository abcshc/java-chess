package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PawnMoveRuleTest {
	private Board board;
	
	@Before
	public void boardSetup() {
		board = new Board();
		board.initialize();
	}
	
	@Test
	public void pawnMoveTest() {
		board.move("B2", "B4");
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
	
//	@Test(expected = InvalidMoveException.class)
//	public void pawnMoveExceptionTest() {
//		board.move("B2", "C3");
//	}
	
	private String appendNewLine(String value) {
		return value + "\n";
	}
}
