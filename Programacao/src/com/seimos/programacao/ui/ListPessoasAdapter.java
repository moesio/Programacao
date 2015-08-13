package com.seimos.programacao.ui;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.seimos.programacao.manager.PessoaManagerImpl;
import com.seimos.programacao.model.Pessoa;

/**
 * @author moesio @ gmail.com
 * @date Aug 8, 2015 12:50:47 PM
 */
public class ListPessoasAdapter extends ArrayAdapter<Pessoa> implements SectionIndexer {

	private Context context;
	private List<Pessoa> list;
	private PessoaManagerImpl manager;

	public ListPessoasAdapter(Context context) {
		super(context, android.R.layout.simple_list_item_1);
		this.context = context;
		manager = new PessoaManagerImpl(context);
		list = manager.listSorted();
	}

	public void refresh() {
		list = manager.listSorted();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Pessoa getItem(int position) {
		return new PessoaItemLista(list.get(position));
	}

	@Override
	public long getItemId(int position) {
		return list.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Pessoa pessoa = list.get(position);

		TextView textView = (TextView) convertView;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			textView = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
		}

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
		return position / list.size() * getSections().length;
	}

}

class PessoaItemLista extends Pessoa {

	public PessoaItemLista(Pessoa pessoa) {
		setId(pessoa.getId());
		setNome(pessoa.getNome());
	}

	@Override
	public String toString() {
		return getNome();
	}
}