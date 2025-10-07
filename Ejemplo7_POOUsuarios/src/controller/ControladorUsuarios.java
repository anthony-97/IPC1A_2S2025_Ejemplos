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
                this.getControladorPrincipal().getControladorVentanas().llenarVentanaAdmin(u.getNombre());
            } else if(u.getTipo() == 2) { //Es un vendedor
                Vendedor v = (Vendedor) u;
                this.getControladorPrincipal().mostrarVentana(TipoVentana.Ventana.INICIO_VENDEDOR);
                this.getControladorPrincipal().getControladorVentanas().llenarVentanaVendedor(v.getNombre(), Integer.toString(v.getVentasConfirmadas()));
            } else if(u.getTipo() == 3) { // Es un cliente
                Cliente c = (Cliente) u;
                this.getControladorPrincipal().mostrarVentana(TipoVentana.Ventana.INICIO_CLIENTE);
                this.getControladorPrincipal().getControladorVentanas().llenarVentanaCliente(c.getNombre(), c.getCumpleanos());
            }
        } else { //Credenciales incorrectas
            this.getControladorPrincipal().getVista().getVentanaLogin().mostrarError("Ocurrió un error, revisa tus credenciales");
        }
   }
}
