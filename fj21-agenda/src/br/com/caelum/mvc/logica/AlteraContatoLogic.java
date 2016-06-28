package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		Long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");

		String endereco = req.getParameter("endereco");
		String dataEmTexto = req.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto);

		Calendar dataNascimento = Calendar.getInstance();

		dataNascimento.setTime(date);

		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		ContatoDao dao = new ContatoDao();
		dao.atualiza(contato);

		return "mvc?logica=listaContatosLogic";

	}
}
