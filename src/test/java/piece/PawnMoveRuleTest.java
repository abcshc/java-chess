package piece;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import chess.Board;

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
		appendNewLine("rnbqkbnr") + 
		appendNewLine("p.pppppp") + 
		appendNewLine("........") + 
		appendNewLine(".p......") + 
		appendNewLine("........") + 
		appendNewLine("........") + 
		appendNewLine("PPPPPPPP") + 
		appendNewLine("RNBQKBNR"), board.showBoard());
	}
	
	private String appendNewLine(String value) {
		return value + "\n";
	}
}