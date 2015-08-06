package com.seimos.programacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.seimos.programacao.db.Dao;
import com.seimos.programacao.db.Dao.Field;
import com.seimos.programacao.manager.ApoioManager;
import com.seimos.programacao.manager.ApoioManagerImpl;
import com.seimos.programacao.manager.PessoaManager;
import com.seimos.programacao.manager.PessoaManagerImpl;
import com.seimos.programacao.model.Apoio;
import com.seimos.programacao.model.Pessoa;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.FragmentActivity#onSaveInstanceState(android.os.Bundle)
	 */
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.container, PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.section_eu);
			break;
		case 2:
			mTitle = getString(R.string.section_apoio);
			break;
		case 3:
			mTitle = getString(R.string.section_estudo_biblico);
			break;
		case 4:
			mTitle = getString(R.string.section_escola);
			break;
		case 5:
			mTitle = getString(R.string.section_servico);
			break;
		case 6:
			mTitle = getString(R.string.section_discurso);
			break;
		case 7:
			mTitle = getString(R.string.section_estudo_sentinela);
			break;
		case 8:
			mTitle = getString(R.string.section_cadastrar);
			break;
		case 9:
			mTitle = getString(R.string.section_criar_programacao);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();

			String today = SimpleDateFormat.getDateInstance().format(new Date());

			MenuItem lblDateTarget = menu.findItem(R.id.lbl_date_target);
			lblDateTarget.setTitle(today);

			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		private static int section = 1;

		/**
		 * Returns a new instance of this fragment for the given section
		 * number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			section = sectionNumber;
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		private PessoaManager pessoaManager;
		private ApoioManager apoioManager;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			instantiateManagers();
			
			View rootView = null;

			switch (section) {
			case 1:
				rootView = inflater.inflate(R.layout.participacao, container, false);
				populateParticipacao(rootView);
				break;
			case 2:
				rootView = inflater.inflate(R.layout.apoio, container, false);
				populateApoioLayout(rootView);
				break;
			case 3:
				rootView = inflater.inflate(R.layout.estudo_biblico, container, false);
				populateEstudoBiblicoLayout(rootView);
				break;
			case 4:
				rootView = inflater.inflate(R.layout.escola_ministerio_teocratico, container, false);
				populateEscolaMinisterioTeocraticoLayout(rootView);
				break;
			case 5:
				rootView = inflater.inflate(R.layout.reuniao_servico, container, false);
				populateReuniaoServicoLayout(rootView);
				break;
			case 6:
				rootView = inflater.inflate(R.layout.discurso_publico, container, false);
				populateEstudoDiscursoPublicoLayout(rootView);
				break;
			case 7:
				rootView = inflater.inflate(R.layout.estudo_sentinela, container, false);
				populateEstudoSentinelaLayout(rootView);
				break;
			case 8:
				rootView = inflater.inflate(R.layout.lista_pessoas, container, false);
				populateCadastrarPessoa(rootView);
				break;
			case 9:
				rootView = inflater.inflate(R.layout.criar_programacao, container, false);
				populateCriarProgramacaoLayout(rootView);
				break;
			}

			return rootView;
		}

		private void instantiateManagers() {
			pessoaManager = new PessoaManagerImpl(getActivity());
			apoioManager = new ApoioManagerImpl(getActivity());
		}

		private void populateParticipacao(View rootView) {
			ListView listPessoas = (ListView) rootView.findViewById(R.id.list_pessoa);
			
			List<Pessoa> list = pessoaManager.list();
			String[] pessoas = new String[list.size()];
			
			for (int i = 0; i < list.size(); i++) {
				pessoas[i] = list.get(i).getNome();
			}
			
			listPessoas.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, pessoas) );
		}

		private void populateApoioLayout(View rootView) {
			TextView textViewLimpeza = (TextView) rootView.findViewById(R.id.textViewLimpeza);
			TextView textViewIndicador = (TextView) rootView.findViewById(R.id.textViewIndicador);
			TextView textViewSom = (TextView) rootView.findViewById(R.id.textViewSom);
			TextView textViewPalco = (TextView) rootView.findViewById(R.id.textViewPalco);
			TextView textViewVolante1 = (TextView) rootView.findViewById(R.id.textViewVolante1);
			TextView textViewVolante2 = (TextView) rootView.findViewById(R.id.textViewVolante2);

			try {
				Date date = new Date(); //new GregorianCalendar(2015, 9, 1).getTime();
				Apoio apoio = apoioManager.retrieveDesignacaoSemana(date);
				
//				apoioManager.create(new Apoio().setData(date).setIndicador(new Pessoa().setId(1)).setLimpeza(1).setPalco(new Pessoa().setId(2)).setSom(new Pessoa().setId(3)).setVolante1(new Pessoa().setId(4)).setVolante2(new Pessoa().setId(5)));

				textViewLimpeza.setText(apoio.getLimpeza().toString());
				textViewIndicador.setText(pessoaManager.retrieve(apoio.getIndicador().getId()).getNome());
				textViewSom.setText(pessoaManager.retrieve(apoio.getSom().getId()).getNome());
				textViewPalco.setText(pessoaManager.retrieve(apoio.getPalco().getId()).getNome());
				textViewVolante1.setText(pessoaManager.retrieve(apoio.getVolante1().getId()).getNome());
				textViewVolante2.setText(pessoaManager.retrieve(apoio.getVolante2().getId()).getNome());
			} catch (Exception e) {
				int i = 0;
			}
		}

		private void populateEstudoBiblicoLayout(View rootView) {
			TextView textViewEstudoBiblicoPublicacao = (TextView) rootView.findViewById(R.id.textViewEstudoBiblicoPublicacao);
			TextView textViewEstudoBiblicoMateria = (TextView) rootView.findViewById(R.id.textViewEstudoBiblicoMateria);
			TextView textViewEstudoBiblicoDirigente = (TextView) rootView.findViewById(R.id.textViewEstudoBiblicoDirigente);
			TextView textViewEstudoBiblicoLeitor = (TextView) rootView.findViewById(R.id.textViewEstudoBiblicoLeitor);

			Date today = new Date();
			textViewEstudoBiblicoPublicacao.setText(Dao.get(Field.ESTUDO_BIBLICO_PUBLICACAO, today));
			textViewEstudoBiblicoMateria.setText(Dao.get(Field.ESTUDO_BIBLICO_MATERIA, today));
			textViewEstudoBiblicoDirigente.setText(Dao.get(Field.ESTUDO_BIBLICO_DIRIGENTE, today));
			textViewEstudoBiblicoLeitor.setText(Dao.get(Field.ESTUDO_BIBLICO_LEITOR, today));
		}

		private void populateEscolaMinisterioTeocraticoLayout(View rootView) {
			TextView textViewEscolaDestaquesMateria = (TextView) rootView.findViewById(R.id.textViewEscolaDestaquesMateria);
			TextView textViewEscolaDestaquesOrador = (TextView) rootView.findViewById(R.id.textViewEscolaDestaquesOrador);
			TextView textViewEscolaDiscurso1Materia = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso1Materia);
			TextView textViewEscolaDiscurso1Orador = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso1Orador);
			TextView textViewEscolaDiscurso2Tema = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso2Tema);
			TextView textViewEscolaDiscurso2Materia = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso2Materia);
			TextView textViewEscolaDiscurso2Orador = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso2Orador);
			TextView textViewEscolaDiscurso2Ajudante = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso2Ajudante);
			TextView textViewEscolaDiscurso3Tema = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso3Tema);
			TextView textViewEscolaDiscurso3Materia = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso3Materia);
			TextView textViewEscolaDiscurso3Orador = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso3Orador);
			TextView textViewEscolaDiscurso3Ajudante = (TextView) rootView.findViewById(R.id.textViewEscolaDiscurso3Ajudante);

			Date today = new Date();
			textViewEscolaDestaquesMateria.setText(Dao.get(Field.ESCOLA_DESTAQUES_MATERIA, today));
			textViewEscolaDestaquesOrador.setText(Dao.get(Field.ESCOLA_DESTAQUES_ORADOR, today));
			textViewEscolaDiscurso1Materia.setText(Dao.get(Field.ESCOLA_DISCURSO1_MATERIA, today));
			textViewEscolaDiscurso1Orador.setText(Dao.get(Field.ESCOLA_DISCURSO1_ORADOR, today));
			textViewEscolaDiscurso2Tema.setText(Dao.get(Field.ESCOLA_DISCURSO2_TEMA, today));
			textViewEscolaDiscurso2Materia.setText(Dao.get(Field.ESCOLA_DISCURSO2_MATERIA, today));
			textViewEscolaDiscurso2Orador.setText(Dao.get(Field.ESCOLA_DISCURSO2_ORADOR, today));
			textViewEscolaDiscurso2Ajudante.setText(Dao.get(Field.ESCOLA_DISCURSO2_AJUDANTE, today));
			textViewEscolaDiscurso3Tema.setText(Dao.get(Field.ESCOLA_DISCURSO3_TEMA, today));
			textViewEscolaDiscurso3Materia.setText(Dao.get(Field.ESCOLA_DISCURSO3_MATERIA, today));
			textViewEscolaDiscurso3Orador.setText(Dao.get(Field.ESCOLA_DISCURSO3_ORADOR, today));
			textViewEscolaDiscurso3Ajudante.setText(Dao.get(Field.ESCOLA_DISCURSO3_AJUDANTE, today));
		}

		private void populateReuniaoServicoLayout(View rootView) {
			TextView textViewReuniaoServicoParte1Tema = (TextView) rootView.findViewById(R.id.textViewReuniaoServicoParte1Tema);
			TextView textViewReuniaoServicoParte1Orador = (TextView) rootView.findViewById(R.id.textViewReuniaoServicoParte1Orador);
			TextView textViewReuniaoServicoParte2Tema = (TextView) rootView.findViewById(R.id.textViewReuniaoServicoParte2Tema);
			TextView textViewReuniaoServicoParte2Orador = (TextView) rootView.findViewById(R.id.textViewReuniaoServicoParte2Orador);
			TextView textViewReuniaoServicoParte3Tema = (TextView) rootView.findViewById(R.id.textViewReuniaoServicoParte3Tema);
			TextView textViewReuniaoServicoParte3Orador = (TextView) rootView.findViewById(R.id.textViewReuniaoServicoParte3Orador);
			TextView textViewReuniaoServicoOracaoFinal = (TextView) rootView.findViewById(R.id.textViewReuniaoServicoOracaoFinal);

			Date today = new Date();
			textViewReuniaoServicoParte1Tema.setText(Dao.get(Field.REUNIAO_SERVICO_PARTE1_TEMA, today));
			textViewReuniaoServicoParte1Orador.setText(Dao.get(Field.REUNIAO_SERVICO_PARTE1_ORADOR, today));
			textViewReuniaoServicoParte2Tema.setText(Dao.get(Field.REUNIAO_SERVICO_PARTE2_TEMA, today));
			textViewReuniaoServicoParte2Orador.setText(Dao.get(Field.REUNIAO_SERVICO_PARTE2_ORADOR, today));
			textViewReuniaoServicoParte3Tema.setText(Dao.get(Field.REUNIAO_SERVICO_PARTE3_TEMA, today));
			textViewReuniaoServicoParte3Orador.setText(Dao.get(Field.REUNIAO_SERVICO_PARTE3_ORADOR, today));
			textViewReuniaoServicoOracaoFinal.setText(Dao.get(Field.REUNIAO_SERVICO_ORACAO_FINAL, today));

		}

		private void populateEstudoDiscursoPublicoLayout(View rootView) {
			TextView textViewDiscursoPublicoTema = (TextView) rootView.findViewById(R.id.textViewDiscursoPublicoTema);
			TextView textViewDiscursoPublicoOrador = (TextView) rootView.findViewById(R.id.textViewDiscursoPublicoOrador);
			TextView textViewDiscursoPublicoCongregacao = (TextView) rootView.findViewById(R.id.textViewDiscursoPublicoCongregacao);
			TextView textViewDiscursoPublicoPresidente = (TextView) rootView.findViewById(R.id.textViewDiscursoPublicoPresidente);

			Date today = new Date();
			textViewDiscursoPublicoTema.setText(Dao.get(Field.DISCURSO_PUBLICO_TEMA, today));
			textViewDiscursoPublicoOrador.setText(Dao.get(Field.DISCURSO_PUBLICO_ORADOR, today));
			textViewDiscursoPublicoCongregacao.setText(Dao.get(Field.DISCURSO_PUBLICO_CONGREGACAO, today));
			textViewDiscursoPublicoPresidente.setText(Dao.get(Field.DISCURSO_PUBLICO_PRESIDENTE, today));
		}

		private void populateEstudoSentinelaLayout(View rootView) {
			TextView textViewEstudoSentinelaTema = (TextView) rootView.findViewById(R.id.textViewEstudoSentinelaTema);
			TextView textViewEstudoSentinelaMateria = (TextView) rootView.findViewById(R.id.textViewEstudoSentinelaMateria);
			TextView textViewEstudoSentinelaLeitor = (TextView) rootView.findViewById(R.id.textViewEstudoSentinelaLeitor);

			Date today = new Date();
			textViewEstudoSentinelaTema.setText(Dao.get(Field.ESTUDO_SENTINELA_TEMA, today));
			textViewEstudoSentinelaMateria.setText(Dao.get(Field.ESTUDO_SENTINELA_MATERIA, today));
			textViewEstudoSentinelaLeitor.setText(Dao.get(Field.ESTUDO_SENTINELA_LEITOR, today));
		}

		private void populateCadastrarPessoa(View rootView) {
			final EditText editNome = (EditText) rootView.findViewById(R.id.editNome);
			Button btnCadastrarPessoa = (Button) rootView.findViewById(R.id.btnSalvar);
			btnCadastrarPessoa.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if (pessoaManager.create(new Pessoa().setNome(editNome.getText().toString()))) {
						Toast.makeText(getActivity(), "Sucesso!", Toast.LENGTH_SHORT).show();
						editNome.setText("");
					} else {
						Toast.makeText(getActivity(), "Erro!", Toast.LENGTH_SHORT).show();
					}
				}
			});
		}

		private void populateCriarProgramacaoLayout(View rootView) {
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}
}
