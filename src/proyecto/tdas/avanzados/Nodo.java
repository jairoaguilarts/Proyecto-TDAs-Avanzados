package proyecto.tdas.avanzados;

import java.io.*;
import java.util.*;

/*

Utilizamos 0 para los hijos izquierdos y 1 para los hijos derechos

*/

public class Nodo implements Serializable {
    
    private char caracter = '\u0000';
    private int frecuencia, localizador;
    private String codigoHuffman = "";
    
    private final LinkedList<Nodo> listaAdyacente = new LinkedList<Nodo>();
    
    public Nodo() {
        listaAdyacente.add(0, null);
        listaAdyacente.add(1, null);
    }

    public Nodo(char caracter, int frecuencia, int localizador) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        this.localizador = localizador;
        listaAdyacente.add(0, null);
        listaAdyacente.add(1, null);
    }

    public char getCaracter() {
        return caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public int getLocalizador() {
        return localizador;
    }

    public String getCodigoHuffman() {
        return codigoHuffman;
    }

    public LinkedList<Nodo> getListaAdyacente() {
        return listaAdyacente;
    }

    @Override
    public String toString() {
        return Character.toString(caracter);
    }
    
    
    
}
