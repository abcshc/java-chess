package piece;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import chess.Board;
import exception.InvalidMoveException;

public class KingMoveRuleTest {
	private Board board;

	@Before
	public void boardSetup() {
		board = new Board();
		board.initialize();			
		board.move("E7", "E5");
		board.move("E8", "E7");
		//1. N
		board.move("E7", "E6");
		assertEquals(
			appendNewLine("rnbqkbnr") + 
			appendNewLine("pppppppp") + 
			appendNewLine("........") + 
			appendNewLine("........") + 
			appendNewLine("....P...") + 
			appendNewLine("....K...") + 
			appendNewLine("PPPP.PPP") + 
			appendNewLine("RNBQ.BNR"), board.showBoard());
	}
	
	@Test
	public void kingMoveTest1() {		
		//2. NE
		board.move("E6", "F5");
		assertEquals(
			appendNewLine("rnbqkbnr") + 
			appendNewLine("pppppppp") + 
			appendNewLine("........") + 
			appendNewLine("........") + 
			appendNewLine("....PK..") + 
			appendNewLine("........") + 
			appendNewLine("PPPP.PPP") + 
			appendNewLine("RNBQ.BNR"), board.showBoard());
		
		//3. SW
		board.move("F5", "E6");
		assertEquals(
			appendNewLine("rnbqkbnr") + 
			appendNewLine("pppppppp") + 
			appendNewLine("........") + 
			appendNewLine("........") + 
			appendNewLine("....P...") + 
			appendNewLine("....K...") + 
			appendNewLine("PPPP.PPP") + 
			appendNewLine("RNBQ.BNR"), board.showBoard());
	}
	
	@Test
	public void kingMoveTest2() {
		//4. NW
		board.move("E6", "D5");
		assertEquals(
			appendNewLine("rnbqkbnr") + 
			appendNewLine("pppppppp") + 
			appendNewLine("........") + 
			appendNewLine("........") + 
			appendNewLine("...KP...") + 
			appendNewLine("........") + 
			appendNewLine("PPPP.PPP") + 
			appendNewLine("RNBQ.BNR"), board.showBoard());
		
		//5. SE
		board.move("D5", "E6");
		assertEquals(
			appendNewLine("rnbqkbnr") + 
			appendNewLine("pppppppp") + 
			appendNewLine("........") + 
			appendNewLine("........") + 
			appendNewLine("....P...") + 
			appendNewLine("....K...") + 
			appendNewLine("PPPP.PPP") + 
			appendNewLine("RNBQ.BNR"), board.showBoard());
	}
	@Test
	public void kingMoveTest3() {
		//6. W
		board.move("E6", "D6");
		assertEquals(
			appendNewLine("rnbqkbnr") + 
			appendNewLine("pppppppp") + 
			appendNewLine("........") + 
			appendNewLine("........") + 
			appendNewLine("....P...") + 
			appendNewLine("...K....") + 
			appendNewLine("PPPP.PPP") + 
			appendNewLine("RNBQ.BNR"), board.showBoard());
		
		//7. E
		board.move("D6", "E6");
		assertEquals(
			appendNewLine("rnbqkbnr") + 
			appendNewLine("pppppppp") + 
			appendNewLine("........") + 
			appendNewLine("........") + 
			appendNewLine("....P...") + 
			appendNewLine("....K...") + 
			appendNewLine("PPPP.PPP") + 
			appendNewLine("RNBQ.BNR"), board.showBoard());
	}
	
	@Test
	public void kingMoveTest4() {
		//8. S
		board.move("E6", "E7");
		assertEquals(
			appendNewLine("rnbqkbnr") + 
			appendNewLine("pppppppp") + 
			appendNewLine("........") + 
			appendNewLine("........") + 
			appendNewLine("....P...") + 
			appendNewLine("........") + 
			appendNewLine("PPPPKPPP") + 
			appendNewLine("RNBQ.BNR"), board.showBoard());
	}
	
	@Test(expected = InvalidMoveException.class)
	public void kingMoveException1() {
		board.move("E6", "A6");
	}
	
	@Test(expected = InvalidMoveException.class)
	public void kingMoveException2() {
		board.move("E6", "E8");
	}
	
	@Test(expected = InvalidMoveException.class)
	public void kingMoveException3() {
		board.move("E6", "C4");
	}
	
	private String appendNewLine(String value) {
		return value + "\n";
	}
}
