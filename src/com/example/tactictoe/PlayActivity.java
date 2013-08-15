package com.example.tactictoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PlayActivity extends Activity implements OnClickListener {
	private String charMove = "X";
	public static final int[] buttons = { R.id.btn0, R.id.btn1 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playscreen);
		setEvent();
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
			charMove = "X";
			move(charMove, R.id.btn0);
			break;
		case R.id.btn1:
			charMove = "O";
			move(charMove, R.id.btn1);
			break;
		default:
			break;
		}
	}

	private void move(String key, int id) {
		Button btnMove = (Button) findViewById(id);
		btnMove.setText(key);
	}
}
