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
        //Nombre, ataque, vida, velocidad
        Pokemon pk1 = new Pokemon("Pikachu", 10, 35, 90); //0
        Pokemon pk2 = new Pokemon("Bulbasaur", 15, 45, 45); //1
        Pokemon pk3 = new Pokemon("Charmander", 20, 39, 65); //2
        Pokemon pk4 = new Pokemon("Swellow", 25, 60, 125); //3
        Pokemon pk5 = new Pokemon("Abra", 5, 25, 90);

        Pokemon[] pokemones = new Pokemon[] { pk1, pk2, pk3, pk4, pk5 };
        this.getControladorPrincipal().getModelo().setPokemones(pokemones);
    }

    Pokemon buscarPokemonPorId(String id) {
        Pokemon[] pokemones = this.getControladorPrincipal().getModelo().getPokemones();
        for(Pokemon poke: pokemones) {
            if(poke.getId().equals(id)) {
                return poke;
            }
        }
        return null;
    }
}
