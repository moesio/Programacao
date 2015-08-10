package com.seimos.programacao.ui;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.seimos.programacao.model.Pessoa;

/**
 * @author moesio @ gmail.com
 * @date Aug 8, 2015 12:50:47 PM
 */
public class ListPessoasAdapter extends BaseAdapter implements SectionIndexer {

	private FragmentActivity context;
	private List<Pessoa> list;

	public ListPessoasAdapter(FragmentActivity context, List<Pessoa> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return list.get(position).getId();
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Pessoa pessoa = list.get(position);

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		TextView textView = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent);
		textView.setTag(pessoa);
		textView.setText(pessoa.getNome());

		return textView;
	}

	@Override
	public Object[] getSections() {
		return new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	}

	@Override
	public int getPositionForSection(int sectionIndex) {
		return sectionIndex / getSections().length * list.size();
	}

	@Override
	public int getSectionForPosition(int position) {
		return position / list.size() * getSections().length ;
	}
}
