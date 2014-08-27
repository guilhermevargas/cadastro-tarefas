package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.model.Tarefa;

public class AdicionarTarefa {
	public static void main(String[] args) {
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Ler Game OF Thronos");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("ID da tarefa: " + tarefa.getId());
	}
}
