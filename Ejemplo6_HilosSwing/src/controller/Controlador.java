/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Modelo;
import model.Pokemon;
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
    
    public void iniciarBatalla(String id1, String id2) {
        Pokemon p1 = this.controladorPokemones.buscarPokemonPorId(id1);
        Pokemon p2 = this.controladorPokemones.buscarPokemonPorId(id2);

        String encabezado = "\t------------------------------------------------------------------------\n" 
                            + "\t" + p1.getNombre() + "\t vrs \t" + p2.getNombre() + "\n"
                            + "\t" + p1.getVida() + "\t\t" + p2.getVida() + "\n"
                            + "\t----------------------------------------------------------------------\n";
        this.controladorVentanas.llenarPokemones(encabezado);

        if(p1.getVida() <= 0) {
            this.controladorVentanas.llenarPokemones("Pokemon " + p1.getNombre() + " ya no tiene vida");
            return;
        } else if(p2.getVida() <= 0) {
            this.controladorVentanas.llenarPokemones("Pokemon " + p2.getNombre() + " ya no tiene vida");
            return;
        }

        //Se resetea la batalla
        HiloBatalla.resetearBatalla();

        HiloBatalla hiloBatalla1 = new HiloBatalla(p1, p2);
        hiloBatalla1.setControladorPrincipal(this);
        HiloBatalla hiloBatalla2 = new HiloBatalla(p2, p1);
        hiloBatalla2.setControladorPrincipal(this);

        //Creación de los dos hilos
        Thread hilo1 = new Thread(hiloBatalla1);
        Thread hilo2 = new Thread(hiloBatalla2);

        //Se inician los hilos
        hilo1.start();
        hilo2.start();
    }
    
}
