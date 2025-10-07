/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author polares
 */
public class Vista {
    
    private Login ventanaLogin;
    private InicioAdmin inicioAdmin;
    private InicioVendedor inicioVendedor;
    private InicioCliente inicioCliente;
    
    public Vista() {
    }

    public Login getVentanaLogin() {
        return ventanaLogin;
    }

    public void setVentanaLogin(Login ventanaLogin) {
        this.ventanaLogin = ventanaLogin;
    }

    public InicioAdmin getInicioAdmin() {
        return inicioAdmin;
    }

    public void setInicioAdmin(InicioAdmin inicioAdmin) {
        this.inicioAdmin = inicioAdmin;
    }

    public InicioVendedor getInicioVendedor() {
        return inicioVendedor;
    }

    public void setInicioVendedor(InicioVendedor inicioVendedor) {
        this.inicioVendedor = inicioVendedor;
    }

    public InicioCliente getInicioCliente() {
        return inicioCliente;
    }

    public void setInicioCliente(InicioCliente inicioCliente) {
        this.inicioCliente = inicioCliente;
    }
    
}
