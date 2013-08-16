package com.example.tactictoe;

import android.test.ActivityInstrumentationTestCase2;

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

	public void testStartGameThenStopGame() {
		applicationRunner.startGame();
		applicationRunner.showsGameStarted();
		applicationRunner.stopGame();
		applicationRunner.showsGameStopped();
	}

	public void testCanStartGameAndPlayGameThenEndGame() {
		applicationRunner.startGame();
		applicationRunner.startWith("start x");
		applicationRunner.move(0);
		applicationRunner.showsAt(PlayActivity.X, 0);
		applicationRunner.move(1);
		applicationRunner.showsAt(PlayActivity.O, 1);
		applicationRunner.stopGame();
	}
	
	public void testGameOverWhenHasAWinner() {
		applicationRunner.startGame();
		applicationRunner.move(0);
		applicationRunner.move(3);
		applicationRunner.move(2);
		applicationRunner.move(4);
		applicationRunner.move(1);
		applicationRunner.dislaysGameOverStatus();
		applicationRunner.stopGame();
	}
	
}
