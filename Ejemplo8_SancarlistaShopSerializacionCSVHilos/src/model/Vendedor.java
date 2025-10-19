/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class Vendedor extends Usuario {
    private int ventasConfirmadas;

    public Vendedor(String codigo, String nombre, String genero, String contrasena) {
        super(codigo, nombre, genero, contrasena);
        this.tipo = 2; //2 para vendedores
        this.ventasConfirmadas = 0;
    }
    
    //Polimorfismo -> Sobrecarga de constructores
    public Vendedor(String codigo, String nombre, String genero, String contrasena, int ventasConfirmadas) {
        super(codigo, nombre, genero, contrasena);
        this.tipo = 2; //2 para vendedores
        this.ventasConfirmadas = ventasConfirmadas;
    }

    public int getVentasConfirmadas() {
        return ventasConfirmadas;
    }

    public void setVentasConfirmadas(int ventasConfirmadas) {
        this.ventasConfirmadas = ventasConfirmadas;
    }
   
}
