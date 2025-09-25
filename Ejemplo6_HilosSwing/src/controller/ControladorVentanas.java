/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Arrays;
import model.Pokemon;

/**
 *
 * @author polares
 */
public class ControladorVentanas extends ControladorPrincipal {
    
    public ControladorVentanas() {
    }
    
    //Llenar una tabla, mostrar una grafica
    
    public void llenarPokemones(String contenido) {
        this.getControladorPrincipal().getVista().getVentanaPokemones().llenarPanel(contenido);
    }
    
}
