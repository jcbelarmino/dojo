package org.jcb.dojo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.jcb.dao.DAOEntityManagerGenerico;
import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;

public class ImovelDao extends DAOEntityManagerGenerico<Imovel, Long> {

	public void criar(Imovel i) {
		getEm().persist(i);
	}
	public void remover(Long id) throws Exception {
		Imovel imovel = recuperarPorId(id);
		if (imovel != null) {
			getEm().remove(imovel);
		}
	}

	public Imovel recuperarPorId(Serializable id) throws Exception {
		return getEm().find(Imovel.class, id);
	}
	public void atualizar(Imovel entidade) throws Exception {
		getEm().merge(entidade);
	}

	public List<Imovel> recuperarTodos() {
		String sql = "select i from Imovel i";
		return getEm().createQuery(sql, Imovel.class).getResultList();		
	}
}
