package com.example.tactictoe;

import java.util.ArrayList;
import java.util.List;

import com.example.tactictoe.adapters.HistoryAdapter;
import com.example.tactictoe.business.HistoryBusiness;
import com.example.tactictoe.data.DBHelper;
import com.example.tactictoe.model.History;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class HistoryActivity extends Activity {

	private List<History> listHistories;

	private ListView lvHistories;
	private HistoryBusiness historyBO;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		lvHistories = (ListView) findViewById(R.id.listHistories);
		historyBO = new HistoryBusiness(this, DBHelper.DATABASE_NAME);
		fillHistories();
	}

	private void fillHistories() {
		listHistories = new ArrayList<History>();
		listHistories = historyBO.getListHistories();
		HistoryAdapter historyAdapter = new HistoryAdapter(this, listHistories);
		lvHistories.setAdapter(historyAdapter);
	}
}
