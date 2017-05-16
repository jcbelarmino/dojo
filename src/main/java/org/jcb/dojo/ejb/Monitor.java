package org.jcb.dojo.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.jcb.dojo.dao.ImovelDao;

@Singleton
public class Monitor {

	@PersistenceContext
	EntityManager em;
	
	private static int qtdImoveis;
	
	@Schedule(minute="10,20,30,40,50,00", hour="*")
	public void monitoraImoveis(){
		ImovelDao dao = new ImovelDao(em);
		qtdImoveis = dao.listarTodos().size();
		System.out.println(" QTD imoveis cadastrados: "+qtdImoveis);
	}

	public static int getQtdImoveis() {
		return qtdImoveis;
	}


	
}
