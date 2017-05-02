package org.jcb.dojo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jcb.dojo.dao.DAOEntityManagerGenerico;
import org.jcb.dojo.dao.ImovelDAO;
import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.dominio.LatLongiBairroDTO;

public class ExecutaDao {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dojoPU");
		EntityManager manager = factory.createEntityManager();

		try {
			ImovelDAO daoImovel = new ImovelDAO(manager);

			DAOEntityManagerGenerico<Endereco, Long> daoEndereco = new DAOEntityManagerGenerico<Endereco, Long>(
					manager) {
			};
			manager.getTransaction().begin();
			Endereco e = new Endereco();
			Imovel imovel = new Imovel();
			e.setBairro("unb");
			imovel.setEndereco(e);
			imovel.setLat(-15.7728457);
			imovel.setLongi(-47.8659963);
			imovel.setPreco(300.00);
			daoEndereco.persistir(e);
			daoImovel.persistir(imovel);
			System.out.println(" flush");
			manager.flush();
			System.out.println(" commit");
			manager.getTransaction().commit();
			List<Imovel> lista = daoImovel.recuperarTodos();
			for (Imovel imovel2 : lista) {
				System.out.println(imovel2.getEndereco());
			}
			List<Imovel> imoveis = daoImovel.recuperarPorMaiorValor(500.00);
			for (Imovel imovel2 : imoveis) {
				System.out.println(imovel2.getEndereco());
			}
			System.out.println(daoImovel.recuperarUnico());
			
			List<Object []> retorno = daoImovel.recuperarLatLongRua();
			for (Object[] objects : retorno) {
				System.out.println("lat "+ objects[0]);
				System.out.println("longi "+ objects[1]);
				System.out.println("bairro "+ objects[2]);
			}
			List<LatLongiBairroDTO> dtos = daoImovel.recuperarLatLongRuaDto();
			
			for (LatLongiBairroDTO latLongiBairroDTO : dtos) {
				System.out.println(latLongiBairroDTO);
			}
			
			manager.getTransaction().begin();
			//daoImovel.updatePreco();
			manager.flush();
			manager.getTransaction().commit();
			EntityManager manager2 = factory.createEntityManager();
			ImovelDAO dao2 = new ImovelDAO(manager2);
			manager2.getTransaction().begin();
			System.out.println("Consulta Nativa");
			for(Imovel i: dao2.recuperarTodosNativo()){
				System.out.println(i);
			}
			
			manager2.getTransaction().commit();
			manager2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			System.out.println("######################\n close manager e factory");
			manager.close();
			factory.close();
		}
	}

}
