package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.InvalidMoveException;

public class MovementTest {
	private Location a1 = new Location("A1");
	private Location a2 = new Location("A2");
	private Location a3 = new Location("A3");
	private Location b1 = new Location("B1");
	private Location b2 = new Location("B2");
	private Location b3 = new Location("B3");
	private Location c1 = new Location("C1");
	private Location c2 = new Location("C2");
	private Location c3 = new Location("C3");
	private Location d1 = new Location("D1");

	@Test
	public void moveDistanceTest() {
		assertEquals(1, new Movement(b2, b3).getMoveDistance());
		assertEquals(4, new Movement(b2, new Location("B6")).getMoveDistance());
		assertEquals(1, new Movement(b2, c2).getMoveDistance());
		assertEquals(2, new Movement(a1, c3).getMoveDistance());
		assertEquals(0, new Movement(b2, new Location("C4")).getMoveDistance());
	}

	@Test
	public void moveCheckerTest1() {
		// 4방향
		Movement s = new Movement(b2, b3);
		Movement e = new Movement(b2, c2);
		Movement n = new Movement(b2, b1);
		Movement w = new Movement(b2, a2);
		assertEquals("S", s.getMoveDirection().getDirection());
		assertEquals("E", e.getMoveDirection().getDirection());
		assertEquals("N", n.getMoveDirection().getDirection());
		assertEquals("W", w.getMoveDirection().getDirection());
		assertEquals(1, s.getMoveDistance());
		assertEquals(1, e.getMoveDistance());
		assertEquals(1, n.getMoveDistance());
		assertEquals(1, w.getMoveDistance());
	}

	@Test
	public void moveCheckerTest2() {
		// 4방향 2이상
		Movement s2 = new Movement(b2, new Location("B4"));
		Movement e2 = new Movement(b2, new Location("D2"));
		Movement n2 = new Movement(b3, b1);
		Movement w2 = new Movement(c2, a2);
		assertEquals("S", s2.getMoveDirection().getDirection());
		assertEquals("E", e2.getMoveDirection().getDirection());
		assertEquals("N", n2.getMoveDirection().getDirection());
		assertEquals("W", w2.getMoveDirection().getDirection());
		assertEquals(2, s2.getMoveDistance());
		assertEquals(2, e2.getMoveDistance());
		assertEquals(2, n2.getMoveDistance());
		assertEquals(2, w2.getMoveDistance());
	}

	@Test
	public void moveCheckerTest3() {
		// 8방향
		Movement ne = new Movement(b2, c1);
		Movement sw = new Movement(b2, a3);
		Movement nw = new Movement(b2, a1);
		Movement se = new Movement(b2, c3);
		assertEquals("NE", ne.getMoveDirection().getDirection());
		assertEquals("SW", sw.getMoveDirection().getDirection());
		assertEquals("NW", nw.getMoveDirection().getDirection());
		assertEquals("SE", se.getMoveDirection().getDirection());
		assertEquals(1, ne.getMoveDistance());
		assertEquals(1, sw.getMoveDistance());
		assertEquals(1, nw.getMoveDistance());
		assertEquals(1, se.getMoveDistance());
	}

	@Test
	public void moveCheckerTest4() {
		// 8방향 2이상
		Movement ne2 = new Movement(b3, d1);
		Movement sw2 = new Movement(c1, a3);
		Movement nw2 = new Movement(c3, a1);
		Movement se2 = new Movement(a1, c3);
		assertEquals("NE", ne2.getMoveDirection().getDirection());
		assertEquals("SW", sw2.getMoveDirection().getDirection());
		assertEquals("NW", nw2.getMoveDirection().getDirection());
		assertEquals("SE", se2.getMoveDirection().getDirection());
		assertEquals(2, ne2.getMoveDistance());
		assertEquals(2, sw2.getMoveDistance());
		assertEquals(2, nw2.getMoveDistance());
		assertEquals(2, se2.getMoveDistance());
	}

	@Test
	public void moveCheckerTest5() {
		// Knight(8개)
		Movement nne = new Movement(b3, c1);
		Movement nnw = new Movement(b3, a1);
		Movement sse = new Movement(b3, new Location("C5"));
		Movement ssw = new Movement(b3, new Location("A5"));
		Movement nee = new Movement(b2, d1);
		Movement nww = new Movement(c2, a1);
		Movement see = new Movement(b3, new Location("D4"));
		Movement sww = new Movement(c3, new Location("A4"));
		assertEquals("NNE", nne.getMoveDirection().getDirection());
		assertEquals("NNW", nnw.getMoveDirection().getDirection());
		assertEquals("SSE", sse.getMoveDirection().getDirection());
		assertEquals("SSW", ssw.getMoveDirection().getDirection());
		assertEquals("NEE", nee.getMoveDirection().getDirection());
		assertEquals("NWW", nww.getMoveDirection().getDirection());
		assertEquals("SEE", see.getMoveDirection().getDirection());
		assertEquals("SWW", sww.getMoveDirection().getDirection());
		assertEquals(0, nne.getMoveDistance());
		assertEquals(0, nnw.getMoveDistance());
		assertEquals(0, sse.getMoveDistance());
		assertEquals(0, ssw.getMoveDistance());
		assertEquals(0, nee.getMoveDistance());
		assertEquals(0, nww.getMoveDistance());
		assertEquals(0, see.getMoveDistance());
		assertEquals(0, sww.getMoveDistance());
	}

	@Test(expected = InvalidMoveException.class)
	public void moveCheckerException() {
		new Movement(b2, b2);
	}
}