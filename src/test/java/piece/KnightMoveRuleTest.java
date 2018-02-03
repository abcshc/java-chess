package piece;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import chess.Board;
import exception.InvalidMoveException;

public class KnightMoveRuleTest {
	private Board board;
	
	@Before
	public void boardSetup() {
		board = new Board();
		board.initialize();
	}
	
	@Test
	public void knightMoveTest() {
		assertEquals(
				appendNewLine("rnbqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
//		moveChecker.addRule("SSE");
		board.move("B1", "C3");		
		assertEquals(
				appendNewLine("r.bqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("..n.....") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
//		moveChecker.addRule("SSW");	
		board.move("C3", "B5");		
		assertEquals(
				appendNewLine("r.bqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine(".n......") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
//		moveChecker.addRule("NEE");
		board.move("B5", "D4");		
		assertEquals(
				appendNewLine("r.bqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("........") + 
				appendNewLine("...n....") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
//		moveChecker.addRule("SEE");
		board.move("D4", "F5");		
		assertEquals(
				appendNewLine("r.bqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine(".....n..") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
//		moveChecker.addRule("SWW");
		board.move("F5", "D6");		
		assertEquals(
				appendNewLine("r.bqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("...n....") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
//		moveChecker.addRule("NWW");
		board.move("D6", "B5");		
		assertEquals(
				appendNewLine("r.bqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine(".n......") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
//		moveChecker.addRule("NNE");
		board.move("B5", "C3");		
		assertEquals(
				appendNewLine("r.bqkbnr") + 
				appendNewLine("pppppppp") + 
				appendNewLine("..n.....") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("........") + 
				appendNewLine("PPPPPPPP") + 
				appendNewLine("RNBQKBNR"), board.showBoard());
		
//		moveChecker.addRule("NNW");
		board.move("C3", "B1");		
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
	
	@Test(expected=InvalidMoveException.class)
	public void knightMoveExceptionTest1() {		
		board.move("B1", "B3");
	}
	
	@Test(expected=InvalidMoveException.class)
	public void knightMoveExceptionTest2() {		
		board.move("B1", "D2");
	}
	
	private String appendNewLine(String value) {
		return value + "\n";
	}
}
