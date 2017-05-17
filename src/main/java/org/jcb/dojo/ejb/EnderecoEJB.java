package org.jcb.dojo.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jcb.dojo.dao.ImovelDao;
import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;

@Stateless
public class EnderecoEJB {

	@PersistenceContext(unitName="dojoPU")
	EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void criar(Endereco endereco) throws MinhaException {
		em.persist(endereco);
		//throw new MinhaException("erro no cadastro");
	}
}
