package com.example.tactictoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tactictoe.business.HistoryBusiness;
import com.example.tactictoe.data.DBHelper;
import com.example.tactictoe.model.Gamer;
import com.example.tactictoe.model.History;
import com.example.tactictoe.unitest.GameUltil;

public class PlayActivity extends Activity implements OnClickListener {

	public static final int[] buttons = { R.id.btn0, R.id.btn1, R.id.btn2,
			R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8 };
	private static final int MAX_MOVE_TO_CHECK = 5;
	private String charMove;
	private int countPlay = 0;
	private Gamer gamer;
	private int[] moves = new int[9];
	private EditText edtStart;
	private List<History> histories;
	private HistoryBusiness historyBusiness;
	private String sequenceStep = "";
	private int result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playscreen);
		edtStart = (EditText) findViewById(R.id.edtStart);
		setEvent();
		gamer = new Gamer();
		charMove = edtStart.getText().toString();
		gamer.setStartUser(charMove);
		histories = new ArrayList<History>();
		historyBusiness = new HistoryBusiness(this, DBHelper.DATABASE_NAME);
		result = 0;
	}

	private void setEvent() {
		findViewById(R.id.btnEndGame).setOnClickListener(this);
		findViewById(R.id.btnGo).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		int vId = v.getId();
		switch (vId) {
		case R.id.btnEndGame:
			insetHistories();
			finish();
			break;
		case R.id.btnGo:
			if (edtStart.getText().toString().equalsIgnoreCase(GameUltil.X)
					|| edtStart.getText().toString()
							.equalsIgnoreCase(GameUltil.O)) {
				charMove = edtStart.getText().toString().toUpperCase(Locale.US);
				for (int i = 0; i < buttons.length; i++) {
					findViewById(buttons[i]).setOnClickListener(this);
				}
			}
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
			Button btnMove = (Button) findViewById(vId);
			if (btnMove.getText().toString().equals("")) {
				move(charMove, vId);
				sequenceStep = sequenceStep + charMove;
				
			}
			break;
		default:
			break;
		}
	}

	private void insetHistories() {
		for (int i = 0; i < histories.size(); i++) {
			History history = histories.get(i);
			historyBusiness.insert(history);
		}
	}

	private void move(String currentPlayer, int id) {
		Button btnMove = (Button) findViewById(id);
		btnMove.setText(currentPlayer);
		countPlay++;
		charMove = charMove.equals(GameUltil.X) ? GameUltil.O : GameUltil.X;
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
		if (result == GameUltil.X_WIN || result == GameUltil.O_WIN) {
			return result;
		}
		History history = new History();
		history.setFirstSign(charMove);
		String message = "";
		result = GameUltil.DRAW;
		if (countPlay >= MAX_MOVE_TO_CHECK) {
			result = GameUltil.checkResult(gamer);
			if (result == GameUltil.X_WIN) {
				history.setWinSign(GameUltil.X);
				message = "Game over! X win";

			} else if (result == GameUltil.O_WIN) {
				message = "Game over! O win";
				history.setWinSign(GameUltil.O);
			} else {
				if (countPlay == 9) {
					message = "Game over, Draw";
					history.setWinSign("--");
				} else {
					// thoi
				}
			}
			history.setSequenceStep(sequenceStep);
			histories.add(history);
		}

		TextView tvGameOver = (TextView) findViewById(R.id.tvGameOver);
		tvGameOver.setText(message);
		return result;
	}
}
