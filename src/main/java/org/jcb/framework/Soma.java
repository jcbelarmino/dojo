package org.jcb.framework;
/**
 *
 * @author jean
 */
public class Soma extends Operacao {

    public Soma(Nodo esquerda, Nodo direita) {
        super(esquerda, direita);
    }

    @Override
    protected int executa(int esquerda, int direita) {
        return esquerda + direita;
    }

    @Override
    protected String simbolo() {
        return "+";
    }

}
