package org.jcb.dojo.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Contrato")
public class Contrato {

	@Id
	@GeneratedValue(generator = "contrato_seq")
	@SequenceGenerator(name = "contrato_seq", sequenceName = "CONTRATO_SEQ")
	private Long id;

	@Column(name = "dataInicio", nullable = false)
	private Date dataInicio;

	@Column(name = "dataFim", nullable = false)
	private Date dataFim;

	@ManyToOne
	private Imovel imovel;

	@ManyToOne
	private Cliente cliente;

	public Contrato() {
	}

	public Contrato(Date date, Date date2) {
		this.dataInicio = date;
		this.dataFim = date2;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ","
						+ "]";
	}

}
