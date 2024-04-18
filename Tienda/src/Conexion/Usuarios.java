/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


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

    
    
    //Simplemente Obtiene datos
    public String obtenerNombreUsuario(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT NOMBRE FROM usuario WHERE IDUSUARIO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            // Si rs.next() devuelve true, entonces hay un registro que coincide con el ID proporcionado
            if (rs.next()) {
                return rs.getString("NOMBRE");  // Asume que tienes una columna 'NOMBRE' en tu tabla 'usuario'
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.out.println(e);
            return null;
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
    
    
    public String obtenerUsuario(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT NOMBREUSUARIO FROM usuario WHERE IDUSUARIO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            
            if (rs.next()) {
                return rs.getString("NOMBREUSUARIO");  
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.out.println(e);
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
    
    public String obtenerApellido(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT APELLIDO FROM usuario WHERE IDUSUARIO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            
            if (rs.next()) {
                return rs.getString("APELLIDO");  
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.out.println(e);
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
    
    public String obtenerEdad(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT EDAD FROM usuario WHERE IDUSUARIO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            
            if (rs.next()) {
                return rs.getString("EDAD");  
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.out.println(e);
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
    
    //Sube una Imagen en SQL!!
    public void guardarNombreImagen(int id, String nombreImagen) {
        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE usuario SET IMAGEN = ? WHERE IDUSUARIO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setString(1, nombreImagen);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Nombre de la imagen guardado con éxito");
            } else {
                System.out.println("Error al guardar el nombre de la imagen");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
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

    public String obtenerRutaImagen(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT IMAGEN FROM usuario WHERE IDUSUARIO = ?";
            pstmt = this.conexion.getConexion().prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            // Si rs.next() devuelve true, entonces hay un registro que coincide con el ID proporcionado
            if (rs.next()) {
                return "./src/img/" + rs.getString("IMAGEN");
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.out.println(e);
            return null;
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
    
    public ImageIcon createRoundImage(String rutaImagen) {
        
        if (rutaImagen == null) {
            System.out.println("No se proporcionó ninguna ruta de imagen");
            return null;
        }

        try {
            BufferedImage master = ImageIO.read(new File(rutaImagen));

            int diameter = Math.min(master.getWidth(), master.getHeight());
            BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = mask.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.fillOval(0, 0, diameter - 1, diameter - 1);
            g2d.dispose();

            BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
            g2d = masked.createGraphics();
            g2d.drawImage(master, 0, 0, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
            g2d.drawImage(mask, 0, 0, null);
            g2d.dispose();

            return new ImageIcon(masked);
        } catch (IOException e) {
            System.out.println("Error al crear la imagen redonda: " + e.getMessage());
            return null;
        }
    }

    
}
