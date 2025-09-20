/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Pokemon;

/**
 *
 * @author polares
 */
public class ControladorPokemones extends ControladorPrincipal {
    
    public void generarPokemones() {
        Pokemon pk1 = new Pokemon("Pikachu", 10);
        Pokemon pk2 = new Pokemon("Bulbassur", 40);
        Pokemon pk3 = new Pokemon("Charmander", 5);
        Pokemon pk4 = new Pokemon("Swellow", 2);
        Pokemon pk5 = new Pokemon("Abra", 17);
        
        Pokemon[] pokemones = new Pokemon[] {pk1, pk2, pk3, pk4, pk5 };
        this.getControladorPrincipal().getModelo().setPokemones(pokemones);
    }
}
