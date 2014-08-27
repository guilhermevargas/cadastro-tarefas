package br.com.caelum.tarefas.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.TarefaDao;
import br.com.caelum.tarefas.model.Tarefa;

@Transactional
@Controller
public class TarefasController {
	
	@Autowired
	TarefaDao dao;
	
	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}	
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}
	
	@RequestMapping("adicionarTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		dao.adiciona(tarefa);
		return "redirect:listaTarefas";
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
	public String altera(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/mostra";
		}
		
		dao.altera(tarefa);
		
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(long id, Model model) {
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		
		return "tarefa/finalizada";
	}
}
