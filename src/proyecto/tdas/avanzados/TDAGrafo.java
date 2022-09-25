package proyecto.tdas.avanzados;

public class TDAGrafo {
    protected int size;
    protected Vertice matrizAdyacencia[][];
    
    public TDAGrafo(){
        size = 0;
        matrizAdyacencia = new Vertice[0][0];
    }
    public TDAGrafo(int size){
        this.size = size;
        matrizAdyacencia = new Vertice[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Vertice[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void setMatrizAdyacencia(Vertice[][] matrizAdyacencia) {
        this.matrizAdyacencia = matrizAdyacencia;
    }
    
}
