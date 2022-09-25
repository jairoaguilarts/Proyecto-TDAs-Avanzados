package proyecto.tdas.avanzados;

import java.io.*;

public class TDAArbolBinario implements Serializable {
    
    protected Nodo raiz;
    
    public TDAArbolBinario() {
        raiz = null;
    }
    
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public Nodo getRaiz() {
        return this.raiz;
    }
    
}
