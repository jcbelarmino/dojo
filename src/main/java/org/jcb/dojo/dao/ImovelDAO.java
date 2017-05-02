package org.jcb.dojo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.dominio.LatLongiBairroDTO;

public class ImovelDAO extends DAOEntityManagerGenerico<Imovel, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3586002266244461485L;
	EntityManager em;

	public ImovelDAO(EntityManager em) {
		super(em);
		this.em = em;
	}

	public void criar(Imovel i) {
		em.getTransaction().begin();
		em.persist(i);
		em.getTransaction().commit();
	}

	public void remover(Long id) throws Exception {
		em.getTransaction().begin();
		Imovel imovel = em.find(Imovel.class, id);
		if (imovel != null) {
			em.remove(imovel);
		} else {
			throw new Exception();
		}
		em.getTransaction().commit();
	}

	public Imovel recuperarPorId(Serializable id) throws Exception {
		Imovel entidade = em.find(Imovel.class, id);
		if (entidade == null) {
			throw new Exception();
		}
		return entidade;
	}

	public void atualizar(Imovel entidade) throws Exception {
		recuperarPorId(entidade.getId());
		em.merge(entidade);
	}

	public List<Imovel> recuperarTodos() {
		System.out.println("Utilizando NamedQuery");
		return em.createNamedQuery("Imovel.recuperarTodos").getResultList();
	}

	public List<Imovel> recuperarPorMaiorValor(double preco) {
		Query q = em.createNamedQuery("Imovel.recuperarPorMaiorValor");
		return q.setParameter("preco", preco).getResultList();
	}

	public Imovel recuperarUnico() {
		return em.createNamedQuery("Imovel.recuperarUnico", getPersistentClass()).getSingleResult();
	}

	public List<Object[]> recuperarLatLongRua() {
		return em.createNamedQuery("Imovel.recuperarRuaLatLongi").getResultList();
	}

	public List<LatLongiBairroDTO> recuperarLatLongRuaDto() {
		return em.createNamedQuery("Imovel.recuperarRuaLatLongiDTO").getResultList();
	}

	public int updatePreco() {
		Query query = em.createQuery("UPDATE Imovel i SET i.preco = i.preco * 1.5");
		return query.executeUpdate();
	}

	public List<Imovel> recuperarTodosNativo(){
		String sql = "SELECT * FROM TBL_IMOVEL order by id";
		Query nativeQuery = em.createNativeQuery(sql, Imovel.class); 
		return nativeQuery.getResultList();
	}
}
