package org.jcb.framework;
/**
 *
 * @author jean
 */
public abstract class Operacao implements Nodo {
    private final Nodo esquerda;
    private final Nodo direita;

    public Operacao(Nodo esquerda, Nodo direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

   
    @Override
    public final int calcula() {
        return executa(this.esquerda.calcula(), this.direita.calcula());
    }
    
    protected abstract int executa(int esquerda, int direita);
    
    protected abstract String simbolo();

    @Override
    public String toString() {
        return  "(" + esquerda + " " + simbolo() + " " + direita + ")";
    }
    
    
    
}
