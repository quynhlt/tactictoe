/**
 * 
 */
package com.example.tactictoe.unitest;

import junit.framework.TestCase;

import com.example.tactictoe.Gamer;

/**
 * @author quynhlt
 * 
 */
public class GameUltilTest extends TestCase {

	private static final int X_WIN = 1;
	private static final int Y_WIN = 2;

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testEndGameWithXIsWinner() {
		Gamer gamer = new Gamer();
		String[] values = { "X", "O", "X", "O", "X" };
		int[] moves = { 0, 3, 1, 4, 2 };
		gamer.setValues(values);
		gamer.setMoves(moves);
		int result = GameUltil.checkResult(gamer);
		assertTrue(result == X_WIN);
	}

	public void testEndGameWithYIsWinner() {
		Gamer gamer = new Gamer();
		String[] values = { "O", "X", "O", "X", "O" };
		int[] moves = { 0, 3, 1, 4, 2 };
		gamer.setValues(values);
		gamer.setMoves(moves);
		int result = GameUltil.checkResult(gamer);
		assertTrue(result == Y_WIN);
	}
}
