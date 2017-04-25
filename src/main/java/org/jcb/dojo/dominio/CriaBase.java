package org.jcb.dojo.dominio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaBase {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dojoPU");
		factory.close();
	}
}
