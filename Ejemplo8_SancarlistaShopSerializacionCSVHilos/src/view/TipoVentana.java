/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author polares
 */
public class TipoVentana {
    public enum Ventana {
        LOGIN(1),
        INICIO_ADMIN(2),
        INICIO_VENDEDOR(3),
        INICIO_CLIENTE(4),
        REGISTRO_VENDEDOR(5);
        
        private final int index;

        Ventana(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}
