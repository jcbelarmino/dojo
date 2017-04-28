package br.org.jcb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jcb.dojo.dominio.Imovel;

public class TestDao {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dojoPU");
		EntityManager manager = factory.createEntityManager();
		ImovelDAO dao = new ImovelDAO(manager);
		Imovel imovel = new Imovel();
		imovel.setEndereço("Unb2");
		imovel.setLat(-15.7728457);
		imovel.setLongi(-47.8659963);
		imovel.setPreco(3000.00);
		dao.criar(imovel);	
		
		List<Imovel> lista = dao.recuperarTodos();
		for (Imovel imovel2 : lista) {
			System.out.println(imovel2);			
		}
	}
	
}
