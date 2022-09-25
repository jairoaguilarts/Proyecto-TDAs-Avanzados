package proyecto.tdas.avanzados;

public class Arista {
    
    private int coste;
    private Vertice vert1, vert2;

    public Arista() {}

    public Arista(int coste, Vertice vert1, Vertice vert2) {
        this.coste = coste;
        this.vert1 = vert1;
        this.vert2 = vert2;
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public Vertice getVert1() {
        return vert1;
    }

    public void setVert1(Vertice vert1) {
        this.vert1 = vert1;
    }

    public Vertice getVert2() {
        return vert2;
    }

    public void setVert2(Vertice vert2) {
        this.vert2 = vert2;
    }
    
}
