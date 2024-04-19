/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Conexion.Sesion;
import Conexion.Usuarios;
import Conexion.conexion;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//EN PROCESO 

public class Biblioteca extends javax.swing.JFrame {

    private ImageIcon imagenBienvenidaOriginal;
    private Connection conn; // Variable de instancia para la conexión a la base de datos

    public Biblioteca() { 
        initComponents();
        setTitle("Biblioteca");
        setResizable(false);
        setLocationRelativeTo(null);
        mostrarImagenDesdeInternet("https://jumpseller.s3.eu-west-1.amazonaws.com/store/juegosya/assets/banner_nintendo.jpg", Imagen_para_juego);
        
        // Crear una instancia de la clase conexion y establecer la conexión
        conexion con = new conexion();
        con.conectar();
        conn = con.getConexion(); // Obtener la conexión

        int id = Sesion.usuarioId;
        Usuarios usuarios = new Usuarios(); // Crea una instancia de la clase Usuarios
        String nombreUsuario = usuarios.obtenerNombreUsuario(id); // Llama al método obtenerNombreUsuario(id)
        jNombreU.setText(nombreUsuario);
        
        // Mostrar nombres de todos los juegos
        mostrarNombreJuego(1, JuegoEjemplo1);
        mostrarNombreJuego(2, JuegoEjemplo2);
        mostrarNombreJuego(3, JuegoEjemplo3);
        mostrarNombreJuego(4, JuegoEjemplo4);
        mostrarNombreJuego(5, JuegoEjemplo5);
        
        // Ocultar los JLabels de los juegos
        JuegoEjemplo1.setVisible(false);
        JuegoEjemplo2.setVisible(false);
        JuegoEjemplo3.setVisible(false);
        JuegoEjemplo4.setVisible(false);
        JuegoEjemplo5.setVisible(false);
        
        


        // Agregar listeners de clic a los JLabels de los juegos
        JuegoEjemplo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo1MouseClicked(evt);
            }
        });

        JuegoEjemplo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo2MouseClicked(evt);
            }
        });

        JuegoEjemplo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo3MouseClicked(evt);
            }
        });
        
        JuegoEjemplo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo4MouseClicked(evt);
            }
        });
        
        JuegoEjemplo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo5MouseClicked(evt);
            }
        });
        
        if (id == Sesion.usuarioId) {
            // Verificar si el usuario tiene asociado el juego 1
            boolean juego1Asociado = verificarJuegoAsociadoUsuario(1, id);
            if (juego1Asociado == true) {
                JuegoEjemplo1.setVisible(true);
            } else {
                JuegoEjemplo1.setVisible(false);
            }
            // Verificar si el usuario tiene asociado el juego 2
            boolean juego2Asociado = verificarJuegoAsociadoUsuario(2, id);
            if (juego2Asociado == true) {
                JuegoEjemplo2.setVisible(true);
            } else {
                JuegoEjemplo2.setVisible(false);
            }
            // Verificar si el usuario tiene asociado el juego 2
            boolean juego3Asociado = verificarJuegoAsociadoUsuario(3, id);
            if (juego3Asociado == true) {
                JuegoEjemplo3.setVisible(true);
            } else {
                JuegoEjemplo3.setVisible(false);
            }
            // Verificar si el usuario tiene asociado el juego 2
            boolean juego4Asociado = verificarJuegoAsociadoUsuario(4, id);
            if (juego4Asociado == true) {
                JuegoEjemplo4.setVisible(true);
            } else {
                JuegoEjemplo4.setVisible(false);
            }
            // Verificar si el usuario tiene asociado el juego 2
            boolean juego5Asociado = verificarJuegoAsociadoUsuario(5, id);
            if (juego5Asociado == true) {
                JuegoEjemplo5.setVisible(true);
            } else {
                JuegoEjemplo5.setVisible(false);
            }
        }
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

    private void mostrarImagenDesdeInternet(String urlImagen, JPanel panel) {
        try {
            // Descargar la imagen desde la URL
            java.net.URL url = new java.net.URL(urlImagen);
            java.awt.Image imagenOriginal = javax.imageio.ImageIO.read(url);

            // Redimensionar la imagen a un tamaño específico manteniendo la relación de aspecto
            java.awt.Image imagenRedimensionada = imagenOriginal.getScaledInstance(1060, 220, java.awt.Image.SCALE_SMOOTH);

            // Crear un ImageIcon con la imagen redimensionada
            ImageIcon icono = new ImageIcon(imagenRedimensionada);

            // Establecer el ImageIcon en el JPanel
            panel.removeAll();
            JLabel label = new JLabel(icono);
            panel.setLayout(new java.awt.BorderLayout());
            panel.add(label, java.awt.BorderLayout.CENTER);
            panel.revalidate();
            panel.repaint();
        } catch (java.io.IOException e) {
            System.out.println("Error al cargar la imagen desde la URL: " + e.getMessage());
        }
    }

    // Método para mostrar la imagen de un juego en un JLabel dado
    private void mostrarImagenJuego(int idJuego, JLabel label) {
        // Crear una instancia de la clase conexión
        conexion conn = new conexion();

        // Obtener la ruta de la imagen del juego con el ID especificado
        String rutaImagen = conn.obtenerRutaImagen(idJuego);

        // Verificar si se encontró la ruta de la imagen
        if (rutaImagen != null) {
            try {
                // Descargar la imagen desde la URL
                java.net.URL url = new java.net.URL(rutaImagen);
                java.awt.Image imagenOriginal = javax.imageio.ImageIO.read(url);

                // Redimensionar la imagen a un tamaño específico manteniendo la relación de aspecto
                java.awt.Image imagenRedimensionada = imagenOriginal.getScaledInstance(1060, 220, java.awt.Image.SCALE_SMOOTH);

                // Crear un ImageIcon con la nueva imagen redimensionada
                ImageIcon icono = new ImageIcon(imagenRedimensionada);

                // Establecer el ImageIcon en el JLabel
                label.setIcon(icono);
            } catch (java.io.IOException e) {
                System.out.println("Error al cargar la imagen desde la URL: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró ninguna imagen para el juego con ID: " + idJuego);
        }
    }

    // Método para actualizar la imagen de bienvenida con la del juego correspondiente
    private void actualizarImagenBienvenida(int idJuego) {
        conexion conn = new conexion();
        String rutaImagen = conn.obtenerRutaImagen(idJuego);

        if (rutaImagen != null) {
            try {
                java.net.URL url = new java.net.URL(rutaImagen);
                java.awt.Image imagenOriginal = javax.imageio.ImageIO.read(url);

                // Redimensionar la imagen a un tamaño específico manteniendo la relación de aspecto
                java.awt.Image imagenRedimensionada = imagenOriginal.getScaledInstance(1060, 220, java.awt.Image.SCALE_SMOOTH);

                // Crear un ImageIcon con la nueva imagen redimensionada
                ImageIcon nuevaImagen = new ImageIcon(imagenRedimensionada);

                // Establecer el nuevo ImageIcon en el JPanel de la imagen de bienvenida
                mostrarImagenDesdeInternet(rutaImagen, Imagen_para_juego);
            } catch (java.io.IOException e) {
                System.out.println("Error al cargar la imagen desde la URL: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró ninguna imagen para el juego con ID: " + idJuego);
        }
    }
    
    private void mostrarNombreJuego(int idJuego, JLabel label) {
        // Definir un arreglo con los nombres de los juegos en el orden deseado
        String[] nombresJuegos = {"ARK", "The Legend of Zelda: BOTW", "Super Mario Odyssey", "Read Dead Redemption 2"};
        
        // Verificar si el ID de juego está dentro del rango de índices del arreglo
        if (idJuego >= 1 && idJuego <= nombresJuegos.length) {
            // Obtener el nombre del juego según su ID
            String nombreJuego = nombresJuegos[idJuego - 1];
            
            // Establecer el nombre del juego en el JLabel
            label.setText(nombreJuego);
        } else {
            // Si el ID de juego no está dentro del rango, establecer un nombre genérico
            label.setText("Juego " + idJuego);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton9 = new Vista.MyButton();
        bg = new javax.swing.JPanel();
        Barra_Lateral_Juegos = new javax.swing.JPanel();
        JuegoEjemplo1 = new javax.swing.JLabel();
        JuegoEjemplo2 = new javax.swing.JLabel();
        JuegoEjemplo3 = new javax.swing.JLabel();
        JuegoEjemplo4 = new javax.swing.JLabel();
        JuegoEjemplo5 = new javax.swing.JLabel();
        Barra_Opciones_Juego = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Imagen_para_juego = new javax.swing.JPanel();
        myButton10 = new Vista.MyButton();
        Tiempo_de_Juego = new javax.swing.JLabel();
        Datos_Tiempo_de_Juego = new javax.swing.JLabel();
        Última_Sesión = new javax.swing.JLabel();
        Datos_Última_Sesión = new javax.swing.JLabel();
        Logros = new javax.swing.JLabel();
        Datos_Logros = new javax.swing.JLabel();
        Actividad = new javax.swing.JLabel();
        jTextField_Para_Actividad = new javax.swing.JTextField();
        Separador_Actividad = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new Clases.PanelRound();
        myButton1 = new Vista.MyButton();
        jNombreU = new javax.swing.JLabel();
        myButton5 = new Vista.MyButton();
        myButton6 = new Vista.MyButton();
        myButton7 = new Vista.MyButton();
        myButton8 = new Vista.MyButton();

        myButton9.setForeground(new java.awt.Color(255, 255, 255));
        myButton9.setText("Inicio");
        myButton9.setBorderColor(new java.awt.Color(0, 102, 102));
        myButton9.setBorderPainted(false);
        myButton9.setColor(new java.awt.Color(0, 102, 102));
        myButton9.setColorClick(new java.awt.Color(0, 51, 51));
        myButton9.setColorOver(new java.awt.Color(51, 51, 51));
        myButton9.setFocusPainted(false);
        myButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myButton9.setRadius(30);
        myButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton9ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(51, 51, 51));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Barra_Lateral_Juegos.setBackground(new java.awt.Color(102, 102, 102));
        Barra_Lateral_Juegos.setNextFocusableComponent(Barra_Lateral_Juegos);

        JuegoEjemplo1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        JuegoEjemplo1.setText("Ejemplo");
        JuegoEjemplo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JuegoEjemplo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JuegoEjemplo1MousePressed(evt);
            }
        });

        JuegoEjemplo2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        JuegoEjemplo2.setText("Ejemplo");
        JuegoEjemplo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JuegoEjemplo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo2MouseClicked(evt);
            }
        });

        JuegoEjemplo3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        JuegoEjemplo3.setText("Ejemplo");
        JuegoEjemplo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JuegoEjemplo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo3MouseClicked(evt);
            }
        });

        JuegoEjemplo4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        JuegoEjemplo4.setText("Ejemplo");
        JuegoEjemplo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JuegoEjemplo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo4MouseClicked(evt);
            }
        });

        JuegoEjemplo5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        JuegoEjemplo5.setText("Ejemplo");
        JuegoEjemplo5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JuegoEjemplo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JuegoEjemplo5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Barra_Lateral_JuegosLayout = new javax.swing.GroupLayout(Barra_Lateral_Juegos);
        Barra_Lateral_Juegos.setLayout(Barra_Lateral_JuegosLayout);
        Barra_Lateral_JuegosLayout.setHorizontalGroup(
            Barra_Lateral_JuegosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Barra_Lateral_JuegosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(Barra_Lateral_JuegosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JuegoEjemplo5)
                    .addComponent(JuegoEjemplo4)
                    .addComponent(JuegoEjemplo2)
                    .addComponent(JuegoEjemplo1)
                    .addComponent(JuegoEjemplo3))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        Barra_Lateral_JuegosLayout.setVerticalGroup(
            Barra_Lateral_JuegosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Barra_Lateral_JuegosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(JuegoEjemplo1)
                .addGap(18, 18, 18)
                .addComponent(JuegoEjemplo2)
                .addGap(18, 18, 18)
                .addComponent(JuegoEjemplo3)
                .addGap(18, 18, 18)
                .addComponent(JuegoEjemplo4)
                .addGap(18, 18, 18)
                .addComponent(JuegoEjemplo5)
                .addContainerGap(550, Short.MAX_VALUE))
        );

        bg.add(Barra_Lateral_Juegos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 290, 770));

        Barra_Opciones_Juego.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setText("Página Tienda");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setText("Punto de Encuentro");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel9.setText("Tienda de Puntos");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel10.setText("Discusiones");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setText("Guías");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setText("Workshop");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel13.setText("Soporte");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Barra_Opciones_JuegoLayout = new javax.swing.GroupLayout(Barra_Opciones_Juego);
        Barra_Opciones_Juego.setLayout(Barra_Opciones_JuegoLayout);
        Barra_Opciones_JuegoLayout.setHorizontalGroup(
            Barra_Opciones_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Barra_Opciones_JuegoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addGap(56, 56, 56)
                .addComponent(jLabel8)
                .addGap(52, 52, 52)
                .addComponent(jLabel9)
                .addGap(55, 55, 55)
                .addComponent(jLabel10)
                .addGap(49, 49, 49)
                .addComponent(jLabel11)
                .addGap(57, 57, 57)
                .addComponent(jLabel12)
                .addGap(44, 44, 44)
                .addComponent(jLabel13)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        Barra_Opciones_JuegoLayout.setVerticalGroup(
            Barra_Opciones_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Barra_Opciones_JuegoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(Barra_Opciones_JuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bg.add(Barra_Opciones_Juego, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 1060, -1));

        Imagen_para_juego.setPreferredSize(new java.awt.Dimension(1230, 220));

        javax.swing.GroupLayout Imagen_para_juegoLayout = new javax.swing.GroupLayout(Imagen_para_juego);
        Imagen_para_juego.setLayout(Imagen_para_juegoLayout);
        Imagen_para_juegoLayout.setHorizontalGroup(
            Imagen_para_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        Imagen_para_juegoLayout.setVerticalGroup(
            Imagen_para_juegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        bg.add(Imagen_para_juego, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 1060, 220));

        myButton10.setBackground(new java.awt.Color(102, 255, 102));
        myButton10.setText("Jugar");
        myButton10.setBorderColor(new java.awt.Color(102, 255, 102));
        myButton10.setBorderPainted(false);
        myButton10.setColor(new java.awt.Color(102, 255, 102));
        myButton10.setColorClick(new java.awt.Color(0, 51, 51));
        myButton10.setColorOver(new java.awt.Color(51, 51, 51));
        myButton10.setFocusPainted(false);
        myButton10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myButton10.setRadius(30);
        myButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton10ActionPerformed(evt);
            }
        });
        bg.add(myButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 80, 40));

        Tiempo_de_Juego.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Tiempo_de_Juego.setForeground(new java.awt.Color(204, 204, 204));
        Tiempo_de_Juego.setText("Tiempo de Juego");
        bg.add(Tiempo_de_Juego, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, -1, -1));

        Datos_Tiempo_de_Juego.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Datos_Tiempo_de_Juego.setForeground(new java.awt.Color(204, 204, 204));
        Datos_Tiempo_de_Juego.setText("xx,x horas");
        bg.add(Datos_Tiempo_de_Juego, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        Última_Sesión.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Última_Sesión.setForeground(new java.awt.Color(204, 204, 204));
        Última_Sesión.setText("Última Sesión");
        bg.add(Última_Sesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        Datos_Última_Sesión.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Datos_Última_Sesión.setForeground(new java.awt.Color(204, 204, 204));
        Datos_Última_Sesión.setText("Hoy");
        bg.add(Datos_Última_Sesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        Logros.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Logros.setForeground(new java.awt.Color(204, 204, 204));
        Logros.setText("Logros");
        bg.add(Logros, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, -1, -1));

        Datos_Logros.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Datos_Logros.setForeground(new java.awt.Color(204, 204, 204));
        Datos_Logros.setText("31/38");
        bg.add(Datos_Logros, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, -1, -1));

        Actividad.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        Actividad.setForeground(new java.awt.Color(255, 255, 255));
        Actividad.setText("Actividad");
        bg.add(Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, -1));

        jTextField_Para_Actividad.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_Para_Actividad.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Para_Actividad.setText("Diles algo sobre este juego a tus amigos...");
        jTextField_Para_Actividad.setBorder(null);
        bg.add(jTextField_Para_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 490, 30));
        bg.add(Separador_Actividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 240, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, 260, 180));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 260, 180));

        panelRound1.setBackground(new java.awt.Color(0, 102, 102));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myButton1.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton1.setBorderPainted(false);
        myButton1.setColorClick(new java.awt.Color(255, 255, 255));
        myButton1.setColorOver(new java.awt.Color(255, 255, 255));
        myButton1.setRadius(40);
        panelRound1.add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 40, 40));

        jNombreU.setForeground(new java.awt.Color(255, 255, 255));
        jNombreU.setText("Usuario...");
        panelRound1.add(jNombreU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 100, 40));

        myButton5.setForeground(new java.awt.Color(255, 255, 255));
        myButton5.setText("Biblioteca");
        myButton5.setBorderColor(new java.awt.Color(0, 102, 102));
        myButton5.setBorderPainted(false);
        myButton5.setColor(new java.awt.Color(0, 102, 102));
        myButton5.setColorClick(new java.awt.Color(0, 51, 51));
        myButton5.setColorOver(new java.awt.Color(51, 51, 51));
        myButton5.setFocusPainted(false);
        myButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myButton5.setRadius(30);
        myButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton5ActionPerformed(evt);
            }
        });
        panelRound1.add(myButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 140, 40));

        myButton6.setForeground(new java.awt.Color(255, 255, 255));
        myButton6.setText("Perfil");
        myButton6.setBorderColor(new java.awt.Color(0, 102, 102));
        myButton6.setBorderPainted(false);
        myButton6.setColor(new java.awt.Color(0, 102, 102));
        myButton6.setColorClick(new java.awt.Color(0, 51, 51));
        myButton6.setColorOver(new java.awt.Color(51, 51, 51));
        myButton6.setFocusPainted(false);
        myButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myButton6.setRadius(30);
        myButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton6ActionPerformed(evt);
            }
        });
        panelRound1.add(myButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 80, 40));

        myButton7.setForeground(new java.awt.Color(255, 255, 255));
        myButton7.setText("Comunidad");
        myButton7.setBorderColor(new java.awt.Color(0, 102, 102));
        myButton7.setBorderPainted(false);
        myButton7.setColor(new java.awt.Color(0, 102, 102));
        myButton7.setColorClick(new java.awt.Color(0, 51, 51));
        myButton7.setColorOver(new java.awt.Color(51, 51, 51));
        myButton7.setFocusPainted(false);
        myButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myButton7.setRadius(30);
        myButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton7ActionPerformed(evt);
            }
        });
        panelRound1.add(myButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 140, 40));

        myButton8.setForeground(new java.awt.Color(255, 255, 255));
        myButton8.setText("Inicio");
        myButton8.setBorderColor(new java.awt.Color(0, 102, 102));
        myButton8.setBorderPainted(false);
        myButton8.setColor(new java.awt.Color(0, 102, 102));
        myButton8.setColorClick(new java.awt.Color(0, 51, 51));
        myButton8.setColorOver(new java.awt.Color(51, 51, 51));
        myButton8.setFocusPainted(false);
        myButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        myButton8.setRadius(30);
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });
        panelRound1.add(myButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 40));

        bg.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton9ActionPerformed

    private void myButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton10ActionPerformed

    private void JuegoEjemplo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuegoEjemplo1MousePressed
        // TODO add your handling code here:
        //No prestar atención
    }//GEN-LAST:event_JuegoEjemplo1MousePressed

    private void JuegoEjemplo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuegoEjemplo1MouseClicked
        // TODO add your handling code here:
        actualizarImagenBienvenida(1);
    }//GEN-LAST:event_JuegoEjemplo1MouseClicked

    private void JuegoEjemplo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuegoEjemplo2MouseClicked
        // Llama al método para cambiar la imagen del panel al hacer clic en JuegoEjemplo2
        actualizarImagenBienvenida(2);
    }//GEN-LAST:event_JuegoEjemplo2MouseClicked

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton5ActionPerformed

    private void myButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton6ActionPerformed
        // TODO add your handling code here:
        dispose();
        new perfil().setVisible(true);
    }//GEN-LAST:event_myButton6ActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton7ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_myButton8ActionPerformed

    private void JuegoEjemplo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuegoEjemplo3MouseClicked
        // TODO add your handling code here:
        actualizarImagenBienvenida(3);
    }//GEN-LAST:event_JuegoEjemplo3MouseClicked

    private void JuegoEjemplo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuegoEjemplo4MouseClicked
        // TODO add your handling code here:
        actualizarImagenBienvenida(4);
    }//GEN-LAST:event_JuegoEjemplo4MouseClicked

    private void JuegoEjemplo5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JuegoEjemplo5MouseClicked
        // TODO add your handling code here:
        actualizarImagenBienvenida(5);
    }//GEN-LAST:event_JuegoEjemplo5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Biblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Actividad;
    private javax.swing.JPanel Barra_Lateral_Juegos;
    private javax.swing.JPanel Barra_Opciones_Juego;
    private javax.swing.JLabel Datos_Logros;
    private javax.swing.JLabel Datos_Tiempo_de_Juego;
    private javax.swing.JLabel Datos_Última_Sesión;
    private javax.swing.JPanel Imagen_para_juego;
    private javax.swing.JLabel JuegoEjemplo1;
    private javax.swing.JLabel JuegoEjemplo2;
    private javax.swing.JLabel JuegoEjemplo3;
    private javax.swing.JLabel JuegoEjemplo4;
    private javax.swing.JLabel JuegoEjemplo5;
    private javax.swing.JLabel Logros;
    private javax.swing.JSeparator Separador_Actividad;
    private javax.swing.JLabel Tiempo_de_Juego;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jNombreU;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField_Para_Actividad;
    private Vista.MyButton myButton1;
    private Vista.MyButton myButton10;
    private Vista.MyButton myButton5;
    private Vista.MyButton myButton6;
    private Vista.MyButton myButton7;
    private Vista.MyButton myButton8;
    private Vista.MyButton myButton9;
    private Clases.PanelRound panelRound1;
    private javax.swing.JLabel Última_Sesión;
    // End of variables declaration//GEN-END:variables
}
