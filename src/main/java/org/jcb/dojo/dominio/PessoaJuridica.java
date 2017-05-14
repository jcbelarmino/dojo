package org.jcb.dojo.dominio;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Cliente {
	
	String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
}
