package proyecto.tdas.avanzados;

//No se si Prim lleva matriz de costo :P

import java.util.Arrays;

public class GrafoPrim extends TDAGrafo{
    //private int matrizCosto[][];
    private int NaN = 1000000000;
    
    //se setea la diagonal a NaN
    public GrafoPrim() {
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                if(i == j){
                    matrizAdyacencia[i][j].setValor(NaN);
                }
            }
        }
    }
    
    //Algoritmo de Prim, calculo de valores, desde el origen a todo los puntos
    public void algoritmoPrim() {
        int costo_Menor[] = new int[size];
        int recorrido_Minimo[] = new int[size];
        int minimo, ref;
        for (int i = 2; i < size; i++) {
            costo_Menor[i] = matrizAdyacencia[1][i].getValor();
            recorrido_Minimo[i] = 1;
        }
        for (int i = 2; i < size; i++) { //aqui se encuentra la arista mas cercana de 'matrizAdyacencia' y se guarda en 'ref'
            minimo = costo_Menor[2];
            ref = 2;
            for (int j = 3; j < size; j++) {
                if(costo_Menor[j] < minimo){
                    minimo = costo_Menor[j];
                    ref = j;
                }
            }
            System.out.println("Arista mas cercana: " + recorrido_Minimo[ref]);
            costo_Menor[ref] = NaN;
            for (int j = 2; j < size; j++) {
                if(matrizAdyacencia[ref][j].getValor() < costo_Menor[j] && 
                        costo_Menor[j] < NaN){
                    costo_Menor[j] = matrizAdyacencia[ref][j].getValor();
                    recorrido_Minimo[j] = ref;
                }
            }
        }
    }
    
    
}
