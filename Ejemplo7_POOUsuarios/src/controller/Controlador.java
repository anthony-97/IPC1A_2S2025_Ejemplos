/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Administrador;
import model.*;
import view.TipoVentana;
import view.*;

/**
 *
 * @author polares
 */
public class Controlador {
    private Modelo modelo;
    private Vista vista;
    private ControladorVentanas controladorVentanas;
    private ControladorUsuarios controladorUsuarios;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.controladorVentanas = new ControladorVentanas();
        this.controladorUsuarios = new ControladorUsuarios();
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

    public ControladorUsuarios getControladorUsuarios() {
        return controladorUsuarios;
    }

    public void setControladorUsuarios(ControladorUsuarios controladorUsuarios) {
        this.controladorUsuarios = controladorUsuarios;
    }
    
    // --------------------------    Metodos generales  -----------------------------------
    public void crearCondicionesIniciales() {
        //controladorventanas -> este controlador te manda
        this.controladorVentanas.setControladorPrincipal(this); //Este objeto controlador
        this.controladorUsuarios.setControladorPrincipal(this);
        this.crearVentanas();
        //Se crean las condiciones iniciales en el modelo
        this.crearCondicionesInicialesModelo();
    }
    
    private void crearCondicionesInicialesModelo() {
        this.crearUsuarios();
        this.getModelo().getModeloUsuarios().setModeloPrincipal(this.modelo);
    }
    
    public void crearVentanas() { //Metodo que crea las ventanas y les setea el controlador
        this.vista.setVentanaLogin(new Login());
        this.vista.getVentanaLogin().setControlador(this); //Este objeto Controlador
        this.vista.setInicioAdmin(new InicioAdmin());
        this.vista.getInicioAdmin().setControlador(this);
        this.vista.setInicioVendedor(new InicioVendedor());
        this.vista.getInicioVendedor().setControlador(this);
        this.vista.setInicioCliente(new InicioCliente());
        this.vista.getInicioCliente().setControlador(this);
    }
    
    public void crearUsuarios() {
        Administrador admin = new Administrador("202001923", "Anthony", "M", "admin");
        Vendedor vendedor = new Vendedor("1234", "Dulce", "F", "vendedora", 20);
        Cliente cliente = new Cliente("5678", "Alvaro", "M", "cliente", "12/10/2000");
        this.getModelo().getUsuarios()[0] = admin;
        this.getModelo().getUsuarios()[1] = vendedor;
        this.getModelo().getUsuarios()[2] = cliente;
    }
   
    public void mostrarVentana(TipoVentana.Ventana tipoVentana) {
        javax.swing.JFrame[] ventanas = {
            this.vista.getVentanaLogin(), //0
            this.vista.getInicioAdmin(), //1
            this.vista.getInicioVendedor(), //2
            this.vista.getInicioCliente() //3
        };

        //Se ocultan todas las ventanas
        for (javax.swing.JFrame ventana : ventanas) {
            ventana.setVisible(false);
        }
        
        switch (tipoVentana.getIndex()) {
            case 1 -> this.vista.getVentanaLogin().setVisible(true);
            case 2 -> this.vista.getInicioAdmin().setVisible(true);
            case 3 -> this.vista.getInicioVendedor().setVisible(true);
            case 4 -> this.vista.getInicioCliente().setVisible(true);
        }
    }
    
}
