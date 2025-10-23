/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author polares
 */
public class ControladorMonitores extends ControladorBase {
    
    public void iniciarMonitoreo() {
        this.getControladorPrincipal().getVista().getVentanaMonitores().setVisible(true);
        this.iniciarMonitores();
    }
    
    //Se crea el hilo del primer monitor
    public void iniciarMonitores() {
        new Thread(() -> this.getControladorPrincipal().getModelo().getModeloMonitores().monitor1()).start();
    }
    
    public void actualizarMonitor1(String actualizacion) {
        this.getControladorPrincipal().getVista().getVentanaMonitores().actualizarMonitor(actualizacion);
    }
}
