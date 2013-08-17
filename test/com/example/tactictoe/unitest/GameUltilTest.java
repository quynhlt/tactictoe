/**
 * 
 */
package com.example.tactictoe.unitest;

import android.test.AndroidTestCase;

import com.example.tactictoe.model.Gamer;

/**
 * @author quynhlt
 * 
 */
public class GameUltilTest extends AndroidTestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testEndGameWithXIsWinner() {
		Gamer gamer = new Gamer();
		int[] moves = { 0, 3, 1, 4, 2 };
		gamer.setMoves(moves);
		gamer.setStartUser(GameUltil.X);
		int result = GameUltil.checkResult(gamer);
		assertTrue(result == GameUltil.X_WIN);
	}

	public void testEndGameWithOIsWinner() {
		Gamer gamer = new Gamer();
		int[] moves = { 0, 3, 1, 4, 2 };
		gamer.setStartUser(GameUltil.O);
		gamer.setMoves(moves);
		int result = GameUltil.checkResult(gamer);
		assertTrue(result == GameUltil.O_WIN);
	}

	public void testEndGameIsDraw() {
		Gamer gamer = new Gamer();
		int[] moves = { 0, 1, 3, 4, 2 };
		gamer.setStartUser(GameUltil.O);
		gamer.setMoves(moves);
		int result = GameUltil.checkResult(gamer);
		assertTrue(result == GameUltil.DRAW);
	}
}
