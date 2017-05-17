package org.jcb.dojo.ejb;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.jcb.dojo.dao.ImovelDao;

@Singleton
public class Monitor {

	@PersistenceContext(unitName="dojoPU")
	EntityManager em;
	
	//@Schedule(minute="*/10", hour="*")
	public void monitoraImoveis(){
		ImovelDao dao = new ImovelDao(em);
		//System.out.println(" QTD imoveis cadastrados: "+dao.listarTodos().size());
	}

}
