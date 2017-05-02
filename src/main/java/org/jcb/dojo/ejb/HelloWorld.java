package org.jcb.dojo.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {

	public String hello(String nome);
}
