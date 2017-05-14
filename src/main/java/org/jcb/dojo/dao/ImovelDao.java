package org.jcb.dojo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.jcb.dojo.dominio.Imovel;


public class ImovelDao extends DAOEntityManagerGenerico<Imovel, Long> {

	public ImovelDao(EntityManager em) {
		// TODO Auto-generated constructor stub
		super(em);
	}
	
	public List<Imovel> recuperarTodosFetch() {
		return getEm().createNamedQuery("Imovel.recuperarTodosFetch").getResultList();
	}
}
