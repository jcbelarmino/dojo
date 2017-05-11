package org.jcb.dojo.dominio;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Cliente{

	private String cpf;
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + "]" ;
	}
	
	
	
}
