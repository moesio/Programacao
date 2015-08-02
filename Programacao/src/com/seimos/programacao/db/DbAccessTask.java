package com.seimos.programacao.db;

import android.content.Context;
import android.os.AsyncTask;

public class DbAccessTask extends AsyncTask<Object, Integer, Long> {

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@Override
	public Long doInBackground(Object... params) {
		Context context = (Context) params[0];
		return null;
	}
}
