package proyecto.tdas.avanzados;

import java.util.Arrays;

public class GrafoPrim extends TDAGrafo{
    
    private final int NaN = 1000000000;
    
    public GrafoPrim() {
        matrizAdyacencia = new Vertice[size][size];
    }
    
    public int arista_mas_barata(int costo_Menor[], boolean vertices_recorridos[]) {
        int minimo = NaN, indice_minimo = -1;
        for (int i = 0; i < size; i++) {
            if(vertices_recorridos[i] == false && costo_Menor[i] < minimo){
                minimo = costo_Menor[i];
                indice_minimo = i;
            }
        }
        return indice_minimo;
    }
    
    public void algoritmoPrim() {
        int costo_Menor[] = new int[size];                                  
        int recorrido_Minimo[] = new int[size];                             
        boolean vertices_recorridos[] = new boolean[size];   
        Arrays.fill(costo_Menor, NaN);
        Arrays.fill(vertices_recorridos, false);        
        recorrido_Minimo[0] = -1;
        costo_Menor[0] = 0;                                                 
        for (int i = 0; i < size - 1; i++) {
             //Busqueda del vertice mas corto
            int v = arista_mas_barata(costo_Menor, vertices_recorridos);   
            System.out.println("Vertice: " + v);
            vertices_recorridos[v] = true;  
            //Los valores de 'aristas' mas baratos ingresan al array de 'recorrido_minimo'
            for (int j = 0; j < size; j++) {
                if(matrizAdyacencia[v][j].getValor() != NaN && vertices_recorridos[j] == false && matrizAdyacencia[v][j].getValor() < costo_Menor[j]) {
                    recorrido_Minimo[j] = v;                                
                    costo_Menor[j] = matrizAdyacencia[v][j].getValor();     
                }
            }
        }
        
        //Imprime los vertices conectados al origen con su respectivo coste
        System.out.println("Vertice ------ Coste");
        for (int i = 1; i < size; i++) {
            System.out.println(recorrido_Minimo[i] + " --- " + i + "         " + 
                    matrizAdyacencia[i][recorrido_Minimo[i]].getValor());
        }
    }
    
    
}
