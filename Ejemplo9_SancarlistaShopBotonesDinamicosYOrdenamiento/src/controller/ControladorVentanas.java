/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Modelo;
import model.Producto;
import model.Usuario;
import model.Vendedor;

/**
 *
 * @author polares
 */
public class ControladorVentanas extends ControladorBase {
    
    public ControladorVentanas() {
    }
    
    //------------------Métodos para controlar a todas las ventanas-------------------------
     
    //  ---------------------------- Ventana Inicio Admin -------------------------------------
    public void llenarVentanaAdmin() {
        this.llenarTablaVendedores();
        this.llenarTablaProductos();
    }
    
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
    
    public void llenarTablaProductos() {
        int contadorProductos = Modelo.getContadorProductos();
        Producto[] productos = this.getControladorPrincipal().getModelo().getProductos();
        this.getControladorPrincipal().getVista().getInicioAdmin().llenarTablaProductos(productos, contadorProductos);
    }
        
    //  ---------------------------- Ventana Registro Vendedor -------------------------------------
    public void limpiarFieldsRegistroVendedor() {
        this.getControladorPrincipal().getVista().getRegistroVendedor().limpiarFields();
    }

    //  ---------------------------- Ventana Inicio Cliente -------------------------------------
    public void llenarVentanaCliente(String nombre, String cumpleanos) {
        this.getControladorPrincipal().getVista().getInicioCliente().llenarDatos(nombre, cumpleanos);
    }
    
    //  ---------------------------- Ventana Inicio Vendedor -------------------------------------
    public void llenarVentanaVendedor(String nombre, int ventasConf) {
        String ventasConfirmadas = Integer.toString(ventasConf);
        this.getControladorPrincipal().getVista().getInicioVendedor().llenarDatos(nombre, ventasConfirmadas);
    }
    
    //  ---------------------------- Ventana Login -------------------------------------
    public void limpiarFieldsLogin() {
        this.getControladorPrincipal().getVista().getVentanaLogin().limpiarFields();
    }
    
    //  ---------------------------- Ventana Producto -------------------------------------
    public void llenarVentanaProducto(String codigo) {
        String[] info = this.getControladorPrincipal().getModelo().getModeloProductos().obtenerInfoProducto(codigo);
        this.getControladorPrincipal().getVista().getVentanaProducto().llenarInfoProducto(info[0],info[1],info[2]);
    }
}
