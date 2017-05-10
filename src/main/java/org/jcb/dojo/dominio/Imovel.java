package org.jcb.dojo.dominio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_Imovel")
public class Imovel {

		@Id
		@GeneratedValue(generator="imovel_seq")
		@SequenceGenerator(name="imovel_seq",sequenceName="IMOVEL_SEQ")
		private Long id;
		
		@Column(name="ImoLatitude",nullable=false, scale=2, precision=20)
		private Double lat;

		@Column(name="ImoLongitude", nullable=false, scale=2, precision=20)
		private Double longi;
		
		@Column(name="Endereco", length=512)
		private String endereco;
		
		private BigDecimal valor;
	
		private String descricao;
		
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

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
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
		
		
		
}
