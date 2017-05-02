package org.jcb.dojo.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jcb.dojo.dominio.Imovel;

@Stateless
public class ImovelEJB {

	@PersistenceContext
	EntityManager em;
	
	public List<Imovel> recuperarTodos() {
		System.out.println("Utilizando NamedQuery");
		return em.createNamedQuery("Imovel.recuperarTodos").getResultList();
	}
}
