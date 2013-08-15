package com.example.tactictoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Context context;
	private Button btnStart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = this;
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btnStart:
			Intent intent = new Intent(context, PlayActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
