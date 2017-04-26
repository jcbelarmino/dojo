package org.jcb.dojo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Imovel {

		@Id
		@GeneratedValue
		private Long id;

		@Column(nullable=false, precision=3, scale=20)
		private Double lat;

		@Column(nullable=false, precision=3, scale=20)
		private Double longi;
		
		@Column(nullable=false, length=512)
		private String endereço;
		
		@Column(nullable=false, precision=5, scale=2)
		private Double preco;
	
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

		public String getEndereço() {
			return endereço;
		}

		public void setEndereço(String endereço) {
			this.endereço = endereço;
		}

		public Double getPreco() {
			return preco;
		}

		public void setPreco(Double preco) {
			this.preco = preco;
		}
}
