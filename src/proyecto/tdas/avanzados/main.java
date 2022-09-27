package proyecto.tdas.avanzados;

import java.util.Scanner;
import java.io.*;

public class main {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcionPrincipal = menuPrincipal();
        while(opcionPrincipal != 3) {
            switch(opcionPrincipal) {
                case 1 -> {
                    ArbolHuffman arbol = null;
                    int opcionArboles = menuArboles();
                    while(opcionArboles != 3) {
                        switch(opcionArboles){
                            case 1 -> { //Codificador
                                arbol = new ArbolHuffman();
                                System.out.println("Ingrese el nombre del Archivo de texto: ");
                                String archivo = sc.next(), texto = "";
                                try {
                                    //Lee archivo
                                    BufferedReader bf = new BufferedReader(new FileReader("./Carpeta Arboles/Textos/" + archivo + ".txt"));
                                    String bfRead; 
                                    while((bfRead = bf.readLine()) != null) {
                                        texto += bfRead;
                                    }
                                    String codigo = arbol.codificar(texto);
                                    
                                    //Crea archivo binario
                                    File binario = new File("./Carpeta Arboles/Binarios/" + archivo + ".hm");
                                    FileOutputStream fos = new FileOutputStream(binario);
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(arbol);
                                    oos.close();
                                    fos.close();
                                    
                                    //Crea y escribe archivo
                                    File textoCodificado = new File("./Carpeta Arboles/Archivos Codificados/codigoHM" + archivo + ".txt");
                                    FileWriter fw = new FileWriter(textoCodificado);
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    bw.write(codigo);
                                    bw.flush();
                                    fw.close();
                                    bw.close();
                                    System.out.println("Codigo almacenado en: " + textoCodificado.getAbsolutePath());
                                    System.out.println("Arbol almacenado en: " + binario.getAbsolutePath());
                                } catch (IOException e) {
                                    System.out.println("Error: " + e.getMessage());
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 2 -> { //Decodificador
                                System.out.println("Ingrese el nombre del archivo codificado: ");
                                String archivo = sc.next(), codigo = "";
                                System.out.println("Ingrese el nombre del archivo con el arbol: ");
                                String archivoArbol = sc.next();
                                try {
                                    //Lee el archivo con el codigo
                                    BufferedReader bf = new BufferedReader(new FileReader("./Carpeta Arboles/Archivos Codificados/" + archivo + ".txt"));
                                    String bfRead; 
                                    while((bfRead = bf.readLine()) != null) {
                                        codigo += bfRead;
                                    }
                                    //Lee el archivo con el arbol
                                    File arbolAlmacenado = new File("./Carpeta Arboles/Binarios/" + archivoArbol + ".hm");
                                    FileInputStream fis = new FileInputStream(arbolAlmacenado);
                                    ObjectInputStream ois;
                                    while(fis.available() > 0) {
                                        ois = new ObjectInputStream(fis);
                                        arbol = (ArbolHuffman)ois.readObject();
                                    }
                                    String texto = arbol.decodificar(codigo);
                                    System.out.println("Mensaje obtenido: " + texto);
                                } catch (IOException | ClassNotFoundException e) {
                                    System.out.println("Error: " + e.getMessage());
                                    e.printStackTrace();
                                }
                                break;
                            }
                            default -> {
                                System.out.println("Opcion Invalida");
                            }
                        }
                        opcionArboles = menuArboles();
                    }
                    break;
                }
                case 2 -> {
                    GrafoPrim grafoPrim = new GrafoPrim();
                    int opcionGrafos = menuGrafos();
                    while(opcionGrafos != 4) {
                        switch(opcionGrafos) {
                            case 1 -> { //Leer grafo de archivo
                                System.out.println("Ingrese el nombre del archivo con el grafo: ");
                                String archivo = sc.next();
                                try {
                                    //Lee archivo
                                    BufferedReader bf = new BufferedReader(new FileReader("./Carpeta Grafos/" + archivo + ".txt"));
                                    String linea; 
                                    int iteracion = 0, size = 0, fila = 0;
                                    Vertice matriz[][] = null;
                                    while((linea = bf.readLine()) != null) {
                                        if(iteracion++ == 0) {
                                            size = Integer.parseInt(linea);
                                            matriz = new Vertice[size][size];
                                        } else {
                                            String arreglo[] = linea.split(" ");
                                            Vertice arregloVertices[] = new Vertice[size];
                                            for(int i = 0;i < arreglo.length; i++) {
                                                arregloVertices[i] = new Vertice(Integer.parseInt(arreglo[i]));
                                            }
                                            matriz[fila++] = arregloVertices;
                                        }
                                    }
                                    grafoPrim.setMatrizAdyacencia(matriz);
                                    grafoPrim.setSize(size);
                                } catch (IOException e) {
                                    System.out.println("Error: " + e.getMessage());
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case 2 -> { //Prim
                                grafoPrim.algoritmoPrim();
                                break;
                            }
                            case 3 -> { //Floyd
                                break;
                            }
                            default -> {
                                System.out.println("Opcion invalida");
                            }
                        }
                        opcionGrafos = menuGrafos();
                    }
                    break;
                }
                default -> {
                    System.out.println("Opcion Invalida");
                }
            }
            opcionPrincipal = menuPrincipal();
        }
    }
    
    private static int menuPrincipal() {
        System.out.println("====MENU PRINCIPAL");
        System.out.println("1) Algoritmos sobre Arboles");
        System.out.println("2) Algoritmos sobre Grafos");
        System.out.println("3) Salir");
        System.out.println("Ingrese su opcion: ");
        int opcion = sc.nextInt();
        return opcion;
    }
    
    private static int menuArboles() {
        System.out.println("====MENU ARBOLES====");
        System.out.println("1) Codificador de Huffman");
        System.out.println("2) Decodificador de Huffman");
        System.out.println("3) Regresar al menu principal");
        System.out.println("Ingrese su opcion: ");
        int opcion = sc.nextInt();
        return opcion;
    }
    
    private static int menuGrafos() {
        System.out.println("====MENU GRAFOS====");
        System.out.println("1) Leer grafo de un archivo");
        System.out.println("2) Prim");
        System.out.println("3) Floyd");
        System.out.println("4) Regresar al menu principal");
        System.out.println("Ingrese una opcion: ");
        int opcion = sc.nextInt();
        return opcion;
    }
    
}
