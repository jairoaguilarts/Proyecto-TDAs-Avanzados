package proyecto.tdas.avanzados;

public class NodoHuffman {
    
    private final char caracter;
    private final int frecuencia;
    private final NodoHuffman izquierdo;
    private final NodoHuffman derecho;

    public NodoHuffman(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        this.derecho = null;
        this.izquierdo = null;
    }

    public NodoHuffman(int frecuencia, NodoHuffman izquierdo, NodoHuffman derecho) {
        this.caracter = '\u0000';
        this.frecuencia = frecuencia;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public char getCaracter() {
        return caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public NodoHuffman getIzquierdo() {
        return izquierdo;
    }

    public NodoHuffman getDerecho() {
        return derecho;
    }
    
    public boolean esHoja() {
        return (derecho == null) && (izquierdo == null);
    }
    
}
