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

}
