package proyecto.tdas.avanzados;

public class Vertice {
    
    private int valor;

    public Vertice() {}

    public Vertice(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  Integer.toString(valor);
    }
    
}
