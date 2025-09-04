/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo1_productos;

import java.util.Scanner;

/**
 *
 * @author polares
 */
public class GestorProductos {
    
    static Scanner sc = new Scanner(System.in);

    public static void agregarProducto() {
        if (Datos.totalProductos >= Datos.MAX_PRODUCTOS) {
            System.out.println("No se pueden agregar más personajes.");
            return;
        }

        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine().trim(); //Quitándole los espacios en blanco del inicio y del final al nombre recibido
        if (buscarPorNombre(nombre) != -1) {
            System.out.println("Error: El nombre ya existe.");
            return;
        }
        
        if (nombre.isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese marca del producto: ");
        String marca = sc.nextLine().trim();
        if (marca.isEmpty()) {
            System.out.println("Marca no puede estar vacía.");
            return;
        }

        String[] presentaciones = new String[Datos.MAX_PRESENTACIONES];
        System.out.println("Ingrese hasta 5 presentaciones (deje vacío para terminar):");
        for (int i = 0; i < Datos.MAX_PRESENTACIONES; i++) {
            System.out.print("Presentación" + (i + 1) + ": ");
            String present = sc.nextLine().trim();
            if (present.isEmpty()) break;
            presentaciones[i] = present; //
        }

        //Se guarda al producto
        Datos.nombres[Datos.totalProductos] = nombre;
        Datos.marcas[Datos.totalProductos] = marca;
        for (int i = 0; i < Datos.MAX_PRESENTACIONES; i++) {
            Datos.presentaciones[Datos.totalProductos][i] = presentaciones[i];
        }

        Datos.totalProductos++;
        System.out.println("Producto agregado con ID: " + Datos.totalProductos);
    }

    public static int buscarPorNombre(String nombre) {
        for (int i = 0; i < Datos.totalProductos; i++) {
            if (Datos.nombres[i].equals(nombre)) {
                return i;
            }
        }
        return -1; //No lo encontró
    }

    public static void mostrarProducto(int index) {
        System.out.println("ID: " + (index + 1));
        System.out.println("Nombre: " + Datos.nombres[index]);
        System.out.println("Marca: " + Datos.marcas[index]);
        System.out.print("Presentaciones: ");
        for (int i = 0; i < Datos.MAX_PRESENTACIONES; i++) {
            if (Datos.presentaciones[index][i] != null && !Datos.presentaciones[index][i].isEmpty()) {
                /*Si el valor del iterador es menor al ultimo indice posible, es decir
                  Datos.MAX_PRESENTACIONES - 1, en este caso 4
                  No es el ultimo elemento del array y entonces se concatena una coma*/
                if(i < Datos.MAX_PRESENTACIONES - 1) {
                    System.out.print(Datos.presentaciones[index][i] + " , ");
                } else { /* Si el iterador es el último elemento, no se concatena la coma */
                    System.out.print(Datos.presentaciones[index][i]);
                }
            }
        }
    }

    public static void listarProductos() {
        if (Datos.totalProductos == 0) {
            System.out.println("No hay productos.");
            return;
        }
        for (int i = 0; i < Datos.totalProductos; i++) {
            System.out.println("-------------------------");
            mostrarProducto(i);
        }
    }
}