package org.jcb.dojo.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jcb.dojo.dao.ImovelDao;
import org.jcb.dojo.dominio.Imovel;

@Stateless
public class ImovelEJB {

	@PersistenceContext
	EntityManager em;
	
	public List<Imovel> recuperarTodos() {
		ImovelDao dao = new ImovelDao(em);
		return dao.recuperarTodosFetch();
	}
	
	public void criar(Imovel imovel) {
		em.persist(imovel);
	}
}
