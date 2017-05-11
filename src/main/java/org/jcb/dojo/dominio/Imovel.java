package org.jcb.dojo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Imovel.recuperarTodos", query= "select i from Imovel i"),
	@NamedQuery(name="Imovel.recuperarPorMaiorValor", query = "select i from Imovel i where i.preco < :preco"),
	@NamedQuery(name="Imovel.recuperarUnico", query = "select i from Imovel i where i.id = 4"),
	@NamedQuery(name="Imovel.recuperarRuaLatLongi", query= "select i.lat, i.longi, i.endereco.bairro from Imovel i"),
	@NamedQuery(name="Imovel.recuperarRuaLatLongiDTO", query= "select new org.jcb.dojo.dominio.LatLongiBairroDTO(i.lat, i.longi, i.endereco.bairro) from Imovel i"),
	@NamedQuery(name="Imovel.recuperarContratosDoCliente", query= "SELECT DISTINCT(cliente) FROM PessoaFisica cliente LEFT JOIN FETCH cliente.contratos")
})
@Entity
@Table(name="TBL_IMOVEL")
public class Imovel {

		@Id
		@GeneratedValue(generator = "imovel_seq_gen")
		@SequenceGenerator(name = "imovel_seq_gen", sequenceName = "imovel_id_seq")
		private Long id;

		@Column(nullable=false, precision=3, scale=20)
		private Double lat;

		@Column(nullable=false, precision=3, scale=20)
		private Double longi;
		
		@Column(nullable=false, precision=5, scale=2)
		private Double preco;
	
		@OneToOne
		private Endereco endereco;
		
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

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}

		@Override
		public String toString() {
			return "Imovel [id=" + id + ", lat=" + lat + ", longi=" + longi + ", preco=" + preco + ", endereco="
					+ endereco + "]";
		}
		
}
