package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

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

		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada"; // retorna para a pagina tarefa adicionada
									// com sucesso

	}
	@RequestMapping("listaTarefas")
	public String lista(Model model){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

}
