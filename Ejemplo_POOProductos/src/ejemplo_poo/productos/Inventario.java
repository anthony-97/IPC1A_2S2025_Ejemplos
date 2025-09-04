/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_poo.productos;

/**
 *
 * @author polares
 */
public class Inventario {
    public static Producto[] productos = new Producto[3];
    
    
    public static void listarProductos() {
        for(Producto producto: productos) {
            System.out.println(producto);
        }
    }
}
