package org.jcb.dojo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.ejb.EnderecoEJB;
import org.jcb.dojo.ejb.ImovelEJB;
import org.jcb.dojo.ejb.MinhaException;

@ManagedBean(name = "imovelController")
public class ImovelController implements Serializable {

	@EJB
	private ImovelEJB ejbImovel;
	@EJB
	private EnderecoEJB ejbEndereco;

	private Imovel imovel;
	private Endereco endereco;

	@PostConstruct
	private void init() {
		// FacesContext f = FacesContext.getCurrentInstance();
		endereco = new Endereco();
		imovel = new Imovel();
		imoveis = ejbImovel.recuperarTodos();
	}

	public Imovel getImovel() {
		return imovel;
	}

	public String gravar() throws MinhaException {
		ejbEndereco.criar(endereco);
		imovel.setEndereco(endereco);
		ejbImovel.criar(imovel);
		FacesContext.getCurrentInstance().addMessage("imovel", new FacesMessage("Imovel gravado com sucesso!!"));
		return "lista";
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	private List<Imovel> imoveis;

}
