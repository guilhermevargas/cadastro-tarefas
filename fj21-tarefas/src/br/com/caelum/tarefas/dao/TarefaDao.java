package br.com.caelum.tarefas.dao;

import java.util.List;

import br.com.caelum.tarefas.model.Tarefa;

public interface TarefaDao {
	Tarefa buscaPorId(long id);
	List<Tarefa> lista();
	void adiciona(Tarefa tarefa);
	void altera(Tarefa tarefa);
	void remove(Tarefa tarefa);
	void finaliza(long id);
}
