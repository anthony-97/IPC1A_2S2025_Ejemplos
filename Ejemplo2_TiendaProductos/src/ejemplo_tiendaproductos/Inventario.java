/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_tiendaproductos;

/**
 *
 * @author polares
 */
public class Inventario {
    
    public static void listarProductos(String[] nombres, Double[] precios, int[] stock) {
        for(int i = 0; i<nombres.length; i++) {
            System.out.println(nombres[i] + " - Q. " + precios[i] + " - " + stock[i]);
        }
    }
    
    public static void venderProducto(int index, int cantidad, String[] nombres, int[] stock) throws Exception {
        if(index < 0 || index >= nombres.length) {
            throw new ArrayIndexOutOfBoundsException("El índice " + index + " no existe.");
        }
        if(cantidad > stock[index]) {
            throw new Exception("No hay suficiente stock de " + nombres[index] + " para vender " + cantidad);
        }
        
        stock[index] -= cantidad;
        
        System.out.println("Venta realizada de " + cantidad + " unidades de " + nombres[index]);
    }
    
    public static void venderProductoSinVerificar(int index, int cantidad, String[] nombres, int[] stock) {
        stock[index] -= cantidad;
        System.out.println("Venta realizada de " + cantidad + " unidades de " + nombres[index]);
    }
}