/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import view.*;

/**
 *
 * @author polares
 */
public class ControladorUsuarios extends ControladorBase {
    
    public void iniciarSesion(String codigo, String contrasena) {
       Usuario u = this.getControladorPrincipal().getModelo().getModeloUsuarios().iniciarSesion(codigo, contrasena);
       if(u != null) { //Sí se inicio sesion
            if(u.getTipo() == 1) { //Es un admin
                this.getControladorPrincipal().mostrarVentana(TipoVentana.Ventana.INICIO_ADMIN);
                this.getControladorPrincipal().getControladorVentanas().llenarVentanaAdmin();
            } else if(u.getTipo() == 2) { //Es un vendedor
                Vendedor v = (Vendedor) u;
                this.getControladorPrincipal().mostrarVentana(TipoVentana.Ventana.INICIO_VENDEDOR);
                this.getControladorPrincipal().getControladorVentanas().llenarVentanaVendedor(v.getNombre(), v.getVentasConfirmadas());
            } else if(u.getTipo() == 3) { // Es un cliente
                Cliente c = (Cliente) u;
                this.getControladorPrincipal().mostrarVentana(TipoVentana.Ventana.INICIO_CLIENTE);
                this.getControladorPrincipal().getControladorVentanas().llenarVentanaCliente(c.getNombre(), c.getCumpleanos());
            }
        } else { //Credenciales incorrectas
            this.getControladorPrincipal().getVista().getVentanaLogin().mostrarError("Ocurrió un error, revisa tus credenciales");
        }
    }
   
    public void crearAdmin() {
        Administrador admin = new Administrador("202001923", "Anthony", "M", "admin");
        this.getControladorPrincipal().getModelo().getUsuarios()[0] = admin;
        Modelo.setContadorUsuarios(Modelo.getContadorUsuarios()+1); //Aumenta el contador en 1
    }
   
    public boolean crearVendedor(String codigo, String nombre, String genero, String contrasena) {
       Vendedor vendedor = new Vendedor(codigo, nombre, genero, contrasena);
       boolean creado = this.getControladorPrincipal().getModelo().getModeloUsuarios().crearVendedor(vendedor);
       return creado;
    }
    
    public void cargarVendedor(String codigo, String nombre, String genero, String contrasena, String ventas) {
        int ventasConfirmadas = 0;
        try {
            ventasConfirmadas = Integer.parseInt(ventas); 
        } catch (NumberFormatException e) {
            System.out.println("Error al parsear ventas: " + ventas);
        }
        Vendedor vendedor = new Vendedor(codigo, nombre, genero, contrasena, ventasConfirmadas);
        this.getControladorPrincipal().getModelo().getModeloUsuarios().crearVendedor(vendedor);
    }
    
    public void cargarVendedoresDesdeCSV(String csv) {
        String[] lineas = csv.split("\n");
        int indice = 0;
        for(String linea : lineas) {
            if(linea.trim().isEmpty()) continue;
            if(indice == 0) { indice++; continue; } //Se salta la primera línea
            String[] campos = linea.split(",");
            if(campos.length == 5) { 
                cargarVendedor(campos[0], campos[1], campos[2], campos[3], campos[4]);
            }
        }
    }
   
    public void cerrarSesion() {
        this.getControladorPrincipal().getModelo().getModeloUsuarios().cerrarSesion();
    }
}
