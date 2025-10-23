/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Producto;

/**
 *
 * @author polares
 */
public class ControladorProductos extends ControladorBase {
    
    public boolean crearProducto(String codigo, String nombre, String categoria, Object atributoUnico, String precio) {
        Producto producto = new Producto(codigo, nombre, categoria, atributoUnico, Double.parseDouble(precio));
        boolean creado = this.getControladorPrincipal().getModelo().getModeloProductos().agregarProducto(producto);
        return creado;
    }
    
    public void cargarProductosDesdeCSV(String csv) {
        String[] lineas = csv.split("\n");
        int indice = 0;
        for(String linea : lineas) {
            if(linea.trim().isEmpty()) continue;
            if(indice == 0) { indice++; continue; } //Se salta la primera línea
            String[] campos = linea.split(",");
            if(campos.length == 5) { 
                //codigo, nombre, categoria, atributo_unico, precio
                crearProducto(campos[0], campos[1], campos[2], campos[3], campos[4]);
            }
        }
    }
}
