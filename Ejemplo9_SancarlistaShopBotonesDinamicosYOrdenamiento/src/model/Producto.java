/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author polares
 */
public class Producto implements Serializable {
    private String codigo;
    private String nombre;
    private String categoria;
    private Object atributoUnico;
    private Double precio;

    public Producto(String codigo, String nombre, String categoria, Object atributoUnico, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.atributoUnico = atributoUnico;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Object getAtributoUnico() {
        return atributoUnico;
    }

    public void setAtributoUnico(Object atributoUnico) {
        this.atributoUnico = atributoUnico;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria + ", atributoUnico=" + atributoUnico + ", precio=" + precio + '}';
    }
    
}
