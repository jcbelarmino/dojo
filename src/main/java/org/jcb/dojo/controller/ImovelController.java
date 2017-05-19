package org.jcb.dojo.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.ejb.EnderecoEJB;
import org.jcb.dojo.ejb.ImovelEJB;
import org.jcb.dojo.ejb.MinhaException;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "imovelController")
@ViewScoped
public class ImovelController implements Serializable {

	@EJB
	private ImovelEJB ejbImovel;
	@EJB
	private EnderecoEJB ejbEndereco;

	private List<Imovel> imoveis;

	private LazyDataModel<Imovel> imoveisPaginados;
	private Imovel imovel;
	private Endereco endereco;

	@PostConstruct
	private void init() {
		//FacesContext f = FacesContext.getCurrentInstance();
		endereco = new Endereco();
		imovel = new Imovel();
		imoveisPaginados = new LazyDataModel<Imovel>() {
			@Override
			public List<Imovel> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				setRowCount(ejbImovel.conta().intValue());
				return ejbImovel.recuperarPaginado(first, pageSize);
				
			}
		};

	}

	public Imovel getImovel() {
		return imovel;
	}

	public void gravar() throws MinhaException {
		ejbEndereco.criar(endereco);
		imovel.setEndereco(endereco);
		ejbImovel.criar(imovel);
		adicionarMensagem("Imovel gravado com sucesso!!");
	}

	public void adicionarMensagem(String msg) {
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

	public LazyDataModel<Imovel> getImoveisPaginados() {
		return imoveisPaginados;
	}

	public void setImoveisPaginados(LazyDataModel<Imovel> imoveisPaginados) {
		this.imoveisPaginados = imoveisPaginados;
	}

}
