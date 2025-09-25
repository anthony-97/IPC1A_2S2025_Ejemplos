/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class Pokemon {
    private String id;
    private String nombre;
    private int ataque;
    private int vida;
    private int velocidad;
    private static int contadorPokemones = 0;

    public Pokemon(String nombre, int ataque, int vida, int velocidad) {
        this.id = Integer.toString(contadorPokemones++);
        this.nombre = nombre;
        this.ataque = ataque;
        this.vida = vida;
        this.velocidad = velocidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "\nPokemon{" + "id=" + id + ", nombre=" + nombre + ", ataque=" + ataque + ", vida=" + vida + ", velocidad=" + velocidad + '}';
    }
   
}
