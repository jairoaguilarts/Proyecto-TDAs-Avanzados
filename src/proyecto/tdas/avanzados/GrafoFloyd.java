/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.tdas.avanzados;

public class GrafoFloyd extends TDAGrafo{
    
    private final int NaN = 1000000000;
    private int matrizCostos[][];
    
    public GrafoFloyd(int size) {
        //super(size);
        this.size = size;
        matrizAdyacencia = new Vertice[size][size];
        matrizCostos = new int[size][size];
        automatic_Fill();
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                if(i == j){
                    matrizAdyacencia[i][j].setValor(NaN);
                    matrizCostos[i][j] = 0;
                }
                else{
                    matrizCostos[i][j] = matrizAdyacencia[i][j].getValor();
                }
            }
        }
    }
    
    public void algoritmoFloyd(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    if(matrizCostos[j][i] + matrizCostos[i][k] < matrizCostos[j][k]){
                        matrizCostos[j][k] = matrizCostos[j][i] + matrizCostos[i][k];
                    }
                }
            }
        }
        
        System.out.println("Matriz Adyacencia");
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(matrizAdyacencia[i][j].getValor() + " ");
            }
            System.out.println();
        }
        System.out.println("Matriz Costo Minimo");
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(matrizCostos[i][j] + " ");
            }
            System.out.println();
        }
    }
}
