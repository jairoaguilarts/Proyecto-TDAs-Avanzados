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

    public Nodo(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
        listaAdyacente.add(0, null);
        listaAdyacente.add(1, null);
    }
    public Nodo(int frecuencia, Nodo izquierdo, Nodo derecho) {
        this.frecuencia = frecuencia;
        listaAdyacente.add(0, izquierdo);
        listaAdyacente.add(1, derecho);
    }

    public char getCaracter() {
        return caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }
    
    public void aumentarFrecuencia() {
        this.frecuencia++;
    }

    public int getLocalizador() {
        return localizador;
    }
    
    public void setCodigoHuffman(String codigoHuffman) {
        this.codigoHuffman = codigoHuffman;
    }

    public String getCodigoHuffman() {
        return codigoHuffman;
    }

    public LinkedList<Nodo> getListaAdyacente() {
        return listaAdyacente;
    }
    
    public void setIzquierdo(Nodo izquierdo) {
        listaAdyacente.set(0, izquierdo);
    }
    
    public Nodo getIzquierdo() {
        return listaAdyacente.get(0);
    }
    
    public void setDerecho(Nodo derecho) {
        listaAdyacente.set(1, derecho);
    }
    
    public Nodo getDerecho() {
        return listaAdyacente.get(1);
    }
    
    public boolean esHoja() {
        return (listaAdyacente.get(0) == null) && (listaAdyacente.get(1) == null);
    }

    @Override
    public String toString() {
        return Character.toString(caracter);
    }
    
}
