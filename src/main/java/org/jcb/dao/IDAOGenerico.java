package org.jcb.dao;

import java.io.Serializable;
import java.util.List;

public interface IDAOGenerico<T, ID extends Serializable> {
	/**
	 * Consulta Um objeto recebendo a chave primária como parâmetro. A consulta
	 * pode ou não travar (dar lock) na linha da tabela no Banco (SELECT ... FOR
	 * UPDATE ..)
	 * 
	 * @param id
	 *            a chave primária
	 * @param lock
	 *            se a linha será travada para alteração ou não
	 * @return
	 */
	T consultarPorID(ID id, boolean lock);

	/**
	 * Lista todas as instancias da classe
	 * @return
	 */
	List<T> listarTodos();

	/**
	 * Inclui ou altera
	 * @param entity
	 * @return
	 */
	T persistir(T entity);

	/**
	 * remove a classe
	 * @param entity
	 */
	void excluir(T entity);
}