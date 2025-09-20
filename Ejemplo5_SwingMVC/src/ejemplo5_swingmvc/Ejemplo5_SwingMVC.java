/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo5_swingmvc;

import controller.Controlador;
import model.Modelo;
import view.TipoVentana;
import view.Vista;

/**
 *
 * @author polares
 */
public class Ejemplo5_SwingMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        
        Controlador controlador = new Controlador(modelo, vista);
        modelo.setControlador(controlador); //El modelo tiene que saber quien lo controla
        
        controlador.crearCondicionesIniciales();
        controlador.mostrarVentana(TipoVentana.Ventana.VENTANA_POKEMONES); //La ventana inicial
    }
    
}
