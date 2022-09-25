package proyecto.tdas.avanzados;
import java.io.*;
import java.util.*;

public class NodoGrafo {
    private String etiqueta;
    private int valor;
    
    
    public NodoGrafo(){
        etiqueta = null;
        valor = 0;
    }
    
    public NodoGrafo(String etiqueta, int valor){
        this.etiqueta = etiqueta;
        this.valor = valor;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
