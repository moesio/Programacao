package com.seimos.programacao.manager;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.content.Context;

import com.seimos.android.dao.GenericDao;
import com.seimos.android.database.Filter;
import com.seimos.android.database.Restriction;
import com.seimos.android.manager.GenericManagerImpl;
import com.seimos.programacao.dao.ApoioDao;
import com.seimos.programacao.dao.ApoioDaoImpl;
import com.seimos.programacao.model.Apoio;

/**
 * @author moesio @ gmail.com
 * @date Jul 29, 2015 11:19:55 PM
 */
public class ApoioManagerImpl extends GenericManagerImpl<Apoio, ApoioDao> implements ApoioManager {

	private ApoioDao dao;

	public ApoioManagerImpl(Context context) {
		super(context);
		this.dao = new ApoioDaoImpl(context);
	}

	@Override
	public GenericDao<Apoio> getDao() {
		return dao;
	}

	@Override
	public Apoio retrieveDesignacaoSemana(Date data) {
		List<Apoio> list = getDao().filter(new Filter("data", transformToMonday(data), Restriction.GE));
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean create(Apoio apoio) {
		if (apoio.getData() != null) {
			apoio.setData(transformToMonday(apoio.getData()));
		}
		return super.create(apoio);
	}

	private Date transformToMonday(Date data) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(data);
		int dow = calendar.get(Calendar.DAY_OF_WEEK);
		calendar.add(Calendar.DAY_OF_MONTH, 2 - dow);
		return calendar.getTime();
	}
}
