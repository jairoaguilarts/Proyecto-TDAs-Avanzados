package proyecto.tdas.avanzados;

import java.util.Arrays;
import java.lang.*;

public class GrafoPrim extends TDAGrafo{
    
    private final int NaN = 1000000000;
    
    //Se setea la diagonal a NaN
    public GrafoPrim() {
        matrizAdyacencia = new Vertice[size][size];
    }
    /*Busca la 'arista mas barata' (el nombre lo dice), a traves de los vertices que
    aun no han ido recorridos y lo devuelve*/
    public int arista_mas_barata(int costo_Menor[], boolean vertices_recorridos[]){
        int minimo = NaN, indice_minimo = -1;
        for (int i = 0; i < size; i++) {
            if(vertices_recorridos[i] == false && costo_Menor[i] < minimo){
                minimo = costo_Menor[i];
                indice_minimo = i;
            }
        }
        return indice_minimo;
    }
    /*Algoritmo de Prim, calculo de valores, desde el origen a todo los punto
    agarrando la ruta mas corta que se pueda conectar con todos los puntos!*/
    public void algoritmoPrim() {
        int costo_Menor[] = new int[size];                                  //Calcula el costo menor entre los valores adyacentes
        int recorrido_Minimo[] = new int[size];                             //aqui se agregan los Vertices mas cercanos
        boolean vertices_recorridos[] = new boolean[size];                  //lleva control de los Vertices por los que pasamos y debemos pasar
        
        Arrays.fill(costo_Menor, NaN);
        Arrays.fill(vertices_recorridos, false);                      //Se setean todas las vertices como no recorridas y NaN
        
        recorrido_Minimo[0] = -1;
        costo_Menor[0] = 0;                                                 //se inicializan ambos valores iniciales, se inicia desde el origen
        
        
        for (int i = 0; i < size - 1; i++) {
            int v = arista_mas_barata(costo_Menor, vertices_recorridos);    //busqueda del vertice mas corto
            System.out.println("Vertice: " + v);
            vertices_recorridos[v] = true;                                  //seteado como 'vertice recorrido'
            
            for (int j = 0; j < size; j++) {
                if(matrizAdyacencia[v][j].getValor() != NaN && vertices_recorridos[j] == false &&
                        matrizAdyacencia[v][j].getValor() < costo_Menor[j]){
                    recorrido_Minimo[j] = v;                                //Se van cambiando los valores a medida que se recorre la matriz y
                    costo_Menor[j] = matrizAdyacencia[v][j].getValor();     //los valores de 'aristas' mas baratos ingresan al array de 'recorrido_minimo'
                }
            }
        }
        //Se imprime las Vertices conectadas al origen con su respectivo coste
        System.out.println("Vertice ------ Coste");
        for (int i = 1; i < size; i++) {
            int red = i + 1;
            System.out.println(recorrido_Minimo[i] + " --- " + i + "         " + 
                    matrizAdyacencia[i][recorrido_Minimo[i]].getValor());
        }
    }
    
    
}
