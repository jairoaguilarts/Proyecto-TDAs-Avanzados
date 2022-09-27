package proyecto.tdas.avanzados; 

public class GrafoFloyd extends TDAGrafo{ 
    
    private final int NaN = 1000000000; 
    private int matrizCostos[][]; 
    public GrafoFloyd(int size) { 
        this.size = size; 
        matrizAdyacencia = new Vertice[size][size]; 
        matrizCostos = new int[size][size]; 
        automatic_Fill(); 
        for(int i = 0; i < size; i++){ 
            for (int j = 0; j < size; j++) { 
                if(i == j){ 
                    matrizAdyacencia[i][j].setValor(NaN); 
                } 
            } 
        } 
    } 
    
    public void llenarCostos(){ 
        for(int i = 0; i < size; i++){ 
            for (int j = 0; j < size; j++) { 
                if(i == j){ 
                    matrizCostos[i][j] = 0; 
                } else{ 
                    matrizCostos[i][j] = matrizAdyacencia[i][j].getValor(); 
                } 
            } 
        } 
    } 
    
    public void algoritmoFloyd(){ 
        llenarCostos(); 
        for(int i = 0; i < size; i++){ 
            for(int j = 0; j < size; j++){ 
                for(int k = 0; k < size; k++){ 
                    if(matrizCostos[j][i] + matrizCostos[i][k] < matrizCostos[j][k]){ 
                        matrizCostos[j][k] = matrizCostos[j][i] + matrizCostos[i][k]; 
                    } 
                } 
            } 
        } 
        System.out.println("Matriz Adyacencia: "); 
        for(int i = 0; i < size; i++){ 
            for(int j = 0; j < size; j++){ 
                if(matrizAdyacencia[i][j].getValor() == NaN) 
                    System.out.print("NaN "); 
                else 
                    System.out.print(matrizAdyacencia[i][j].getValor() + " "); 
            } 
            System.out.println(); 
        } 
        System.out.println(""); 
        System.out.println("Matriz Costo Minimo: "); 
        for(int i = 0; i < size; i++){ for(int j = 0; j < size; j++){
            if(matrizCostos[i][j] == 0) 
                System.out.print("NaN "); 
            else 
                System.out.print(matrizCostos[i][j] + " "); 
        } 
        System.out.println(); 
        } 
    } 
}