package org.jcb.dojo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Imovel {

		@Id
		@GeneratedValue
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
