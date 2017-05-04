package org.jcb.dojo.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private long id;
	
	private String nome;
	
	@OneToMany(mappedBy="cliente")
	private List<Imovel> imoveis; 
}
