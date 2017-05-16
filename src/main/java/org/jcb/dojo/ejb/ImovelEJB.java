package org.jcb.dojo.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void criar(Imovel imovel) throws MinhaException {
		ImovelDao dao = new ImovelDao(em);
		dao.persistir(imovel);
		throw new MinhaException("erro no cadastro");
		//throw new NullPointerException("erro no cadastro");
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void metodoExterno(Imovel i) throws MinhaException{
		//criar obejeto endereco.
		criar(i);
	}
}
