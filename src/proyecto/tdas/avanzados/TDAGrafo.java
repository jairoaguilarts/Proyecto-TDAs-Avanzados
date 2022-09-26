package proyecto.tdas.avanzados;

import java.util.*;

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
    public void automatic_Fill(){ //Funcion para llenar los valores de la matriz de adyacencia
        Random rndm = new Random();
        for (int i = 0; i < size; i++) {
            Vertice temp = new Vertice(rndm.nextInt(15) + 0);
            for (int j = 0; j < size; j++) {
                matrizAdyacencia[i][j] = temp;
            }
        }
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
