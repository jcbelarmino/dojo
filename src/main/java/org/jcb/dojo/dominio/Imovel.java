package org.jcb.dojo.dominio;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Imovel {

		@Id
		@GeneratedValue
		private Long id;

		private Double lat;

		private Double longi;
		
		private String endereço;
		
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
