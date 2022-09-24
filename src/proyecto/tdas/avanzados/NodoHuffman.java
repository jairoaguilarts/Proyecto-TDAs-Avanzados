package proyecto.tdas.avanzados;

public class NodoHuffman {
    
    private final char caracter;
        private final int frecuencia;
        private final NodoHuffman derecho;
        private final NodoHuffman izquierdo;
        
        public NodoHuffman(char caracter, int frecuencia) {
            this.caracter = caracter;
            this.frecuencia = frecuencia;
            this.derecho = null;
            this.izquierdo = null;
        }
        
        public NodoHuffman(char caracter, int frecuencia, NodoHuffman izquierdo, NodoHuffman derecho) {
            this.caracter = caracter;
            this.frecuencia = frecuencia;
            this.derecho = derecho;
            this.izquierdo = izquierdo;
        }
        
        public char getCaracter() {
            return caracter;
        }
        
        public int getFrecuencia() {
            return frecuencia;
        }
        
        public NodoHuffman getNodoDerecho() {
            return derecho;
        }
        
        public NodoHuffman getNodoIzquierdo() {
            return izquierdo;
        }
        
        public boolean esHoja() {
            return (derecho == null) && (izquierdo == null);
        }
    
}
