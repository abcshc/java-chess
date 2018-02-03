package piece;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess.Board.Color;
import piece.Pawn;

public class PawnTest {

	@Test
	public void createPawnTest() {
		verifyPawn(Color.BLACK);
		verifyPawn(Color.WHITE);
	}
	
	private void verifyPawn(final Color color) {
		Pawn pawn = new Pawn(color);
		assertEquals(color, pawn.getColor());
	}
}