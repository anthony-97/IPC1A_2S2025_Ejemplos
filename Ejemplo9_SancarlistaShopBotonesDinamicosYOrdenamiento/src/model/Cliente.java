/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class Cliente extends Usuario {
    private String cumpleanos;
    
    public Cliente(String codigo, String nombre, String genero, String contrasena, String cumpleanos) {
        super(codigo, nombre, genero, contrasena);
        this.tipo = 3; //3 para cliente
        this.cumpleanos = cumpleanos;
    }

    public String getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(String cumpleanos) {
        this.cumpleanos = cumpleanos;
    }
    
}
