/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_poo.productos;

/**
 *
 * @author polares
 */
public class Ejemplo_POOProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Producto p1 = new Producto(1, "Salsa", 9.99, 20);
        Producto p2 = new Producto(2, "Pescado", 15.95, 100);
        Producto p3 = new Producto(3, "Sopa", 3.00, 100);
        
        Inventario.productos[0] = p1;
        Inventario.productos[1] = p2;
        Inventario.productos[2] = p3;
        
        Inventario.listarProductos();
    }
    
}