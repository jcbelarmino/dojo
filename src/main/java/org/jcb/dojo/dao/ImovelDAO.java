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
	
	public ImovelDAO(EntityManager em) {
		super(em);
	}

	public List<Imovel> recuperarPorMaiorValor(double preco) {
		Query q = getEm().createNamedQuery("Imovel.recuperarPorMaiorValor");
		return q.setParameter("preco", preco).getResultList();
	}

	public Imovel recuperarUnico() {
		return getEm().createNamedQuery("Imovel.recuperarUnico", getPersistentClass()).getSingleResult();
	}

	public List<Object[]> recuperarLatLongRua() {
		return getEm().createNamedQuery("Imovel.recuperarRuaLatLongi").getResultList();
	}

	public List<LatLongiBairroDTO> recuperarLatLongRuaDto() {
		return getEm().createNamedQuery("Imovel.recuperarRuaLatLongiDTO").getResultList();
	}

	public int updatePreco() {
		Query query = getEm().createQuery("UPDATE Imovel i SET i.preco = i.preco * 1.5");
		return query.executeUpdate();
	}

	public List<Imovel> recuperarTodosNativo(){
		String sql = "SELECT * FROM TBL_IMOVEL order by id";
		Query nativeQuery = getEm().createNativeQuery(sql, Imovel.class); 
		return nativeQuery.getResultList();
	}
}
