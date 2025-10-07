/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author polares
 */
public class ControladorVentanas extends ControladorBase {
    
    public ControladorVentanas() {
    }
    
    //Llenar una tabla, mostrar una grafica
    
    public void llenarVentanaAdmin(String nombre) {
        this.getControladorPrincipal().getVista().getInicioAdmin().llenarDatos(nombre);
    }
    
    public void llenarVentanaVendedor(String nombre, String ventas) {
        this.getControladorPrincipal().getVista().getInicioVendedor().llenarDatos(nombre, ventas);
    }
    
    public void llenarVentanaCliente(String nombre, String cumpleanos) {
        this.getControladorPrincipal().getVista().getInicioCliente().llenarDatos(nombre, cumpleanos);
    }
    
    public void limpiarFieldsLogin() {
        this.getControladorPrincipal().getVista().getVentanaLogin().limpiarFields();
    }
}
