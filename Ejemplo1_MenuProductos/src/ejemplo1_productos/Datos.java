/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo1_productos;

/**
 *
 * @author polares
 */
public class Datos {
    static final int MAX_PRODUCTOS = 100; //Maximo de productos -> tamaño de arreglo de personajes
    static final int MAX_PRESENTACIONES = 5; //Maximo de presentaciones -> tamaño de arreglo de habilidades

    static String[] nombres = new String[MAX_PRODUCTOS];
    static String[] marcas = new String[MAX_PRODUCTOS];
    static String[][] presentaciones = new String[MAX_PRODUCTOS][MAX_PRESENTACIONES];
    static int totalProductos = 0;
}
