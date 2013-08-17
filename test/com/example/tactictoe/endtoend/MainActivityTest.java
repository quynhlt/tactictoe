package com.example.tactictoe.endtoend;

import android.test.ActivityInstrumentationTestCase2;

import com.example.tactictoe.MainActivity;
import com.example.tactictoe.unitest.GameUltil;
import com.jayway.android.robotium.solo.Solo;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private ApplicationRunner applicationRunner;

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Solo solo = new Solo(getInstrumentation(), getActivity());
		applicationRunner = new ApplicationRunner(solo);
	}
//
//	public void testStartGameThenStopGame() {
//		applicationRunner.startGame();
//		applicationRunner.showsGameStarted();
//		applicationRunner.stopGame();
//		applicationRunner.showsGameStopped();
//	}
//
//	public void testCanStartGameAndPlayGameThenEndGame() {
//		applicationRunner.startGame();
//		applicationRunner.startWith("x");
//		applicationRunner.move(0);
//		applicationRunner.showsAt(GameUltil.X, 0);
//		applicationRunner.move(1);
//		applicationRunner.showsAt(GameUltil.O, 1);
//		applicationRunner.stopGame();
//	}
//
//	public void testGameOverWhenHasAWinner() {
//		applicationRunner.startGame();
//		applicationRunner.startWith("x");
//		applicationRunner.move(0);
//		applicationRunner.move(3);
//		applicationRunner.move(2);
//		applicationRunner.move(4);
//		applicationRunner.move(1);
//		applicationRunner.dislaysGameOverStatus();
//		applicationRunner.stopGame();
//	}
//
//	public void testPlayGameAndNobodyWin() {
//		applicationRunner.startGame();
//		applicationRunner.startWith("x");
//		applicationRunner.move(0);
//		applicationRunner.move(1);
//		applicationRunner.move(2);
//		applicationRunner.move(4);
//		applicationRunner.move(3);
//		applicationRunner.move(5);
//		applicationRunner.move(7);
//		applicationRunner.move(6);
//		applicationRunner.move(8);
//		applicationRunner.dislaysGameOverDrawStatus();
//		applicationRunner.stopGame();
//	}

	public void testCanStartGameAndViewGameHistories() {
		applicationRunner.displayHistories();
		applicationRunner.screenHistoriesDisplayed();
		applicationRunner.isHistoriesDisplayed();
	}

}
