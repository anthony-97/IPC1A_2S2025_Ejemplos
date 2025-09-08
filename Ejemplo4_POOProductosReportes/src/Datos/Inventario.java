/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author polares
 */
public class Inventario {
    private Producto[] productos;
    private int contadorProductos;

    public Inventario() {
        this.productos = new Producto[100];
        this.contadorProductos = 0;
    }

    public Producto[] getProductos() {
        return productos;
    }
    
    public void generarProductos() {
        Producto p1 = new Producto(1, "Salsa", 9.99, 20);
        Producto p2 = new Producto(2, "Pescado", 15.95, 100);
        Producto p3 = new Producto(3, "Sopa", 3.00, 100);
        Producto p4 = new Producto(4, "Cereal", 20.00, 400);
        Producto p5 = new Producto(5, "Arroz", 5.00, 500);
        Producto p6 = new Producto(6, "Pizza", 35.00, 100);
        Producto p7 = new Producto(7, "Gaseosa", 15.00, 300);
        Producto p8 = new Producto(8, "Gelatina", 10.00, 400);
        Producto p9 = new Producto(9, "Chocolate en barra", 3.00, 300);
        
        this.agregarProducto(p1);
        this.agregarProducto(p2);
        this.agregarProducto(p3);
        this.agregarProducto(p4);
        this.agregarProducto(p5);
        this.agregarProducto(p6);
        this.agregarProducto(p7);
        this.agregarProducto(p8);
        this.agregarProducto(p9);
    }
    
    private void listarProductos() {
        for(Producto producto: this.productos) {
            System.out.println(producto);
        }
    }
    
    public void agregarProducto(Producto p) {
        if(this.contadorProductos == this.productos.length) {
            System.out.println("Ya no se pueden agregar productos");
        } else {
            int indice = this.contadorProductos; //Para obtener el indice de la posicion libre actual
            this.productos[indice] = p; //Se agrega al producto en la posicion libre
            this.contadorProductos++; //Se aumenta el contador, porque se agregó un nuevo producto
            System.out.println("Producto agregado exitosamente");
        }
    }
}