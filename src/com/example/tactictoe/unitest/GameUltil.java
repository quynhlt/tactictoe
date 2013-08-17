package com.example.tactictoe.unitest;

import android.util.Log;

import com.example.tactictoe.model.Gamer;

public class GameUltil {

	public static final int X_WIN = 1;
	public static final int O_WIN = 2;
	public static final int DRAW = 0;
	public static final String X = "X";
	public static final String O = "O";
	public static int checkResult(Gamer gamer) {
		String currentUser = gamer.getStartUser();
		int[] moves = gamer.getMoves();
		String movesTemp[] = new String[9];
		for (int j = 0; j < 9; j++) {
			movesTemp[j] = ""+j;
		}
		for (int j = 0; j < moves.length; j++) {
			movesTemp[moves[j]] = currentUser;
			currentUser = currentUser.equals(X) ? O : X;
		}
		try {
			if (movesTemp[0].equals(movesTemp[1])
					&& movesTemp[0].equals(movesTemp[2])) {
				if (movesTemp[0].equals(X))
					return X_WIN;
				else
					return O_WIN;
			}
			else if (movesTemp[3].equals(movesTemp[4])
					&& movesTemp[5].equals(movesTemp[3])) {
				if (movesTemp[3].equals(X))
					return X_WIN;
				else
					return O_WIN;
			}
			else if (movesTemp[6].equals(movesTemp[7])
					&& movesTemp[8].equals(movesTemp[6])) {
				if (movesTemp[6].equals(X))
					return X_WIN;
				else
					return O_WIN;
			}
			else if (movesTemp[0].equals(movesTemp[3])
					&& movesTemp[0].equals(movesTemp[6])) {
				if (movesTemp[0].equals(X))
					return X_WIN;
				else
					return O_WIN;
			}
			else if (movesTemp[4].equals(movesTemp[1])
					&& movesTemp[1].equals(movesTemp[7])) {
				if (movesTemp[1].equals(X))
					return X_WIN;
				else
					return O_WIN;
			}
			else if (movesTemp[2].equals(movesTemp[5])
					&& movesTemp[2].equals(movesTemp[8])) {
				if (movesTemp[2].equals(X))
					return X_WIN;
				else
					return O_WIN;
			}
			else if (movesTemp[0].equals(movesTemp[4])
					&& movesTemp[0].equals(movesTemp[8])) {
				if (movesTemp[0].equals(X))
					return X_WIN;
				else
					return O_WIN;
			}
			else if (movesTemp[2].equals(movesTemp[4])
					&& movesTemp[2].equals(movesTemp[6])) {
				if (movesTemp[2].equals(X))
					return X_WIN;
				else
				{
					Log.e("currentUser", movesTemp[2]);
					return O_WIN;}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DRAW;
	}
}
