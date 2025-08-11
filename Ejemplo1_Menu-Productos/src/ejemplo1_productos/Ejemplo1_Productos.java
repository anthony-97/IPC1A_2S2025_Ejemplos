/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo1_productos;

import java.util.Scanner; //Importando Scanner de entrada

/**
 *
 * @author polares
 */
public class Ejemplo1_Productos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner contenedorEntradas = new Scanner(System.in);
        boolean salir = false;

        while (!salir) { //Mientras salir = false
            System.out.println("\nMenú:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = contenedorEntradas.nextInt();

            switch (opcion) {
                case 1:
                    GestorProductos.agregarProducto();
                    break;
                case 2:
                    GestorProductos.listarProductos();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
        contenedorEntradas.close(); //Se cierra el scanner de entradas
    }
   
}