package proyecto.tdas.avanzados;

import java.util.LinkedList;
import java.io.*;

public class ArbolHuffman implements Serializable{
    
    private boolean banderaHoja = false;
    
    private NodoHuffman raiz = null;
    private final LinkedList<Character> caracteresDiferentes = new LinkedList();
    private final LinkedList<Integer> frecuenciaCaracteres = new LinkedList();
    private final LinkedList<String> codigoHuffman = new LinkedList();
    private final LinkedList<NodoHuffman> nodos = new LinkedList();
    
    public ArbolHuffman() {}
    
    public String codificarTexto(String texto) {
        String codigo = "";
        obtenerCaracteres(texto);
        contarCaracteres(texto);
        crearNodos();
        unirNodos();
        raiz = nodos.get(0);
        calcularCodigos();
        //Codifica el texto
        for(int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            for(int j = 0; j < caracteresDiferentes.size(); j++) {
                if(caracter == (char)caracteresDiferentes.get(j)) {
                    codigo += codigoHuffman.get(j);
                }
            }
        }
        return codigo;
    }
    
    public String decodificar(String codigo) {
        String texto = "";
        NodoHuffman temp = raiz;
        for(int i = 0; i < codigo.length(); i++) {
            if(codigo.charAt(i) == '0') {
                temp = temp.getIzquierdo();
            } else {
                temp = temp.getDerecho();
            }
            if(temp.esHoja()) {
                texto += temp.getCaracter();
                temp = raiz;
            }
        }
        return texto;
    }
    
    private void obtenerCaracteres(String texto) {
        for(int i = 0; i < texto.length(); i++) {
            if(!caracteresDiferentes.contains(texto.charAt(i))) {
                caracteresDiferentes.add(texto.charAt(i));
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
            frecuenciaCaracteres.add(contador);
        }
    }
    
    private void crearNodos() {
        for(int i = 0; i < caracteresDiferentes.size(); i++) {
            NodoHuffman nodo = new NodoHuffman((char)caracteresDiferentes.get(i), (int)frecuenciaCaracteres.get(i));
            nodos.add(nodo);
        }
    }
    
    private void unirNodos() {
        while(nodos.size()>=2) {
            NodoHuffman n1, n2;
            int frecuencia = 100000, minimaFrecuencia1 = -1, minimaFrecuencia2 = -1;
            for(int i = 0; i < nodos.size(); i++) { //Nodo con menor frecuencia 1
                if(nodos.get(i).getFrecuencia() < frecuencia) {
                    frecuencia = nodos.get(i).getFrecuencia();
                    minimaFrecuencia1 = i;
                }
            }
            n1 = nodos.get(minimaFrecuencia1);
            nodos.remove(minimaFrecuencia1);
            frecuencia = 100000;
            for(int i = 0; i < nodos.size(); i++) { //Nodo con menor frecuencia 2
                if(nodos.get(i).getFrecuencia() < frecuencia) {
                    frecuencia = nodos.get(i).getFrecuencia();
                    minimaFrecuencia2 = i;
                }
            }
            n2 = nodos.get(minimaFrecuencia2);
            nodos.remove(minimaFrecuencia2);
            NodoHuffman newNode = new NodoHuffman((n1.getFrecuencia() + n2.getFrecuencia()), n1, n2);
            nodos.add(newNode);
        }
    }
    
    private void calcularCodigos() { 
        for(int i = 0; i < caracteresDiferentes.size(); i++) {
            String codigoCaracter = calcularCodigo(caracteresDiferentes.get(i));
            System.out.println(codigoCaracter);
            codigoHuffman.add(codigoCaracter);
        }
    }
    
    private String calcularCodigo(char caracter) { 
        String codigo = "";
        NodoHuffman temp = raiz;
        boolean revisoIzquierda = false, revisoDerecha = false;
        while(true) {
            if(temp.esHoja()) {
                if(temp.getCaracter() == caracter) {
                    System.out.println(temp.getCaracter());
                    return codigo;
                } else {
                    codigo = "";
                    temp = raiz;
                }
            } else { 
                if(!revisoIzquierda) {
                    temp.getIzquierdo();
                    codigo += "0";
                    revisoIzquierda = true;
                } else {
                    revisoIzquierda = false;
                }
                if(!revisoDerecha) {
                    temp = temp.getDerecho();
                    codigo += "1";
                    revisoDerecha = true;
                } else {
                    revisoDerecha = false;
                }
            } 
        }
    }
    
}
