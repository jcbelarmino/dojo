
package org.jcb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jcb.dojo.dao.DAOEntityManagerGenerico;
import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;

public class ExecutaDao {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dojoPU");
		EntityManager manager = factory.createEntityManager();
	
		try {
				DAOEntityManagerGenerico<Imovel, Long> daoImovel = new DAOEntityManagerGenerico<Imovel, Long>(manager) {
			};
			
			DAOEntityManagerGenerico<Endereco, Long> daoEndereco = new DAOEntityManagerGenerico<Endereco, Long>(manager) {
			};
			manager.getTransaction().begin();
			Endereco e = new Endereco();
			e.setBairro("unb");
			Imovel imovel = new Imovel();
			imovel.setEndereco(e);
			imovel.setLat(-15.7728457);
			imovel.setLongi(-47.8659963);
			//imovel.setPreco(3000.00);
			daoEndereco.persistir(e);
			daoImovel.persistir(imovel);	
			System.out.println(" flush");
			manager.flush();
			System.out.println(" commit");
			manager.getTransaction().commit();
			List<Imovel> lista = daoImovel.listarTodos();
			for (Imovel imovel2 : lista) {
				System.out.println(imovel2);			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} finally{
			System.out.println("######################\n close manager e factory");
			manager.close();
			factory.close();
		}
	}
	
}
