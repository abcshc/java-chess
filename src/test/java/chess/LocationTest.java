package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess.Location;
import exception.InvalidLocationException;

public class LocationTest {
	
	@Test
	public void rowLocationTest() {		
		assertEquals(0, new Location("A2").getColumnIndex());
		assertEquals(1, new Location("B2").getColumnIndex());
		assertEquals(2, new Location("C3").getColumnIndex());
		assertEquals(3, new Location("D3").getColumnIndex());
		assertEquals(4, new Location("E4").getColumnIndex());
		assertEquals(5, new Location("F4").getColumnIndex());
		assertEquals(6, new Location("G5").getColumnIndex());
		assertEquals(7, new Location("H5").getColumnIndex());
	}
	
	@Test
	public void columnLocationTest() {
		assertEquals(0, new Location("B1").getRowIndex());
		assertEquals(1, new Location("B2").getRowIndex());
		assertEquals(2, new Location("D3").getRowIndex());
		assertEquals(3, new Location("D4").getRowIndex());
		assertEquals(4, new Location("F5").getRowIndex());
		assertEquals(5, new Location("F6").getRowIndex());
		assertEquals(6, new Location("H7").getRowIndex());
		assertEquals(7, new Location("H8").getRowIndex());
	}
	
	@Test(expected=InvalidLocationException.class)
	public void rowLocationExceptionTest1() {
		new Location("B0");
	}
	
	@Test(expected=InvalidLocationException.class)
	public void rowLocationExceptionTest2() {
		new Location("B9");
	}
	
	@Test(expected=InvalidLocationException.class)
	public void columnLocationExceptionTest1() {
		new Location("Z5");
	}
	
	@Test(expected=InvalidLocationException.class)
	public void columnLocationExceptionTest2() {
		new Location("I5");
	}
}