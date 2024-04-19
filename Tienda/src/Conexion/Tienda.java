/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author javie
 */
public class Tienda {
    
    private final conexion conexion;

    public Tienda() { this.conexion = new conexion(); }
    
    public String[] obtenerDetallesJuego(int idJuego) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Modifica la consulta SQL para seleccionar todas las columnas
            String sql = "SELECT * FROM JUEGO WHERE IDJUEGO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, idJuego);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("IDJUEGO");
                String nombreJuego = rs.getString("NOMBREJUEGO");
                Date fechaLanzamiento = rs.getDate("FECHALANZAMIENTO");
                double precio = rs.getDouble("PRECIO");
                int limiteEdad = rs.getInt("LIMITEEDAD");
                String enDescuento = rs.getString("ENDESCUENTO");
                int idEmpresa = rs.getInt("IDEMPRESA");
                String imagen = rs.getString("IMAGEN");

                return new String[]{String.valueOf(id), nombreJuego, String.valueOf(fechaLanzamiento), String.valueOf(precio), String.valueOf(limiteEdad), enDescuento, String.valueOf(idEmpresa), imagen};
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
 
    public void comprarJuego(int idUsuario, int idJuego) {
        PreparedStatement pstmt = null;
        try {
            // Obtén los detalles del juego
            String[] detallesJuego = obtenerDetallesJuego(idJuego);

            // Prepara la consulta SQL
            String sql = "INSERT INTO BIBLIOTECA_USUARIO (ID_USUARIO, IDJUEGO, NOMBREJUEGO, LIMITEEDAD, FECHALANZAMIENTO, FECHA_COMPRA, IMAGEN) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = this.conexion.getConexion().prepareStatement(sql);

            // Establece los valores de los parámetros
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idJuego);
            pstmt.setString(3, detallesJuego[1]);
            pstmt.setInt(4, Integer.parseInt(detallesJuego[4]));
            pstmt.setDate(5, java.sql.Date.valueOf(detallesJuego[2]));
            pstmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));  // Fecha actual
            pstmt.setString(7, detallesJuego[7]);

            // Ejecuta la consulta
            int rows = pstmt.executeUpdate();

            // Verifica si la inserción fue exitosa
            if (rows > 0) {
                System.out.println("Juego comprado con éxito");
            } else {
                System.out.println("Error al comprar el juego");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        } finally {
            // Cierra los recursos
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }

    public List<String> obtenerNombresJuegos(int idUsuario) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<String> nombresJuegos = new ArrayList<>();
        try {
            String sql = "SELECT NOMBREJUEGO FROM BIBLIOTECA_USUARIO WHERE ID_USUARIO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, idUsuario);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                nombresJuegos.add(rs.getString("NOMBREJUEGO"));
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
        return nombresJuegos;
    }

    public String[] obtenerDetallesJuegoPorNombre(String nombreJuego) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM JUEGO WHERE NOMBREJUEGO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setString(1, nombreJuego);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                int idJuego = rs.getInt("IDJUEGO");
                Date fechaLanzamiento = rs.getDate("FECHALANZAMIENTO");
                double precio = rs.getDouble("PRECIO");
                int limiteEdad = rs.getInt("LIMITEEDAD");
                String enDescuento = rs.getString("ENDESCUENTO");
                int idEmpresa = rs.getInt("IDEMPRESA");
                String imagen = rs.getString("IMAGEN");

                return new String[]{String.valueOf(idJuego), nombreJuego, String.valueOf(fechaLanzamiento), String.valueOf(precio), 
                    String.valueOf(limiteEdad), enDescuento, String.valueOf(idEmpresa), imagen};
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }


    
}
