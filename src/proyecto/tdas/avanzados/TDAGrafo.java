package proyecto.tdas.avanzados;

public class TDAGrafo {
    protected int size;
    protected NodoGrafo matrizAdyacencia[][];
    
    public TDAGrafo(){
        size = 0;
        matrizAdyacencia = new NodoGrafo[0][0];
    }
    public TDAGrafo(int size){
        this.size = size;
        matrizAdyacencia = new NodoGrafo[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodoGrafo[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void setMatrizAdyacencia(NodoGrafo[][] matrizAdyacencia) {
        this.matrizAdyacencia = matrizAdyacencia;
    }
    
}
