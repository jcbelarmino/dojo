package org.jcb.dojo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jcb.dao.DAOEntityManagerGenerico;
import org.jcb.dojo.dominio.Cliente;
import org.jcb.dojo.dominio.Contrato;
import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.dominio.PessoaFisica;

public class CriaBase {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dojoPU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		DAOEntityManagerGenerico<Endereco, Long> enderecoDao = new DAOEntityManagerGenerico<Endereco, Long>(em) 
		{
		};
		ImovelDao imoveldao = new ImovelDao(em); 
		DAOEntityManagerGenerico<Cliente, Long> clienteDao = new DAOEntityManagerGenerico<Cliente, Long>(em) {
		};
		DAOEntityManagerGenerico<Contrato, Long> contratoDao = new DAOEntityManagerGenerico<Contrato, Long>(em) {
		};

		
		
		
		for(int i=0; i< 10; ++i){
			Endereco e = new Endereco("rua", "numero","teste","Taguatinga","Brasilia", "DF");
			e = enderecoDao.persistir(e);
			Imovel im = inicializarEntidadeExemplo();
			//e.setImovel(im);
			im.setEndereco(e);
			
			imoveldao.persistir(im);
			Cliente c = inicializarEntidadeCliente();
			List<Contrato> contratos = new ArrayList();
			for(int j = 0; j < 10; j++) {
				
				Contrato contrato = new Contrato(new Date(), new Date()); 
				contrato.setCliente(c);
				contrato.setImovel(im);
				contratos.add(contrato);
				contratoDao.persistir(contrato);
			}
			c.setContratos(contratos);
			clienteDao.persistir(c);
		}
		
		
		em.getTransaction().commit();
		//List imoveis = imoveldao.recuperarTodosFetch();
//		List<Contrato> contratos = contratoDao.listarTodos();
//		System.out.println(" ###################\nQTD contrato=>"+contratos.size());
//		System.out.println(contratos);
		Cliente cliente = clienteDao.consultarPorID(9L, false);
		System.out.println(imoveldao.consultarPorID(4L, false).getContratos());
		
		System.out.println(" ###################\nQTD clientes=>"+cliente);
		System.out.println(cliente.getContratos());
		
		// Pessoa Física
		//PessoaFisicaDao pfDAO = new PessoaFisicaDao(em);
		
		//PessoaFisica i = new PessoaFisica();
		//i.setCpf("01234567890");
		//i.setEndereco(new Endereco("rua", "numero","teste","Asa Sul","Brasilia", "DF"));
		//i.setNome("Fulano");
		//pfDAO.criar(i);
		
		//System.out.println(i);
		
		
		//ImovelDao imovelDAO = new ImovelDao(em);
		//imovelDAO.remover(3L);
		
		
		//Endereco endImove = imovelDAO.criarEndereco(new Endereco("rua", "numero","teste","Asa Sul","Brasilia", "DF"));
		//i.setEndereco(endImove);
		//imovelDAO.criar(i);
		
		//i.setEndereco("Asa Sul");
		//Imovel i = imovelDAO.recuperarPorId(3L);
		//i.setEndereco("teste1");
		//em.getTransaction().begin();
		//em.flush();
		//i.setEndereco("teste2");
		//em.getTransaction().commit();
		
		//System.out.println(i);
		
		factory.close();
	}

	private static Cliente inicializarEntidadeCliente() {
		Random rand = new Random();
		Cliente c = new PessoaFisica();
		c.setNome("Joao "+rand.nextInt(100));
		return c;
	}

	private static Imovel inicializarEntidadeExemplo() {
		Random rand = new Random();
		
		Imovel i = new Imovel();
		i.setDescricao(rand.nextInt(5) + 1 + " quartos, " + rand.nextInt(3) + 1 + " banheiros ");
		i.setLat(rand.nextDouble() * 100.0);
		i.setLongi(rand.nextDouble() * 100.0);
		i.setValor(new BigDecimal(rand.nextDouble() * 100.0));
		//Endereco endereco =  new Endereco("rua", "numero","teste","Asa Sul","Brasilia", "DF");
		//i.setEndereco(i.get);
		return i;
	}
}
