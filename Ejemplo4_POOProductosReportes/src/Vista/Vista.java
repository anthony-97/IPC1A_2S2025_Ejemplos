/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Datos.Inventario;
import Datos.Producto;
import Reportes.Reportes;
import java.util.Scanner;

/**
 *
 * @author polares
 */
public class Vista {
    
    private Inventario inventario;

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    public void mostrarMenu() {
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
                    this.crearProducto(contenedorEntradas);
                    break;
                case 2:
                    this.generarReportes(this.inventario.getProductos());
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
    
    private void crearProducto(Scanner sc) {
        System.out.println("Id del producto");
        int id = sc.nextInt();
        sc.nextLine(); //Para consumir el salto de línea pendiente
        
        System.out.println("Nombre del producto");
        String nombre = sc.nextLine();
        
        System.out.println("Precio del producto");
        Double precio = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Stock del producto");
        int stock = sc.nextInt();
        sc.nextLine();
        
        Producto producto = new Producto(id, nombre, precio, stock);
        this.inventario.agregarProducto(producto);
    }
    
    private void generarReportes(Producto[] arrayProductos) {
        System.out.println("Generando reportes");
        Reportes.generarReportePDF(arrayProductos);
        Reportes.generarReporteTxt(arrayProductos);
    }
    
}