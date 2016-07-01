package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	private final JdbcTarefaDao dao;

	@Autowired
	public TarefasController(JdbcTarefaDao dao) {
		this.dao = dao;
	}

	// Chamando a pagina formulario, novaTarefa é a url do navegador!!
	@RequestMapping("novaTarefa")
	public String form() {
		// Metodo para retorna a pagina formulario
		return "tarefa/formulario";
	}

	// salvando o formulario no banco, depois de preenchido
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}

		dao.adiciona(tarefa);
		return "tarefa/adicionada"; // retorna para a pagina tarefa adicionada
									// com sucesso

	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}

	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", dao.buscaPorId(id));

		return "tarefa/mostra";

	}

	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {	
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}

	@ResponseBody
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id) {
		dao.finaliza(id);

	}
}
