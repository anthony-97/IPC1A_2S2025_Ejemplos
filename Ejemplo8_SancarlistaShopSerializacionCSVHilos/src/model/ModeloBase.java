/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class ModeloBase {
    private Modelo modeloPrincipal;
    
    public Modelo getModeloPrincipal() {
        return this.modeloPrincipal;
    }
    
    public void setModeloPrincipal(Modelo modeloPrincipal) {
        this.modeloPrincipal = modeloPrincipal;
    }
    
    public void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
