package com.example.tactictoe;

import com.example.tactictoe.unitest.GameUltil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends Activity implements OnClickListener {

	public static final int[] buttons = { R.id.btn0, R.id.btn1, R.id.btn2,
			R.id.btn3, R.id.btn4 };
	public static final String X = "X";
	public static final String O = "O";
	private String charMove;
	private int countPlay = 0;
	private Gamer gamer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playscreen);
		setEvent();
		gamer = new Gamer();
		charMove = X;
	}

	private void setEvent() {
		findViewById(R.id.btnEndGame).setOnClickListener(this);
		for (int i = 0; i < buttons.length; i++) {
			findViewById(buttons[i]).setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		int vId = v.getId();

		switch (vId) {
		case R.id.btnEndGame:
			finish();
			break;
		case R.id.btn0:
		case R.id.btn1:
		case R.id.btn2:
		case R.id.btn3:
		case R.id.btn4:
			move(charMove, vId);
			break;
		default:
			break;
		}
	}

	private void move(String currentPlayer, int id) {
		Button btnMove = (Button) findViewById(id);
		btnMove.setText(currentPlayer);
		countPlay++;
		if (countPlay % 2 == 0) {
			charMove = X;
		} else {
			charMove = O;
		}
		//put value choi
		//gamer....//
		checkGameResult();
	}

	private int checkGameResult() {
		if (countPlay == 5) {
			TextView tvGameOver = (TextView) findViewById(R.id.tvGameOver);
			tvGameOver.setText("Game over! X win");
		}
		return GameUltil.checkResult(gamer);
	}
}
