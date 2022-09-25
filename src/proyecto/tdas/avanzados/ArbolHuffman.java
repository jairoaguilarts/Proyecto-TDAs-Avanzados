package proyecto.tdas.avanzados;

import java.util.*;

public class ArbolHuffman extends TDAArbolBinario {
    
    private final LinkedList<Nodo> nodos = new LinkedList<Nodo>();

    public ArbolHuffman() {}
    
    public String codificar(String texto) {
        String codigo = "";
        //Listas necesarias para crear los nodos
        LinkedList<Character> caracteresDiferentes = new LinkedList<>();
        LinkedList<Integer> frecuenciaCaracteres = new LinkedList<>();
        //Lista para almacenar el codigo de cada caracter
        LinkedList<String> codigosHuffman = new LinkedList<>();
        for(int i = 0; i < texto.length(); i++) {
            if(!caracteresDiferentes.contains(texto.charAt(i))) { //Llena la lista con los caracteres diferentes
                caracteresDiferentes.add(texto.charAt(i));
            }
        }
        for(int i = 0; i < caracteresDiferentes.size(); i++) { //Cuenta las vaces que se repite un caracter
            char caracter = (char)caracteresDiferentes.get(i);
            int contador = 0;
            for(int j = 0; j < texto.length(); j++) {
                if(caracter == texto.charAt(j))
                    contador++;
            }
            frecuenciaCaracteres.add(contador);
        }
        for(int i = 0; i < caracteresDiferentes.size(); i++) { //Crea todos los nodos
            Nodo nodo = new Nodo(caracteresDiferentes.get(i), (int)frecuenciaCaracteres.get(i));
            nodos.add(nodo);
        }
        while(nodos.size()>=2) { //Genera el arbol
            Nodo n1, n2;
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
            Nodo newNode = new Nodo((n1.getFrecuencia() + n2.getFrecuencia()), n1, n2);
            nodos.add(newNode);
        }
        super.raiz = nodos.get(0);
        codificarNodosHoja(super.raiz, "");
        for(int i = 0; i < caracteresDiferentes.size(); i++) { //Agrega las rutas de cada caracter
            codigosHuffman.add(i, calcularRuta(raiz, caracteresDiferentes.get(i), ""));
        }
        for(int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            for(int j = 0; j < caracteresDiferentes.size(); i++) {
                if(caracteresDiferentes.get(j) == caracter) {
                    codigo += codigosHuffman.get(j);
                }
            }
        }
        return codigo;
    }
    
    public String decodificar(String codigo) {
        String texto = "";
         Nodo temp = raiz;
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
    
    private void codificarNodosHoja(Nodo raiz, String  codigo) {
        if(!(raiz.esHoja())) {
            if (raiz.getIzquierdo()!= null)
                codificarNodosHoja(raiz.getIzquierdo(), codigo+"0");
            if (raiz.getDerecho()!= null)
                codificarNodosHoja(raiz.getDerecho(), codigo+"1");
        } else {
            raiz.setCodigoHuffman(codigo);
        }
    }
    
    private String calcularRuta(Nodo nodo, char caracter, String codigo) {
        if(nodo.esHoja()) {
            if(nodo.getCaracter() == caracter) {
                return nodo.getCodigoHuffman();
            }
        } else {
            if (nodo.getIzquierdo()!= null) {
                codigo = calcularRuta(nodo.getIzquierdo(), caracter, codigo);
            }
            if (nodo.getDerecho()!= null) {
                 codigo = calcularRuta(nodo.getDerecho(), caracter, codigo);
            }
        }
        return codigo;
    }
    
}
