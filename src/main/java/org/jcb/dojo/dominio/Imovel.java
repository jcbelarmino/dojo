package org.jcb.dojo.dominio;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
//	@NamedQuery(name="Imovel.recuperarTodos", query= "select i from Imovel i"),
//	@NamedQuery(name="Imovel.recuperarPorMaiorValor", query = "select i from Imovel i where i.preco < :preco"),
//	@NamedQuery(name="Imovel.recuperarUnico", query = "select i from Imovel i where i.id = 4"),
//	@NamedQuery(name="Imovel.recuperarRuaLatLongi", query= "select i.lat, i.longi, i.endereco.bairro from Imovel i"),
//	@NamedQuery(name="Imovel.recuperarRuaLatLongiDTO", query= "select new org.jcb.dojo.dominio.LatLongiBairroDTO(i.lat, i.longi, i.endereco.bairro) from Imovel i"),
//	@NamedQuery(name="Imovel.recuperarContratosDoCliente", query= "SELECT DISTINCT(cliente) FROM PessoaFisica cliente LEFT JOIN FETCH cliente.contratos"),
	@NamedQuery(name="Imovel.recuperarTodosFetch", query= "select i from Imovel i LEFT JOIN FETCH i.endereco")
})

@Entity
@Table(name = "TB_Imovel")
public class Imovel {

	@Id
	@GeneratedValue(generator = "imovel_seq")
	@SequenceGenerator(name = "imovel_seq", sequenceName = "IMOVEL_SEQ")
	private Long id;

	@Column(name = "ImoLatitude", nullable = false, scale = 2, precision = 20)
	private Double lat;

	@Column(name = "ImoLongitude", nullable = false, scale = 2, precision = 20)
	private Double longi;

	@OneToOne
	private Endereco endereco;

	private BigDecimal valor;

	private String descricao;

	@OneToMany(mappedBy = "imovel")
	List<Contrato> contratos;

	@PrePersist
	public void prePersist() {
		System.out.println("Persistindo um novo objeto com persist() ou merge()...");
	}

	@PostPersist
	public void postPersist() {
		System.out.println("O comando insert foi executado no banco de dados...");
		System.out.println("Um rollback ainda pode desfazer o comando insert...");
	}

	@PreRemove
	public void preRemove() {
		System.out.println("Removendo um objeto gerenciado com remove()...");
	}

	@PostRemove
	public void postRemove() {
		System.out.println("O comando delete foi executado no banco de dados...");
		System.out.println("Um rollback ainda pode desfazer o comando delete...");
	}

	@PreUpdate
	public void preUpdate() {
		System.out.println("O comando update executará no banco de dados...");
	}

	@PostUpdate
	public void postUpdate() {
		System.out.println("O comando update foi executado no banco de dados...");
		System.out.println("Um rollback ainda pode desfazer o comando update...");
	}
	
	@PostLoad
	public void postLoad(){
	System.out.println("Um objeto foi carregado com os dados do banco de dados.");
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLongi() {
		return longi;
	}

	public void setLongi(Double longi) {
		this.longi = longi;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Imovel [id=" + id + ", lat=" + lat + ", longi=" + longi + ", endereco=" + endereco + ", valor=" + valor
				+ ", descricao=" + descricao + ", contratos=" + contratos + "]";
	}

	
}
