/**
 * 
 */
package com.example.tactictoe.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "TicTacToe.sql";
	private static final int VERSION = 1;
	public static final String TABLE_HISTORY = "history";
	public static final String KEY_ID = "keyid";
	public static final String FIRST_SIGN = "firstSign";
	public static final String WIN_SIGN = "winSign";
	public static final String SEQUENCE_STEP = "sequence_step";

	private static final String CREATE_TABLE_HISTORY = "create table "
			+ TABLE_HISTORY + " (" + KEY_ID
			+ " integer primary key autoincrement, " + FIRST_SIGN
			+ " text not null" + "," + WIN_SIGN + " text," + SEQUENCE_STEP
			+ " text);";

	/**
	 * @param context
	 *            Context to use to open or create the database
	 * @param name
	 *            Name of the database file, or null for an in-memory database
	 */
	public DBHelper(Context context, String name) {
		super(context, name, null, VERSION);
	}

	/**
	 * @param sqLiteDatabase
	 *            Called when the database is created for the first time. This
	 *            is where the creation of tables and the initial population of
	 *            the tables should happen.
	 */
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		sqLiteDatabase.execSQL(CREATE_TABLE_HISTORY);
	}

	/**
	 * Called when the database needs to be upgraded. The implementation should
	 * use this method to drop tables, add tables, or do anything else it needs
	 * to upgrade to the new schema version.
	 * 
	 * The SQLite ALTER TABLE documentation can be found here. If you add new
	 * columns you can use ALTER TABLE to insert them into a live table. If you
	 * rename or remove columns you can use ALTER TABLE to rename the old table,
	 * then create the new table and then populate the new table with the
	 * contents of the old table.
	 * 
	 * This method executes within a transaction. If an exception is thrown, all
	 * changes will automatically be rolled back.
	 * 
	 * @param sqLiteDatabase
	 *            The database.
	 * @param oldVersion
	 *            The old database version.
	 * @param newVersion
	 *            The new database version.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion,
			int newVersion) {
		sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
	}

}