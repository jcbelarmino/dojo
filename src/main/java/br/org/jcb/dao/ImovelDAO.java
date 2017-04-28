package br.org.jcb.dao;

import java.io.Serializable;
import java.util.List;

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
	
	public void remover(Long id) throws Exception{
		em.getTransaction().begin();
		Imovel imovel = em.find(Imovel.class, id);
		if (imovel != null) {
			em.remove(imovel);
		} else {
			throw new Exception();
		}
		em.getTransaction().commit();
	}

	public Imovel recuperarPorId(Serializable id) throws Exception {
		Imovel entidade = em.find(Imovel.class, id);
		if (entidade == null) {
			throw new Exception();
		}
		return entidade;
	}
	
	public void atualizar(Imovel entidade) throws Exception {
		recuperarPorId(entidade.getId());
		em.merge(entidade);
	}
	
	public List<Imovel> recuperarTodos() {
		return em.createQuery("select i from Imovel i ", Imovel.class).getResultList();
	}
}
