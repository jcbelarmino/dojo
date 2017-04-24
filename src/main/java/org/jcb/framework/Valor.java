package org.jcb.framework;
/**
 *
 * @author jean
 */
public class Valor implements Nodo {

    private final int val;

    public Valor(int val) {
        this.val = val;
    }

    @Override
    public int calcula() {
        return this.val;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
    
    
}
