package org.jcb.dojo.dominio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_Cliente")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cliente_tipo")
public class Cliente {

		@Id
		@GeneratedValue(generator="cliente_seq")
		@SequenceGenerator(name="cliente_seq",sequenceName="CLIENTE_SEQ")
		private Long id;
		
		@Column(name="nome", nullable=false)
		private String nome;
		
		@Column(name="endereco", nullable=false)
		private String endereco;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

}
