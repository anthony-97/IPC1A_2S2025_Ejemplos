/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class Administrador extends Usuario {

    public Administrador(String codigo, String nombre, String genero, String contrasena) {
        super(codigo, nombre, genero, contrasena);
        this.tipo = 1; //1 para administradores
    }
   
}
