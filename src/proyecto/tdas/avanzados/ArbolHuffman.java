package proyecto.tdas.avanzados;

import java.util.LinkedList;

public class ArbolHuffman {
    
    private NodoHuffman raiz;
    private final LinkedList caracteresDiferentes = new LinkedList();
    private final LinkedList frecuenciaCaracteres = new LinkedList();
    private final LinkedList<NodoHuffman> nodos = new LinkedList();
    
    public ArbolHuffman(String texto) {
        obtenerCaracteres(texto);
        contarCaracteres(texto);
        crearNodos();
        unirNodos();
        raiz = nodos.get(0);
    }
    
    private void obtenerCaracteres(String texto) {
        int listIndex = 0;
        for(int i = 0; i < texto.length(); i++) {
            if(!caracteresDiferentes.contains(texto.charAt(i))) {
                caracteresDiferentes.add(listIndex++, texto.charAt(i));
            }
        }
    }
    
    private void contarCaracteres(String texto) {
        for(int i = 0; i < caracteresDiferentes.size(); i++) {
            char caracter = (char)caracteresDiferentes.get(i);
            int contador = 0;
            for(int j = 0; j < texto.length(); j++) {
                if(caracter == texto.charAt(j))
                    contador++;
            }
            frecuenciaCaracteres.add(i, contador);
        }
    }
    
    private void crearNodos() {
        for(int i = 0; i < caracteresDiferentes.size(); i++) {
            NodoHuffman nodo = new NodoHuffman((char)caracteresDiferentes.get(i), (int)frecuenciaCaracteres.get(i));
            nodos.add(i, nodo);
        }
    }
    
    private void unirNodos() {
        while(nodos.size()>=2) {
            NodoHuffman n1, n2;
            int frecuencia = 100000, minimaFrecuencia1 = -1, minimaFrecuencia2 = -1;
            for(int i = 0; i < nodos.size(); i++) { //Nodo con menor frecuencia 1
                if(nodos.get(i).getFrecuencia() < frecuencia) {
                    minimaFrecuencia1 = i;
                }
            }
            n1 = nodos.get(minimaFrecuencia1);
            for(int i = 0; i < nodos.size(); i++) { //Nodo con menor frecuencia 2
                if(nodos.get(i).getFrecuencia() < frecuencia) {
                    minimaFrecuencia2 = i;
                }
            }
            n2 = nodos.get(minimaFrecuencia2);
            nodos.remove(minimaFrecuencia1);
            nodos.remove(minimaFrecuencia2);
            NodoHuffman newNode = new NodoHuffman((n1.getFrecuencia() + n2.getFrecuencia()), n1, n2);
            nodos.add(newNode);
        }
    }
    
}
