package org.jcb.dojo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.ejb.ImovelEJB;
import org.jcb.dojo.ejb.MinhaException;

@ManagedBean(name="imovelController")
public class ImovelController implements Serializable {
	
	@EJB
	private ImovelEJB ejb;
	
	private Imovel imovel;
	
	@PostConstruct
	private void init(){
		imovel = new Imovel();
		imoveis = ejb.recuperarTodos();
	}
	public Imovel getImovel() {
		return imovel;
	}

	
	public void gravar() throws MinhaException{
		ejb.criar(imovel);
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	private List<Imovel> imoveis;
	

}
