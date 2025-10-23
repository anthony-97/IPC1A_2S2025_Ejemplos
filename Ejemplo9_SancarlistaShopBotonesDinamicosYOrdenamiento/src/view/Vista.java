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
    private RegistroVendedor registroVendedor;
    private VentanaProducto ventanaProducto;
    private VentanaMonitores ventanaMonitores;
    
    public Vista() {
        this.ventanaLogin =  new Login();
        this.inicioAdmin = new InicioAdmin();
        this.inicioVendedor = new InicioVendedor();
        this.inicioCliente = new InicioCliente();
        this.registroVendedor = new RegistroVendedor();
        this.ventanaProducto = new VentanaProducto();
        this.ventanaMonitores = new VentanaMonitores();
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

    public RegistroVendedor getRegistroVendedor() {
        return registroVendedor;
    }

    public void setRegistroVendedor(RegistroVendedor registroVendedor) {
        this.registroVendedor = registroVendedor;
    }

    public VentanaProducto getVentanaProducto() {
        return ventanaProducto;
    }

    public void setVentanaProducto(VentanaProducto ventanaProducto) {
        this.ventanaProducto = ventanaProducto;
    }
   
    public VentanaMonitores getVentanaMonitores() {
        return ventanaMonitores;
    }

    public void setVentanaMonitores(VentanaMonitores ventanaMonitores) {
        this.ventanaMonitores = ventanaMonitores;
    }
    
}
