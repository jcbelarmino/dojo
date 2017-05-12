package org.jcb.dojo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jcb.dojo.dominio.Imovel;

public class DAOOldSchoolImovel {

	Connection con;

	public Connection getConnection() throws SQLException,ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/jader"; // Nome da base de
															// dados
		String user = "jader"; // nome do usuário do MySQL
		String password = ""; // senha do MySQL

		con = DriverManager.getConnection(url, user, password);

		return con;
	}
	
	public List<Imovel> recuperarTodos() throws ClassNotFoundException, SQLException{
		Statement s = getConnection().createStatement();
		ResultSet rs = s.executeQuery("Select * from TB_IMOVEL");
		List<Imovel> resultado = new ArrayList<Imovel>();
		while(rs.next()){
			Imovel i = new Imovel();
			i.setDescricao(rs.getString("descricao"));
			//i.setEndereco(rs.getString("endereco"));
			i.setLat(rs.getDouble("imolatitude"));
			i.setLongi(rs.getDouble("imolongitude"));
			i.setId(rs.getLong("id"));
			i.setValor(rs.getBigDecimal("valor"));
			resultado.add(i);
		}
		return resultado;
	}

	public void criar(Imovel i) throws ClassNotFoundException, SQLException{
		Statement s = getConnection().createStatement();
		s.execute("INSERT into tb_imovel values((SELECT nextval('imovel_seq')),'"+i.getDescricao()+"','"
				+i.getEndereco()+ "',"+i.getLat()+","+i.getLongi()+","+i.getValor()+ ")");
		
	} 

}
