package org.jcb.dojo.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Cliente {
	
	@Id
	private long id;
	
	private int ano;

}
