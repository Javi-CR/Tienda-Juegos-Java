
import Conexion.conexion;
import Vista.inicio1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author javie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //.............................
        conexion conn = new conexion();
        conn.desconectar();
        //.............................
        inicio1 ventana = new inicio1();
        ventana.setVisible(true);
    }
    
}
