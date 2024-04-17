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
import java.util.List;


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
            System.out.println("Conectado!!!");
                    
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
    
   public String obtenerRutaImagen(int idJuego) {
    String rutaImagen = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        String query = "SELECT IMAGEN FROM JUEGO WHERE IDJUEGO = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, idJuego);
        rs = pstmt.executeQuery();
        //System.out.println("No se encontró la imagen para el juego con ID: " + idJuego);
        
        if (rs.next()) {
            rutaImagen = rs.getString("IMAGEN");
        }
        
        // Verificar nulidad de rs fuera del bloque if
        if (rs != null) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Nombre de columna: " + rsmd.getColumnName(i));
                
                
            }
        } else {
            System.out.println("El ResultSet es nulo.");
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener la ruta de la imagen: " + e.getMessage());
    } finally {
        // Cerrar recursos en un bloque finally
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar los recursos: " + e.getMessage());
        }
    }
    return rutaImagen;
}public List<String> obtenerRutasImagenesConDescuento() {
        List<String> rutasImagenes = new ArrayList<>();
        String query = "SELECT IMAGEN FROM JUEGO WHERE ENDESCUENTO = '1'";

        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String rutaImagen = rs.getString("IMAGEN");
                rutasImagenes.add(rutaImagen);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las rutas de las imágenes con descuento: " + e.getMessage());
        }

        return rutasImagenes;
    }

    public Connection getConexion() {
        return this.conn;
    }
}