/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author javie
 */
public class conexion {
    private Connection conn = null;
    private String url, user, pass;

    public conexion() {
        conectar();
    }
    
    private void conectar(){
        try {
            Class.forName("oracle.jdbc.OracleDriver"); //Driver
            url = "jdbc:oracle:thin:@localhost:1521:orcl";
            user = "ADMIN";
            pass = "12345";
            conn = DriverManager.getConnection(url, user, pass);
                    
        } catch (Exception e) {
          System.out.println("No se pudo conectar...");
          System.out.println(e);
        }
    }
    
    public void desconectar(){
         try {
            conn.close();
            System.out.println("Desconectado");
        } catch (Exception e) {
            System.out.println("No se pudo desconectar...");
            System.out.println(e);
        }
    }
    
   

    public Connection getConexion() { return this.conn; }
    
   
}
    
