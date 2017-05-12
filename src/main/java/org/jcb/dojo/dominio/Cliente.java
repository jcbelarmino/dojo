package org.jcb.dojo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
		
		@ManyToMany
		private List<Endereco> endereco;
		
		@OneToMany(mappedBy="cliente")
		List<Contrato> contratos;

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

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<Endereco> getEndereco() {
			return endereco;
		}

		public void setEndereco(List<Endereco> endereco) {
			this.endereco = endereco;
		}

		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", contratos=" + contratos + "]";
		}
		
		

}
