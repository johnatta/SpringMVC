package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	
	//Chamando a pagina formulario, novaTarefa é a url do navegador!!
	@RequestMapping("novaTarefa")
	public String form() {
		//Metodo para retorna a pagina formulario
		return "tarefa/formulario";
	}
	
	//salvando o formulario no banco, depois de preenchido
	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada"; // retorna para a pagina tarefa adicionada com sucesso
		
	}

}
