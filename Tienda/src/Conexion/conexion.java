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
    
    public void conectar(){
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
}
   public List<String> obtenerRutasImagenesConDescuento() {
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
    
    public List<String> obtenerRutasImagenesSinDescuento() {
       List<String> rutasImagenes = new ArrayList<>();
        String query = "SELECT IMAGEN FROM JUEGO WHERE ENDESCUENTO = '0'";

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
    
    public void agregarJuegoAUsuario(int idUsuario, int idJuego) {
    try {
        String query = "INSERT INTO usuario_juego (IDUSUARIO, IDJUEGO) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, idUsuario);
        pstmt.setInt(2, idJuego);
        pstmt.executeUpdate();
        System.out.println("Juego agregado al usuario correctamente.");
    } catch (SQLException e) {
        System.out.println("Error al agregar el juego al usuario: " + e.getMessage());
    }
}

    public Map<String, Integer> obtenerRutasEIdsImagenesConDescuento() {
    Map<String, Integer> rutasEIds = new HashMap<>();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        String query = "SELECT IDJUEGO, IMAGEN FROM JUEGO WHERE ENDESCUENTO = '1'";
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();
        
        // Iterar sobre el resultado y almacenar las rutas de imagen y los IDs de juego en el mapa
        while (rs.next()) {
            int idJuego = rs.getInt("IDJUEGO");
            String rutaImagen = rs.getString("IMAGEN");
            rutasEIds.put(rutaImagen, idJuego);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener las rutas de las imágenes con descuento: " + e.getMessage());
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
    return rutasEIds;
}

    public Map<String, Integer> obtenerRutasEIdsImagenesSinDescuento() {
    Map<String, Integer> rutasEIds = new HashMap<>();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        String query = "SELECT IDJUEGO, IMAGEN FROM JUEGO WHERE ENDESCUENTO = '0'";
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();
        
        // Iterar sobre el resultado y almacenar las rutas de imagen y los IDs de juego en el mapa
        while (rs.next()) {
            int idJuego = rs.getInt("IDJUEGO");
            String rutaImagen = rs.getString("IMAGEN");
            rutasEIds.put(rutaImagen, idJuego);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener las rutas de las imágenes sin descuento: " + e.getMessage());
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
    return rutasEIds;
}
    
    //EN PROCESO 
    
    public ResultSet obtenerJuegosUsuario(int idUsuario) throws SQLException {
        ResultSet rs = null;
        try {
            String query = "SELECT IDJUEGO FROM USUARIO_JUEGO WHERE IDUSUARIO = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idUsuario);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error al obtener los juegos del usuario: " + e.getMessage());
            throw e; // Lanza la excepción para que sea manejada en el código que llama a este método
        }
        return rs;
    }
    
    public String obtenerNombreJuegoPorId(int idJuego) {
        String nombreJuego = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT NOMBRE FROM JUEGO WHERE IDJUEGO = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idJuego);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                nombreJuego = rs.getString("NOMBRE");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre del juego: " + e.getMessage());
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
        return nombreJuego;
    }
    
    public boolean verificarJuegoAsociadoUsuario(int idJuego, int idUsuario) {
        boolean juegoAsociado = false;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String query = "SELECT 1 FROM USUARIO_JUEGO WHERE IDUSUARIO = ? AND IDJUEGO = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idJuego);
            rs = pstmt.executeQuery();
            juegoAsociado = rs.next(); // Si el ResultSet tiene al menos una fila, significa que el juego está asociado al usuario
        } catch (SQLException e) {
            System.out.println("Error al verificar si el juego está asociado al usuario: " + e.getMessage());
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
        return juegoAsociado;
    }

}
