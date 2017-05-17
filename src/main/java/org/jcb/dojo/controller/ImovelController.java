package org.jcb.dojo.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.ejb.EnderecoEJB;
import org.jcb.dojo.ejb.ImovelEJB;
import org.jcb.dojo.ejb.MinhaException;

@ManagedBean(name = "imovelController")
@RequestScoped
public class ImovelController implements Serializable {

	@Inject
	private ImovelEJB ejbImovel;
	@Inject
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

	public void gravar() throws MinhaException {
		ejbEndereco.criar(endereco);
		imovel.setEndereco(endereco);
		ejbImovel.criar(imovel);
		adicionarMensagem("Imovel gravado com sucesso!!");
		imoveis = ejbImovel.recuperarTodos();
		
	}
	
	public void adicionarMensagem(String msg){
		FacesContext.getCurrentInstance().addMessage(msg, new FacesMessage(msg));
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
