/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class ModeloProductos extends ModeloBase {
    
    public boolean agregarProducto(Producto producto) {
        int contador = this.getModeloPrincipal().contadorProductos;
        if (contador < this.getModeloPrincipal().getProductos().length) {
            this.getModeloPrincipal().getProductos()[contador] = producto;
            this.getModeloPrincipal().contadorProductos++; //Aumenta el contador de productos
            return true;
        } else {
            return false;
        }
    }
    
    public String[] obtenerInfoProducto(String codigo) {
        for(Producto producto : this.getModeloPrincipal().getProductos()) {
            if(producto != null) {
                if(producto.getCodigo().equals(codigo)) {
                    String mensaje = "";
                    if(producto.getCategoria().toLowerCase().equals("tecnologia")) {
                        mensaje = "Meses de garantía: ";
                    } else if(producto.getCategoria().toLowerCase().equals("alimento")) {
                        mensaje = "Fecha de caducidad: ";
                    } else {
                        mensaje = "Material del producto: ";
                    }
                    return new String[] { producto.getCategoria(), mensaje, producto.getAtributoUnico().toString() };
                }
            }
        }
        return null;
    }
    
    public Producto[] ordenarProductosPorPrecio() {
        Producto[] original = this.getModeloPrincipal().getProductos();
        int n = Modelo.contadorProductos;

        //Se crea una copia de los productos existentes
        Producto[] copia = new Producto[n];
        for (int i = 0; i < n; i++) {
            copia[i] = original[i];
        }

        //Temp  = 100
        //[20, 89, 10, 67, 100]
        
        //Se ordena la copia
        for (int i = 0; i < n - 1; i++) {
            boolean intercambio = false; //Bandera para verificar si ya esta ordenado
            for (int j = 0; j < n - 1 - i; j++) {
                if (copia[j].getPrecio() > copia[j + 1].getPrecio()) {
                    //Intercambio
                    Producto temp = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = temp;
                    intercambio = true;
                }
            }
            if (!intercambio) {
                break; //Ya esta ordenado
            }
        }
        return copia; //Se retorna la copia ordenada
    }
 
}
