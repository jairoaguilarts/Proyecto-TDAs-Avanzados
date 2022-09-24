package proyecto.tdas.avanzados;

import java.util.LinkedList;

public class ArbolHuffman {
    
    private boolean banderaHoja = false;
    
    private NodoHuffman raiz = null;
    private final LinkedList caracteresDiferentes = new LinkedList();
    private final LinkedList frecuenciaCaracteres = new LinkedList();
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
        //falta calcular codigos
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
            nodos.remove(minimaFrecuencia1);
            for(int i = 0; i < nodos.size(); i++) { //Nodo con menor frecuencia 2
                if(nodos.get(i).getFrecuencia() < frecuencia) {
                    minimaFrecuencia2 = i;
                }
            }
            n2 = nodos.get(minimaFrecuencia2);
            nodos.remove(minimaFrecuencia2);
            NodoHuffman newNode = new NodoHuffman((n1.getFrecuencia() + n2.getFrecuencia()), n1, n2);
            nodos.add(newNode);
        }
    }
    
    private void calcularCodigos() { //revisar
        String codigo = "";
        for(int i = 0; i < caracteresDiferentes.size(); i++) {
            String cod = calcularCodigo(raiz.getIzquierdo(), true, codigo);
            
            
        }
        
    }
    
    private String calcularCodigo(NodoHuffman nodo, boolean izquierdo, String codigo) { //revisar
        if(nodo.esHoja()) {
            banderaHoja = true;
            return Character.toString(nodo.getCaracter());
        }
        if(!banderaHoja) {
            codigo += calcularCodigo(nodo.getIzquierdo(), true, codigo);
        }
        if(!banderaHoja) {
            codigo += calcularCodigo(nodo.getDerecho(), false, codigo);
        }
        if(izquierdo) {
            return "0";
        } else {
            return "1";
        }
    }
    
    private String invertirCodigo(String codigo) {
        StringBuilder sb = new StringBuilder(codigo);
        String inverso = sb.reverse().toString();
        return inverso;
    }
    
}
