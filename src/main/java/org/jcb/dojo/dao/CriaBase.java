package org.jcb.dojo.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.dominio.PessoaFisica;

public class CriaBase {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dojoPU");
		EntityManager em = factory.createEntityManager();
		
		// Pessoa Física
		PessoaFisicaDao pfDAO = new PessoaFisicaDao(em);
		
		PessoaFisica i = new PessoaFisica();
		i.setCpf("01234567890");
		i.setEndereco("Tagua");
		i.setNome("Fulano");
		pfDAO.criar(i);
		
		System.out.println(i);
		
		/*
		ImovelDao imovelDAO = new ImovelDao(em);
		//imovelDAO.remover(3L);
		
		Imovel i = inicializarEntidadeExemplo();
		imovelDAO.criar(i);
		
		//i.setEndereco("Asa Sul");
		//Imovel i = imovelDAO.recuperarPorId(3L);
		//i.setEndereco("teste1");
		//em.getTransaction().begin();
		//em.flush();
		//i.setEndereco("teste2");
		//em.getTransaction().commit();
		
		//System.out.println(i);
		
		
		System.out.println(imovelDAO.recuperarTodos());
		
		*/
		
		factory.close();
	}

	private static Imovel inicializarEntidadeExemplo() {
		Imovel i = new Imovel();
		i.setDescricao("5 quartos, 2 banheiros ");
		i.setLat(-10.213561236);
		i.setLongi(36.3652476532);
		i.setValor(new BigDecimal(2.212));
		i.setEndereco("Asa Norte");
		return i;
	}
}
