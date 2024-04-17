/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author javie
 */
public class Usuarios {

    private final conexion conexion;

    // Constructor
    public Usuarios() {
        this.conexion = new conexion(); // Asegúrate de tener una clase 'conexion' que maneje la conexión a la base de datos
    }

    public void insertarUsuario(String nombre, String apellido, String correo, String pass, int edad, String user) {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO usuario (NOMBRE, APELLIDO, CORREO, CONTRASEÑA, EDAD, NOMBREUSUARIO) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            pstmt.setString(4, pass);
            pstmt.setInt(5, edad);
            pstmt.setString(6, user);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.out.println(e);
        } finally {
            // Cerrar recursos en un bloque finally
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
    
    
    public boolean validarUsuario(String correo, String pass) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM usuario WHERE CORREO = ? AND CONTRASEÑA = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setString(1, correo);
            pstmt.setString(2, pass);

            rs = pstmt.executeQuery();

            // Si rs.next() devuelve true, entonces hay al menos un registro que coincide
            // con el correo y la contraseña proporcionados
            if (rs.next()) {
                Sesion.usuarioId = rs.getInt("IDUSUARIO");  // Asume que tienes una columna 'ID' en tu tabla 'usuario'
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.out.println(e);
            return false;
        } finally {
            // Cerrar recursos en un bloque finally
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
    
     public int obtenerIdUsuarioConectado() {
        
        return Sesion.usuarioId;
}

}




