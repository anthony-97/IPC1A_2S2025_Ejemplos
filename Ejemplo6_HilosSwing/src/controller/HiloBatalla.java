/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.Random;
import model.Pokemon;

/**
 *
 * @author polares
 */
public class HiloBatalla extends ControladorPrincipal implements Runnable {
    private Pokemon atacante;
    private Pokemon oponente;
    private static volatile boolean batallaEnCurso = true; //Variable compartida
    private static final Object lockBatalla = new Object(); //Lock para sincronización
    private Random random = new Random();
    
    public HiloBatalla(Pokemon atacante, Pokemon oponente) {
        this.atacante = atacante;
        this.oponente = oponente;
    }
    
    //Método para resetear la batalla
    public static void resetearBatalla() {
        batallaEnCurso = true;
    }
    
    public Pokemon getAtacante() {
        return atacante;
    }
    
    public void setAtacante(Pokemon atacante) {
        this.atacante = atacante;
    }
    
    public Pokemon getOponente() {
        return oponente;
    }
    
    public void setOponente(Pokemon oponente) {
        this.oponente = oponente;
    }
    
    public Random getRandom() {
        return random;
    }
    
    public void setRandom(Random random) {
        this.random = random;
    }
    
    @Override
    public void run() {
        try {
            while (batallaEnCurso) {
                //Se impide que dos hilos modifiquen la variable lockBatalla
                //evitando así, problemas de concurrencia, como datos inconsistentes
                synchronized (lockBatalla) {
                    //Se verifica si la batalla ya terminó
                    if (!batallaEnCurso || oponente.getVida() <= 0 || atacante.getVida() <= 0) {
                        break;
                    }
                    
                    //Si no, realizar el ataque
                    int vidaCalculada = Math.max(oponente.getVida() - atacante.getAtaque(), 0);
                    oponente.setVida(vidaCalculada);
                    
                    String cadenaAtaque = atacante.getNombre() + " ataca a " + oponente.getNombre()
                                       + " - Daño: " + atacante.getAtaque()
                                       + " | Vida restante de " + oponente.getNombre() + ": " + vidaCalculada;
                    
                    this.getControladorPrincipal().getControladorVentanas().llenarPokemones(cadenaAtaque);
                    
                    //Luego del ataque, se debe ver si el oponente ya no tiene vida
                    if (vidaCalculada <= 0) {
                        batallaEnCurso = false;
                        this.getControladorPrincipal().getControladorVentanas().llenarPokemones(oponente.getNombre() + " ha sido derrotado.");
                        this.getControladorPrincipal().getControladorVentanas().llenarPokemones("¡" + atacante.getNombre() + " gana la batalla!");
                        break;
                    }
                }
                
                //Luego de ejecutar, se espera afuera del bloque
                Thread.sleep(1000 / atacante.getVelocidad());
            }
        } catch (InterruptedException e) {
            System.out.println(atacante.getNombre() + " fue interrumpido.");
        }
    }
}
