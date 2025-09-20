/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Modelo;
import view.TipoVentana;
import view.VentanaPokemones;
import view.Vista;

/**
 *
 * @author polares
 */
public class Controlador {
    private Modelo modelo;
    private Vista vista;
    private ControladorVentanas controladorVentanas;
    private ControladorPokemones controladorPokemones;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.controladorVentanas = new ControladorVentanas();
        this.controladorPokemones = new ControladorPokemones();
    }
    
    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public ControladorVentanas getControladorVentanas() {
        return controladorVentanas;
    }

    public void setControladorVentanas(ControladorVentanas controladorVentanas) {
        this.controladorVentanas = controladorVentanas;
    }
    
    // --------------------------    Metodos generales  -----------------------------------
    
    public void crearCondicionesIniciales() {
        //controladorventanas -> este controlador te manda
        this.controladorVentanas.setControladorPrincipal(this); //Este objeto controlador
        this.controladorPokemones.setControladorPrincipal(this);
        this.controladorPokemones.generarPokemones();
        this.crearVentanas();
        
    }
    
    public void crearVentanas() { //Metodo que crea las ventanas y les setea el controlador
        this.vista.setVentanaPokemones(new VentanaPokemones());
        this.vista.getVentanaPokemones().setControlador(this); //Este objeto Controlador
    }
    
    public void mostrarVentana(TipoVentana.Ventana tipoVentana) {
        javax.swing.JFrame[] ventanas = {
            this.vista.getVentanaPokemones() //0
        };

        //Se ocultan todas las ventanas
        for (javax.swing.JFrame ventana : ventanas) {
            ventana.setVisible(false);
        }
        
        switch (tipoVentana.getIndex()) {
            case 1 -> this.vista.getVentanaPokemones().setVisible(true);
        }
    }
    
}
