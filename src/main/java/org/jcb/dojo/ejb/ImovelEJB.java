package org.jcb.dojo.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jcb.dojo.dao.ImovelDao;
import org.jcb.dojo.dominio.Imovel;

@Stateless
public class ImovelEJB {

	@PersistenceContext(unitName="dojoPU")
	EntityManager em;
	
	public List<Imovel> recuperarTodos() {
		ImovelDao dao = new ImovelDao(em);
		return dao.recuperarTodosFetch();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void criar(Imovel imovel) throws MinhaException {
		em.persist(imovel);
		//throw new MinhaException("erro no cadastro");
	}
}
