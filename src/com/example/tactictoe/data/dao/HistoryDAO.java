package com.example.tactictoe.data.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tactictoe.data.DBHelper;
import com.example.tactictoe.model.History;

public class HistoryDAO {
	private SQLiteDatabase db;

	public HistoryDAO(Context context, String databaseName) {
		DBHelper openHelper = new DBHelper(context, databaseName);
		this.db = openHelper.getWritableDatabase();
	}

	public List<History> get() {
		List<History> historyList = new ArrayList<History>();
		String countQuery = "SELECT  * FROM " + DBHelper.TABLE_HISTORY;
		Cursor cursor = db.rawQuery(countQuery, null);
		if (cursor.moveToFirst()) {
			do {
				History his = new History();
				his.setFirstSign(cursor.getString(1));
				his.setWinSign(cursor.getString(2));
				his.setSequenceStep(cursor.getString(3));
				historyList.add(his);

			} while (cursor.moveToNext());
		}
		return historyList;
	}

	public long insert(History history) {

		ContentValues values = new ContentValues();
		values.put(DBHelper.FIRST_SIGN, history.getFirstSign());
		values.put(DBHelper.WIN_SIGN, history.getWinSign());
		values.put(DBHelper.SEQUENCE_STEP, history.getSequenceStep());

		return db.insert(DBHelper.TABLE_HISTORY, null, values);
	}

}
