/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Usuario;
import model.Vendedor;

/**
 *
 * @author polares
 */
public class ControladorVentanas extends ControladorBase {
    
    public ControladorVentanas() {
    }
    
    public void llenarVentanaAdmin() {
        this.llenarTablaVendedores();
    }
    
    //Llenar una tabla, mostrar una grafica
    public void llenarTablaVendedores() {
        Usuario[] usuarios = this.getControladorPrincipal().getModelo().getUsuarios();
        Vendedor[] vendedores = new Vendedor[50];
        int contador = 0;
        for(Usuario u: usuarios) {
            if(u != null && u.getTipo() == 2) {
                vendedores[contador] = (Vendedor) u;
                contador++;
            }
        }
        this.getControladorPrincipal().getVista().getInicioAdmin().llenarTablaVendedores(vendedores, contador);
    }

    public void llenarVentanaCliente(String nombre, String cumpleanos) {
        this.getControladorPrincipal().getVista().getInicioCliente().llenarDatos(nombre, cumpleanos);
    }
    
    public void llenarVentanaVendedor(String nombre, int ventasConf) {
        String ventasConfirmadas = Integer.toString(ventasConf);
        this.getControladorPrincipal().getVista().getInicioVendedor().llenarDatos(nombre, ventasConfirmadas);
    }
    public void limpiarFieldsLogin() {
        this.getControladorPrincipal().getVista().getVentanaLogin().limpiarFields();
    }
    
    public void limpiarFieldsRegistroVendedor() {
        this.getControladorPrincipal().getVista().getRegistroVendedor().limpiarFields();
    }
}
