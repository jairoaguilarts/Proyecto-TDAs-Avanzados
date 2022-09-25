package proyecto.tdas.avanzados;

//No se si Prim lleva matriz de costo :P
public class GrafoPrim extends TDAGrafo{
    private NodoGrafo matrizCosto[][];
    
    public GrafoPrim(){
        matrizCosto = new NodoGrafo[size][size];
    }
    
    /*public int primero(int vertice){
        
    }
    
    public NodoGrafo[][] origenATP(int origen){ //Del Origen a todos los puntos
        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                if(matrizAdyacencia[i][j] == 0)
            }
        }
    }*/
}
