package com.example.tactictoe;

import java.util.Locale;

import com.example.tactictoe.unitest.GameUltil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlayActivity extends Activity implements OnClickListener {

	public static final int[] buttons = { R.id.btn0, R.id.btn1, R.id.btn2,
			R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8 };
	private static final int MAX_MOVE_TO_CHECK = 5;
	private String charMove;
	private int countPlay = 0;
	private Gamer gamer;
	private int[] moves = new int[9];
	private EditText edtStart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playscreen);
		edtStart = (EditText) findViewById(R.id.edtStart);
		setEvent();
		gamer = new Gamer();
		// edtStart.setText(GameUltil.X);
		charMove = GameUltil.X;
		gamer.setStartUser(charMove);
	}

	private void setEvent() {
		findViewById(R.id.btnEndGame).setOnClickListener(this);
		findViewById(R.id.btnGo).setOnClickListener(this);
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
		case R.id.btnGo:
			charMove = edtStart.getText().toString().toUpperCase(Locale.US);
			break;
		case R.id.btn0:
		case R.id.btn1:
		case R.id.btn2:
		case R.id.btn3:
		case R.id.btn4:
		case R.id.btn5:
		case R.id.btn6:
		case R.id.btn7:
		case R.id.btn8:
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
			charMove = GameUltil.X;
		} else {
			charMove = GameUltil.O;
		}
		// put value
		int move = getPositionById(id);
		moves[countPlay - 1] = move;
		gamer.setMoves(moves);
		checkGameResult();
	}

	private int getPositionById(int id) {
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] == id) {
				return i;
			}
		}
		return 0;
	}

	private int checkGameResult() {
		String message = "";
		int result = GameUltil.DRAW;
		if (countPlay >= MAX_MOVE_TO_CHECK) {
			result = GameUltil.checkResult(gamer);
			if (result == GameUltil.X_WIN) {
				message = "Game over! X win";
			} else if (result == GameUltil.O_WIN) {
				message = "Game over! O win";
			} else {
				message = "Game over, Draw";
			}
		}
		TextView tvGameOver = (TextView) findViewById(R.id.tvGameOver);
		tvGameOver.setText(message);
		return result;
	}
}
