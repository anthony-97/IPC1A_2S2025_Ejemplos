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
                    System.out.println(codigo);
                   if(usuario.getContrasena().equals(contrasena)) {
                       System.out.println(contrasena);
                       return usuario;
                   }
                }
           }
       }
       return null;
    }
    
}
