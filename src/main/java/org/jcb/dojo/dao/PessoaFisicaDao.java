package org.jcb.dojo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.dominio.PessoaFisica;

public class PessoaFisicaDao {
	EntityManager em;

	public PessoaFisicaDao(EntityManager em) {
		this.em = em;
	}

	public void criar(PessoaFisica i) {
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	}

	public void remover(Long id) throws Exception {
		em.getTransaction().begin();
		PessoaFisica PF = recuperarPorId(id);
		
		if (PF != null) {
			em.remove(PF);
		}
		em.getTransaction().commit();
	}

	public PessoaFisica recuperarPorId(Serializable id) throws Exception {
		return em.find(PessoaFisica.class, id);
	}

	
	
	public void atualizar(PessoaFisica entidade) throws Exception {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}

	public List<PessoaFisica> recuperarTodos() {
		String sql = "select i from PessoaFisica i";
		return em.createQuery(sql, PessoaFisica.class).getResultList();
		
		
	}
}
