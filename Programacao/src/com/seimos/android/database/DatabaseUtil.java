package com.seimos.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseUtil {

	private static DatabaseHelper databaseHelper;
	private static SQLiteDatabase database;

	public static SQLiteDatabase openForRead(Context context) {
		if (database == null || !database.isOpen()) {
			database = getDatabaseHelper(context).getReadableDatabase();
		}
		return database;
	}

	public static SQLiteDatabase openForWrite(Context context) {
		if (database == null || !database.isOpen()) {
			database = getDatabaseHelper(context).getWritableDatabase();
		}
		return database;
	}

	private static DatabaseHelper getDatabaseHelper(Context context) {
		if (databaseHelper == null) {
			databaseHelper = new DatabaseHelper(context);
		}
		return databaseHelper;
	}

	public static void close() {
		if (databaseHelper != null) {
			databaseHelper.close();
		}
	}
}
