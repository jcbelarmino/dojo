package org.jcb.dojo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.jcb.dojo.dominio.Imovel;

public class ImovelDao {
	EntityManager em;

	public ImovelDao(EntityManager em) {
		this.em = em;
	}

	public void criar(Imovel i) {
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	}

	public void remover(Long id) throws Exception {
		em.getTransaction().begin();
		Imovel imovel = recuperarPorId(id);
		if (imovel != null) {
			em.remove(imovel);
		}
		em.getTransaction().commit();
	}

	public Imovel recuperarPorId(Serializable id) throws Exception {
		return em.find(Imovel.class, id);
	}

	
	
	public void atualizar(Imovel entidade) throws Exception {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}

	public List<Imovel> recuperarTodos() {
		String sql = "select i from Imovel i";
		return em.createQuery(sql, Imovel.class).getResultList();
		
		
	}
}
