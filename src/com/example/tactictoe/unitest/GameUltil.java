package com.example.tactictoe.unitest;

import com.example.tactictoe.Gamer;

public class GameUltil {

	public static final int X_WIN = 1;
	public static final int O_WIN = 2;
	public static final int DRAW = 0;
	public static final String X = "X";
	public static final String O = "O";
	public static int checkResult(Gamer gamer) {
		String currentUser = gamer.getStartUser();
		int[] moves = gamer.getMoves();
		String movesTemp[] = new String[moves.length];
		for (int j = 0; j < moves.length; j++) {
			movesTemp[moves[j]] = currentUser;
			currentUser = currentUser.equals(X) ? O : X;
		}
		if (movesTemp[0].equals(movesTemp[1])
				&& movesTemp[0].equals(movesTemp[2])) {
			if (movesTemp[0].equals(X))
				return X_WIN;
			else
				return O_WIN;
		}
		return DRAW;
	}
}
