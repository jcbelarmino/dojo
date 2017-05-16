package org.jcb.calculadora;

import java.util.Scanner;

import org.jcb.framework.Divisao;
import org.jcb.framework.Multiplicacao;
import org.jcb.framework.Nodo;
import org.jcb.framework.Soma;
import org.jcb.framework.Subtracao;
import org.jcb.framework.Valor;

public class CalcOO {

	public static void main(String args[]) {
		// criando um objeto c a apartir do metodo calc

		// declarando as varíaveis
		Nodo resultado = new Valor(0);
		String expressao = "";
		Scanner input = new Scanner(System.in);
		System.out.println("Informe uma expressão");
		expressao = input.next();
		resultado = parser(expressao);
		System.out.println("Resultado: " + resultado.calcula());
	} // fim do metodo principal

	private static Nodo parser(String expressao) {
		Nodo resultado = new Valor(0);
		if (expressao.isEmpty() || expressao == "") {
			System.out.println("Favor informar uma expressão");
		} else {
			try {
				// int i = 0;
				// resultado = new Valor(Integer.parseInt(expressao.charAt(i) +
				// ""));

				Scanner scanner = new Scanner(expressao);
				Scanner scannerOperacao = new Scanner(expressao);
				scanner.useDelimiter("[+-/*//]");
				scannerOperacao.useDelimiter("\\d+");

				resultado = new Valor(Integer.parseInt(scanner.next().trim()));
				while (scanner.hasNext()) {
					System.out.println(1 + "");
					Nodo esquerda = resultado;
					System.out.println(esquerda.calcula());
					String opcao = scannerOperacao.next().trim();
					System.out.println(opcao);
					// System.out.println(scanner.next().trim());
					Nodo direita = new Valor(Integer.parseInt(scanner.next().trim()));
					// System.out.println(scanner.delimiter().toString());
					System.out.println(direita.calcula());
					switch (opcao) {
					case "+":
						resultado = new Soma(esquerda, direita);
						break;
					case "-":
						resultado = new Subtracao(esquerda, direita);
					case "*":
						resultado = new Multiplicacao(esquerda, direita);
						break;
					case "/":
						resultado = new Divisao(esquerda, direita);
						break;
					default:
						break;

					}
					// i = i + 2;
				}
			} catch (Exception e) {
				System.out.println("Informar expressão válida");
			}
		}
		return resultado;
	}

	// private static Nodo parser(String expressao) {
	// Nodo resultado = new Valor(0);
	// if (expressao.isEmpty() || expressao == "") {
	// System.out.println("Favor informar uma expressão");
	// } else {
	// try {
	// int i = 0;
	// resultado = new Valor(Integer.parseInt(expressao.charAt(i) + ""));
	// while (i < expressao.length()) {
	//
	// Nodo esquerda = resultado;
	// Nodo direita = new Valor(Integer.parseInt(expressao.charAt(i + 2) + ""));
	// switch (expressao.charAt(i + 1)) {
	// case '+':
	// resultado = new Soma(esquerda, direita);
	// break;
	// case '-':
	// resultado = new Subtracao(esquerda, direita);
	// case '*':
	// resultado = new Multiplicacao(esquerda, direita);
	// break;
	// case '/':
	// resultado = new Divisao(esquerda, direita);
	// break;
	// default:
	// break;
	//
	// }
	// i = i + 2;
	// }
	// } catch (Exception e) {
	// System.out.println("Informar expressão válida");
	// }
	// }
	// return resultado;
	// }
}
