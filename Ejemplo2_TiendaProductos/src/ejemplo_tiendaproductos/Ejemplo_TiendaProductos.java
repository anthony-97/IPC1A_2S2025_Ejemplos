/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_tiendaproductos;

/**
 *
 * @author polares
 */
public class Ejemplo_TiendaProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] nombres = {"Laptop", "Mouse", "Teclado"};
        Double[] precios = { 5500.0, 150.0, 300.0 };
        int[] stock = { 5, 10, 8 };
        
        System.out.println("Inventario de productos");
        Inventario.listarProductos(nombres, precios, stock);
        
        //Caso válido: vender 2 laptops
        Inventario.venderProductoSinVerificar(0, 2, nombres, stock);

        //Caso inválido: vender más de lo disponible
        Inventario.venderProductoSinVerificar(1, 20, nombres, stock);

        //Caso inválido: índice fuera de rango
        //Inventario.venderProductoSinVerificar(5, 1, nombres, stock);
        
    }
    
}