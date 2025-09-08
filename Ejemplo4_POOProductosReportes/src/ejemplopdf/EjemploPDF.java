/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplopdf;

import Datos.Inventario;
import Vista.Vista;

/**
 *
 * @author polares
 */
public class EjemploPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Se crea un objeto de tipo inventario
        Inventario inventario = new Inventario();
        inventario.generarProductos(); //Se generan los productos del 1 al 9
        
        //Objeto de tipo vista, para generar el menú
        Vista vista = new Vista();
        vista.setInventario(inventario);
        vista.mostrarMenu();
    }
    
}