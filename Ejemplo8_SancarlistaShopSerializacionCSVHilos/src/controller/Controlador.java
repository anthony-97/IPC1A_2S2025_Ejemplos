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
    private ControladorMonitores controladorMonitores;
    private ControladorSerializacion controladorSerializacion;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.controladorVentanas = new ControladorVentanas();
        this.controladorUsuarios = new ControladorUsuarios();
        this.controladorMonitores = new ControladorMonitores();
        this.controladorSerializacion = new ControladorSerializacion();
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

    public ControladorMonitores getControladorMonitores() {
        return controladorMonitores;
    }

    public void setControladorMonitores(ControladorMonitores controladorMonitores) {
        this.controladorMonitores = controladorMonitores;
    }

    public ControladorSerializacion getControladorSerializacion() {
        return controladorSerializacion;
    }

    public void setControladorSerializacion(ControladorSerializacion controladorSerializacion) {
        this.controladorSerializacion = controladorSerializacion;
    }
    
    // --------------------------    Metodos generales  -----------------------------------
    public void crearCondicionesIniciales() {
        //controladorventanas -> este controlador te manda
        this.controladorVentanas.setControladorPrincipal(this);
        this.controladorUsuarios.setControladorPrincipal(this);
        this.controladorMonitores.setControladorPrincipal(this);
        this.controladorSerializacion.setControladorPrincipal(this);
        this.asignarControladorVentanas();
        //Se crean las condiciones iniciales en el modelo
        this.crearCondicionesInicialesModelo();
        //Se inicia el monitoreo
        this.getControladorMonitores().iniciarMonitoreo();
    }
    
    private void crearCondicionesInicialesModelo() {
        Modelo modelo = this.controladorSerializacion.verificarSerializacion(); //Verifica si hay archivos para cargar
        if(modelo == null) {
            this.controladorUsuarios.crearAdmin();
        }
        this.getModelo().getModeloUsuarios().setModeloPrincipal(this.modelo);
        this.getModelo().getModeloMonitores().setModeloPrincipal(this.modelo);
    }
    
    public void asignarControladorVentanas() { //Metodo que setea el controlador a las ventanas
        this.vista.getVentanaLogin().setControlador(this); //Este objeto Controlador
        this.vista.getInicioAdmin().setControlador(this);
        this.vista.getInicioVendedor().setControlador(this);
        this.vista.getInicioCliente().setControlador(this);
        this.vista.getRegistroVendedor().setControlador(this);
    }
   
    public void mostrarVentana(TipoVentana.Ventana tipoVentana) {
        javax.swing.JFrame[] ventanas = {
            this.vista.getVentanaLogin(), 
            this.vista.getInicioAdmin(), 
            this.vista.getInicioVendedor(), 
            this.vista.getInicioCliente(), 
            this.vista.getRegistroVendedor()
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
            case 5 -> this.vista.getRegistroVendedor().setVisible(true);
        }
    }
    
}
