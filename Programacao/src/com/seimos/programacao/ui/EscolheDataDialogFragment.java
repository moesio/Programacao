package com.seimos.programacao.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.seimos.programacao.MainActivity;
import com.seimos.programacao.R;

/**
 * @author moesio @ gmail.com
 * @date Aug 12, 2015 9:19:24 PM
 */
public class EscolheDataDialogFragment extends DialogFragment {
	
	private MenuItem item;

	public EscolheDataDialogFragment(MenuItem item) {
		this.item = item;
	}
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.escolhe_data, container);
		final DatePicker datepicker = (DatePicker) view.findViewById(R.id.datePicker);
		Button buttonCancel = (Button) view.findViewById(R.id.buttonCancel);
		Button buttonOk = (Button) view.findViewById(R.id.buttonPickDate);
		
		buttonCancel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				(EscolheDataDialogFragment.this).dismiss();
			}
		});
		
		buttonOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Date date = new Date(datepicker.getYear(), datepicker.getMonth(), datepicker.getDayOfMonth());
				item.setTitle(SimpleDateFormat.getInstance().format(date));
				((MainActivity) getActivity()).setBaseDate(date);
				
				(EscolheDataDialogFragment.this).dismiss();
			}
		});
		return view;
	}
}
