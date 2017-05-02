package org.jcb.dojo.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {
	
	public String hello(String nome){
		return "Alo "+ nome;
	}

}
