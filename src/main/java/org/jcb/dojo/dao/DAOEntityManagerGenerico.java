package org.jcb.dojo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

public abstract class DAOEntityManagerGenerico<T, ID extends Serializable> implements IDAOGenerico<T, ID>, Serializable {

	private static final long serialVersionUID = -2015707081680584794L;

	private final Class<T> persistentClass;

	private EntityManager em;

	@SuppressWarnings("unchecked")
	public DAOEntityManagerGenerico() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public DAOEntityManagerGenerico(EntityManager em) {
		this();
		this.em = em;
	}

	/**
	 * Consulta objeto com id informado Se objeto existir, retorna objeto, caso
	 * contrário gera exceção.
	 * 
	 * @param id
	 * @param lock
	 *            executa lock para autalizacao
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T consultarPorID(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = (T) em.find(getPersistentClass(), id, LockModeType.WRITE);
		} else {
			entity = (T) em.find(getPersistentClass(), id);
		}
		return entity;
	}

	/**
	 * Procura objeto com id informado Se objeto existir, retorna objeto, caso
	 * contrário, retorna null.
	 * 
	 * @param id
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public T procuraPorID(ID id) {
		return (T) em.find(getPersistentClass(), id);
	}

	@Override
	public void excluir(T entity) {
		em.remove(entity);
	}

	public void excluirPorID(ID id) {
		T entity = consultarPorID(id, false);
		excluir(entity);
	}

	@Override
	public T persistir(T entity) {
		em.persist(entity);
		return entity;
	}

	public void alterar(T entity) {
		em.merge(entity);
	}

	/**
	 * Retorna true se objeto com id existe e false caso contrario
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean existe(ID id) {
		T entity;
		entity = (T) em.find(getPersistentClass(), id);
		if (entity != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<T> listarTodos() {
		return em.createQuery("select i from "+ getPersistentClass().getName() +" i ", getPersistentClass()).getResultList();
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void flush() {
		em.flush();
	}

	public void clear() {
		em.clear();
	}

}