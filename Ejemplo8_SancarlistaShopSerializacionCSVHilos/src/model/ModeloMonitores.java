/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author polares
 */
public class ModeloMonitores extends ModeloBase {
    
    public void monitor1() {
        while(true) {
            String actualizacion = "";
            Usuario usuarioLogueado = this.getModeloPrincipal().getUsuarioActual();
            String momentoActual = this.obtenerMomentoActual();
            if(usuarioLogueado != null) {
                actualizacion = "Usuarios Activos: 1 - Código: " + usuarioLogueado.getCodigo() + 
                        " - Última actividad: [ " + momentoActual + "]";
            } else {
                actualizacion = "Usuarios Activos: 0 - Código: ---- " + 
                        " - Última actualización: [ " + momentoActual + "]";
            }
            this.getModeloPrincipal().getControlador().getControladorMonitores().actualizarMonitor1(actualizacion);
            dormir(10000); //Duerme al hilo por 10 segundos
        }
    }
    
    private String obtenerMomentoActual() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return ahora.format(formato);
    }
    
}
