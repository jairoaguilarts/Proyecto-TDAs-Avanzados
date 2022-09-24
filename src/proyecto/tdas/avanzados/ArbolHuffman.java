package proyecto.tdas.avanzados;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ArbolHuffman {
    
    private NodoHuffman raiz;
    private StringBuilder codigo;
    private PriorityQueue<NodoHuffman> cola;
    
    ArbolHuffman() {}
    
    void codificarTexto(String texto) {
        boolean textoVacio = false;
        if(texto == null || texto.length() == 0) {
            textoVacio = true;
        }
        if(!textoVacio) {
            Map<Character, Integer> frecuencias = new HashMap<>();
            for (char c: texto.toCharArray()) { //Cuenta la frecuencia de los chars y los almacena en el mapa
                frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
            }
            this.cola = new PriorityQueue<>(Comparator.comparingInt(l -> l.getFrecuencia()));
            for (var entry: frecuencias.entrySet()) { //Crea nodo hoja con el caracter y lo asigna a la cola
                cola.add(new NodoHuffman(entry.getKey(), entry.getValue()));
            }
            while (cola.size() != 1) {
                NodoHuffman left = cola.poll();
                NodoHuffman right = cola.poll();
                //Crea un nuevo nodo con la suma de las frecuencias y con hijos
                int suma = left.getFrecuencia() + right.getFrecuencia();
                cola.add(new NodoHuffman('\u0000', suma, left, right));
            }            
            this.raiz = cola.peek();
            //Almacena los codigos de los caracteres en un mapa
            Map<Character, String> huffmanCode = new HashMap<>();
            codificarNodos(raiz, "", huffmanCode);
            this.codigo = new StringBuilder(); //Arma el codigo para el texto
            for (char c: texto.toCharArray()) {
                codigo.append(huffmanCode.get(c));
            }
        }
    }
    
    public static void codificarNodos(NodoHuffman raiz, String str, Map<Character, String> huffmanCode) {
        if (raiz == null) {
            return;
        }
        
        if (raiz.esHoja()) {
            huffmanCode.put(raiz.getCaracter(), str.length() > 0 ? str : "1");
        }
        codificarNodos(raiz.getNodoDerecho(), str + '0', huffmanCode);
        codificarNodos(raiz.getNodoIzquierdo(), str + '1', huffmanCode);
        
    }
    
    public void decodificarCodigo() {
        if (raiz.esHoja()) {
            int frecuencia = raiz.getFrecuencia();
            while (frecuencia-- > 0) {
                System.out.print(raiz.getCaracter());
            }
        } else {
            int index = -1;
            while (index < codigo.length() - 1) {
                index = decodificarNodos(raiz, index, codigo);
            }
        }
    }
    
    public static int decodificarNodos(NodoHuffman raiz, int index, StringBuilder codigo) {
        if (raiz == null) {
            return index;
        }
        if (raiz.esHoja()) {
            System.out.print(raiz.getCaracter());
            return index;
        }
        index++;
        raiz = (codigo.charAt(index) == '0') ? raiz.getNodoIzquierdo() : raiz.getNodoDerecho();
        index = decodificarNodos(raiz, index, codigo);
        return index;
    }
    
}
