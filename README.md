# dojo


Para inciar o dojo da Aula1
>git checkout -b Aula1

1. Implementar um framework de calculadora.

A solução do problema da Aula1
>git checkout -b Aula1_resultado


Para inciar o dojo da Aula2
>git checkout -b Aula2

1. Criar tabela no banco
2. Alterar o mapeamento com `@Column`

>git checkout -b JPA-mapeamento

1. Fazer programa para incluir um Imóvel
2. Fazer programa para Alterar
3. Fazer programa para consultar um imóvel
4. Fazer programa para remover um imóvel
5. Fazer programa que consulta vários imóveis

   ```
   EntityManager  em;

	public ImovelDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void criar(Imovel i){
		...
	}
	
	public void remover(Long id) throws Exception{
		...
	}

	public Imovel recuperarPorId(Serializable id) throws Exception {
		...
	}
	
	public void atualizar(Imovel entidade) throws Exception {
		...
	}
	
	public List<Imovel> recuperarTodos() {
		...
	}`` 


>git checkout -b JPA-entidades

1. Criar um DAO

>git checkout -b JPA-DAO

* fazer programas de teste para verificar o momento de carga dos objetos dependento do ``FetchType``

1. implementar um relacionamento ``@OneToOne`` entre Imovel e Endereço 
2. implementar um relacionamento ``@OneToMany`` entre Imovel e Cliente
3. alterar o relacionamentos para ``LAZY``: ``@OneToOne ( fetch = FetchType.LAZY )``
4. implementar um relacionamento ``@ManyToOne`` 
4. implementar um relacionamento ``@ManyToMany``  apenas para efeito de teste
5. alterar os relacinamentos para EAGER ``@ManyToOne ( fetch = FetchType.EAGER )``

>git checkout -b JPA-relacionamento

1. criar um DAO generico

>git checkout -b JPA-DAO-GENERICO

1. Criar uma `NamedQuery` que recebe parâmetro e retorna uma lista.
2. Criar uma ``NamedQuery``que recebe parâmetro e retorna um único elemento.
3. Criar uma ``NamedQuery`` que retorna dados não mapeados.
4. criar uma ``NamedQuery`` que retorna dados mapeados.
5. Criar uma ``NamedQuery`` com paginação.
6. criar um `update` em lote.
7. Criar um query nativa.

Codigo de exemplo em:
>git checkout -b JPA-JPQL

Para o módulo EJB:

Implantar o projeto dojo-ejb  

1. Testar as chamadas remotas.

Voltar para o o projeto dojo

>git checkout -b JPA-EJB

1. testar o `HelloServlet`
2. Configurar `Datasource`
3. Trocar o DAO por EJB.
4. Criar tela básica de cadastro de Imóveis

O branch JPA-EJB-FINAL ajuda.
>git checkout -b JPA-EJB-FINAL
