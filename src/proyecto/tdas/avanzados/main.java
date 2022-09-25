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
                    int opcionArboles = menuArboles();
                    while(opcionArboles != 3) {
                        switch(opcionArboles){
                            case 1 -> { //Codificador
                                
                                System.out.println("Ingrese el nombre del Archivo de texto: ");
                                String archivo = sc.next(), texto = "";
                                try {
                                    //Lee archivo
                                    BufferedReader bf = new BufferedReader(new FileReader("./Textos/" + archivo + ".txt"));
                                    String bfRead; 
                                    while((bfRead = bf.readLine()) != null) {
                                        texto += bfRead;
                                    }
                                
                                    String codigo = arbol.codificarTexto(texto);
                                    
                                    //Crea archivo binario
                                    File binario = new File("./Arboles/" + archivo + ".hm");
                                    FileOutputStream fos = new FileOutputStream(binario);
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(arbol);
                                    oos.close();
                                    fos.close();
                                    
                                    //Crea y escribe archivo
                                    File textoCodificado = new File("./Archivos Codificados/codigo" + archivo + ".txt");
                                    FileWriter fw = new FileWriter(textoCodificado);
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    bw.write(codigo);
                                    bw.flush();
                                    fw.close();
                                    bw.close();
                                    System.out.println("Codigo de Huffman del archivo: " + archivo);
                                    System.out.println("Almacenado en: " + textoCodificado.getAbsolutePath());
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
                                    BufferedReader bf = new BufferedReader(new FileReader("./Archivos Codificados/" + archivo + ".txt"));
                                    String bfRead; 
                                    while((bfRead = bf.readLine()) != null) {
                                        codigo += bfRead;
                                    }
                                    //Lee el archivo con el arbol
                                    File arbolAlmacenado = new File("./Arboles/" + archivoArbol + ".hm");
                                    FileInputStream fis = new FileInputStream(arbolAlmacenado);
                                    ObjectInputStream ois;
                                    while(fis.available()>0) {
                                        ois = new ObjectInputStream(fis);
                                    }
                                } catch (IOException e) {
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
                    int opcionGrafos = menuGrafos();
                    while(opcionGrafos != 4) {
                        switch(opcionGrafos) {
                            case 1 -> { //Leer grafo de archivo
                                break;
                            }
                            case 2 -> { //Prim
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
