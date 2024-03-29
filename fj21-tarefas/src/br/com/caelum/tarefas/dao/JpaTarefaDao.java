package br.com.caelum.tarefas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.model.Tarefa;

@Repository
public class JpaTarefaDao implements TarefaDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public Tarefa buscaPorId(long id) {
		return manager.find(Tarefa.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarefa> lista() {
		return manager.createQuery("select t from Tarefa t").getResultList();
	}

	@Override
	public void adiciona(Tarefa tarefa) {
		manager.persist(tarefa);
	}

	@Override
	public void altera(Tarefa tarefa) {
		manager.merge(tarefa);

	}

	@Override
	public void remove(Tarefa tarefa) {
		Tarefa tarefaRemover = buscaPorId(tarefa.getId());
		manager.remove(tarefaRemover);
	}

	@Override
	public void finaliza(long id) {
		Tarefa tarefa = buscaPorId(id);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
	}

}
