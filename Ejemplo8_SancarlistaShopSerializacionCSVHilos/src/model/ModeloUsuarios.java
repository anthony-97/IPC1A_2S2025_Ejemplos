/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class ModeloUsuarios extends ModeloBase {
    
    public Usuario iniciarSesion(String codigo, String contrasena) {
        for(Usuario usuario : this.getModeloPrincipal().getUsuarios()) {
           if(usuario != null) {
                if(usuario.getCodigo().equals(codigo)) {
                   if(usuario.getContrasena().equals(contrasena)) {
                       this.getModeloPrincipal().setUsuarioActual(usuario); //Se guarda al usuario actual logueado
                       return usuario;
                   }
                }
           }
       }
       return null;
    }
    
    public boolean crearVendedor(Vendedor vendedor) {
        int contador = this.getModeloPrincipal().contadorUsuarios;
        if (contador < this.getModeloPrincipal().getUsuarios().length) {
            boolean existe = this.verificarDuplicado(vendedor.getCodigo());
            if(!existe) {
                this.getModeloPrincipal().getUsuarios()[contador] = vendedor;
                this.getModeloPrincipal().contadorUsuarios++; //Aumenta el contador de usuario
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
    
    public boolean verificarDuplicado(String codigo) {
        for(Usuario u: this.getModeloPrincipal().getUsuarios()) {
            if(u != null) {
                if(u.getCodigo().equals(codigo)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void cerrarSesion() {
        this.getModeloPrincipal().setUsuarioActual(null); //Se cierra la sesion, limpiando al usuarioActual
    }
}
