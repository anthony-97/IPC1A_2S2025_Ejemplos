/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.*;

/**
 *
 * @author polares
 */
public class ControladorSerializacion extends ControladorBase {
    private static final String ARCHIVO_MODELO = "modelo.ser";
    private static final String ARCHIVO_CONTADORES = "contadores.ser";
        
    public Modelo verificarSerializacion() {
        //Declaracion del modelo
        Modelo modelo = null;
        
        //Se abre el archivo binario del modelo
        File f = new File("modelo.ser");

        if (f.exists()) { //Si el archivo existe
            modelo = this.deserializar();
            modelo.setControlador(this.getControladorPrincipal()); //El modelo tiene que saber quien lo controla
            modelo.setModeloUsuarios(new ModeloUsuarios());
            modelo.setModeloMonitores(new ModeloMonitores());
            modelo.setModeloProductos(new ModeloProductos());
            this.getControladorPrincipal().setModelo(modelo);
        }
        return modelo;
    }

    public void serializar() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_MODELO))) {
            out.writeObject(this.getControladorPrincipal().getModelo());
            System.out.println("Modelo serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Se guardan los contadores, en este caso nada mas existe el de usuarios
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ARCHIVO_CONTADORES))) {
            dos.writeInt(Modelo.getContadorUsuarios());
            dos.writeInt(Modelo.getContadorProductos());
            System.out.println("Contadores guardados.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Modelo deserializar() {
        Modelo modelo = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_MODELO))) {
            modelo = (Modelo) in.readObject();
            System.out.println("Modelo deserializado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Se leen los contadores
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ARCHIVO_CONTADORES))) {
            int contadorUsuarios = dis.readInt();
            int contadorProductos = dis.readInt();
            Modelo.setContadorUsuarios(contadorUsuarios);
            Modelo.setContadorProductos(contadorProductos);
            System.out.println("Contadores restaurados.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return modelo;
    }
}
