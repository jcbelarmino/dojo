package org.jcb.dojo.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {
	List<String> nomes;
	
	@PostConstruct
	private void incia(){
		System.out.println("Inicia com @PostConstruct");
		nomes = new ArrayList<>();
	}
	public String hello(String nome){
		nomes.add(nome);
		System.out.println("Hello "+nome);
		return "Alo "+ nome;
	}
	
	public List<String> historico(){
		return nomes;
	}

	@PreDestroy
	private void finaliza(){
		System.out.println("finaliza com @PreDestroy");
		nomes = null;
	}
	
}
