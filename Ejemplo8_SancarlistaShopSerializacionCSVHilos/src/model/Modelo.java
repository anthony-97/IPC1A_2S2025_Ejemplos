/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Controlador;
import java.io.Serializable;

/**
 *
 * @author polares
 */
public class Modelo implements Serializable {
    private Usuario[] usuarios; //Lista de todos los usuarios
    private transient Controlador controlador;
    private transient ModeloUsuarios modeloUsuarios;
    private transient ModeloMonitores modeloMonitores;
    private transient Usuario usuarioActual;
    static int contadorUsuarios = 0;
    
    public Modelo() {
        this.usuarios = new Usuario[200];
        this.modeloUsuarios = new ModeloUsuarios();
        this.modeloMonitores = new ModeloMonitores();
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }
    
    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public ModeloUsuarios getModeloUsuarios() {
        return modeloUsuarios;
    }

    public void setModeloUsuarios(ModeloUsuarios modeloUsuarios) {
        this.modeloUsuarios = modeloUsuarios;
    }

    public ModeloMonitores getModeloMonitores() {
        return modeloMonitores;
    }

    public void setModeloMonitores(ModeloMonitores modeloMonitores) {
        this.modeloMonitores = modeloMonitores;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public static int getContadorUsuarios() {
        return contadorUsuarios;
    }

    public static void setContadorUsuarios(int contadorUsuarios) {
        Modelo.contadorUsuarios = contadorUsuarios;
    }
       
}
