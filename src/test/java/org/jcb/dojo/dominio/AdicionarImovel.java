
package org.jcb.dojo.dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionarImovel {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dojoPU");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Imovel imovel = new Imovel();
		Endereco e = new Endereco();
		e.setRua("Unb");
		e.setBairro("Aguas Claras");
		e.setComplemento("apt 101");
		imovel.setEndereco(e);
		imovel.setLat(-15.7728457);
		imovel.setLongi(-47.8659963);
		//imovel.setPreco(3000.00);
		manager.persist(e);
		manager.persist(imovel);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
}