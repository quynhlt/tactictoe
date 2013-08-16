package com.example.tactictoe;

import junit.framework.Assert;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;

public class ApplicationRunner {

	private Solo solo;
	private Button btnStart, btEndGame, btnGo;
	private EditText edtStart;
	
	public ApplicationRunner(Solo solo) {
		this.solo = solo;
	}

	public void startGame() {
		btnStart = (Button) solo.getView(R.id.btnStart);
		solo.clickOnView(btnStart);
	}

	public void showsGameStarted() {
		solo.assertCurrentActivity("PlayActivity Expected", "PlayActivity");
	}

	public void stopGame() {
		btEndGame = (Button) solo.getView(R.id.btnEndGame);
		solo.clickOnView(btEndGame);
	}

	public void showsGameStopped() {
		solo.assertCurrentActivity("MainActivity Expected", "MainActivity");
	}

	public void startWith(String command) {
		edtStart = (EditText) solo.getView(R.id.edtStart);
		solo.enterText(edtStart, command);
		btnGo = (Button) solo.getView(R.id.btnGo);
		solo.clickOnView(btnGo);
	}

	public void move(int position) {
		Button btnMove = (Button) solo.getView(PlayActivity.buttons[position]);
		solo.clickOnView(btnMove);
	}

	public void showsAt(String key, int position) {
		Button btnMove = (Button) solo.getView(PlayActivity.buttons[position]);
		Assert.assertEquals(key, btnMove.getText().toString());
	}

	public void dislaysGameOverStatus() {
		solo.sleep(2000);
		TextView tvGameOver= (TextView) solo.getView(R.id.tvGameOver);
		Assert.assertEquals("Game over! X win", tvGameOver.getText().toString());
	}
}
