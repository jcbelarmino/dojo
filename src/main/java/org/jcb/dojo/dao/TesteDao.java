package org.jcb.dojo.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.jcb.dojo.dominio.Imovel;

public class TesteDao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DAOOldSchoolImovel dao = new DAOOldSchoolImovel();
		Imovel i = new Imovel();
		i.setDescricao("4 quartos ");
		i.setLat(-10.213561236);
		i.setLongi(36.3652476532);
		i.setValor(new BigDecimal(2.212));
		//i.setEndereco("Asa Norte");	
		dao.criar(i);
		System.out.println( dao.recuperarTodos());
	}
}
