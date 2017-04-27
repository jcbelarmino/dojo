package br.org.jcb.dao;

import javax.persistence.EntityManager;

import org.jcb.dojo.dominio.Imovel;

public class ImovelDAO {
	
	EntityManager  em;

	public ImovelDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void criar(Imovel i){
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	}

}
