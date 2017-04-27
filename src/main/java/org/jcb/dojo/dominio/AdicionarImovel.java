package org.jcb.dojo.dominio;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionarImovel {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_mapeamento_pu");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Imovel imovel = new Imovel();
		imovel.setEndereço("Unb");
		imovel.setLat(-15.7728457);
		imovel.setLongi(-47.8659963);
		imovel.setPreco(3000.00);
		
		manager.persist(imovel);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
}
