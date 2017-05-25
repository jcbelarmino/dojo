package org.jcb.dojo.controller;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.jcb.dojo.dominio.Endereco;
import org.jcb.dojo.dominio.Imovel;
import org.jcb.dojo.ejb.EnderecoEJB;
import org.jcb.dojo.ejb.ImovelEJB;
import org.jcb.dojo.ejb.MinhaException;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name = "imovelController")
@RequestScoped
public class ImovelController implements Serializable {

	private MapModel emptyModel;

	private double lat;

	private double lng;

	public MapModel getEmptyModel() {
		return emptyModel;
	}

	@EJB
	private ImovelEJB ejbImovel;

	@EJB
	private EnderecoEJB ejbEndereco;

	private List<Imovel> imoveis;

	private LazyDataModel<Imovel> imoveisPaginados;
	private Imovel imovel;
	private Endereco endereco;


	private Imovel imovelDetalhe;
	
	
	@PostConstruct
	private void init() {
		// FacesContext f = FacesContext.getCurrentInstance();
		emptyModel = new DefaultMapModel();
		endereco = new Endereco();
		imovel = new Imovel();
		List<Imovel> lista = ejbImovel.recuperarTodos(); 
		for (Imovel imovel : lista) {
			Marker marker = new Marker(new LatLng(imovel.getLat(), imovel.getLongi()), imovel.getDescricao());
			emptyModel.addOverlay(marker);
		}
		imoveisPaginados = new LazyDataModel<Imovel>() {
			@Override
			public List<Imovel> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				setRowCount(ejbImovel.conta().intValue());
				List<Imovel> lista = ejbImovel.recuperarPaginado(first, pageSize); 
				return lista;

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
		adicionaMarcador();
		adicionarMensagem("Imovel gravado com sucesso!!");
	}

	public void adicionaMarcador() {
		Marker marker = new Marker(new LatLng(imovel.getLat(), imovel.getLongi()));
		emptyModel.addOverlay(marker);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
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

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Imovel getImovelDetalhe() {
		return imovelDetalhe;
	}

	public void setImovelDetalhe(Imovel imovelDetalhe) {
		this.imovelDetalhe = imovelDetalhe;
	}
	
	public void verDetalheImovel(Imovel i) {
		this.imovelDetalhe = i;
	}


}
