/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Conexion.Sesion;
import Conexion.conexion;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author javie
 */
public class Home extends javax.swing.JFrame {

    private conexion conexion;
    /**
     * Creates new form NewJFrame
     */
    public Home() {
        initComponents();
        conexion = new conexion();
        setTitle("Home");
        setResizable(false);
        setLocationRelativeTo(null);
        mostrarImagenJuego(5); // Llama al método para obtener la imagen del juego con ID 1
        mostrarImagenesDescuento();
        int id = Sesion.usuarioId;
        jNombreU.setText(Integer.toString(id)); // Convierte el ID del usuario a una cadena

       
}
   private void mostrarImagenJuego(int idJuego) {
    String rutaImagen = conexion.obtenerRutaImagen(idJuego); // Obtener la ruta de la imagen para el juego con el ID especificado
    if (rutaImagen != null) {
        try {
            System.out.println("Ruta de la imagen: " + rutaImagen); // Mensaje de depuración
            
            // Descargar la imagen desde la URL
            URL url = new URL(rutaImagen);
            Image imagenOriginal = ImageIO.read(url);
            
            // Redimensionar la imagen a 40x50 manteniendo la relación de aspecto
            Image imagenRedimensionada = imagenOriginal.getScaledInstance(900, 300, Image.SCALE_SMOOTH);
            
            // Crear un ImageIcon con la imagen redimensionada
            ImageIcon icono = new ImageIcon(imagenRedimensionada);
            
            // Crear un JLabel con el ImageIcon y agregarlo al jPanel6
            JLabel label = new JLabel(icono);
            jPanel6.setLayout(new GridLayout(1, 1)); // Establecer layout del panel
            jPanel6.add(label); // Agregar imagen al panel
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    } else {
        System.out.println("No se encontró la imagen para el juego con ID: " + idJuego);
        System.out.println("Ruta imagen: " + rutaImagen);
    }
}
   
  

// Resto de la clase...

private void mostrarImagenesDescuento() {
    // Obtener las rutas de las imágenes de los juegos con descuento desde la base de datos
    List<String> rutasImagenes = conexion.obtenerRutasImagenesConDescuento();
    
    // Iterar sobre cada ruta de imagen
    for (String rutaImagen : rutasImagenes) {
        try {
            System.out.println("Ruta de la imagen: " + rutaImagen); // Mensaje de depuración
            
            // Descargar la imagen desde la URL
            URL url = new URL(rutaImagen);
            Image imagenOriginal = ImageIO.read(url);
            
            // Redimensionar la imagen a 40x50 manteniendo la relación de aspecto
            Image imagenRedimensionada = imagenOriginal.getScaledInstance(170, 90, Image.SCALE_SMOOTH);
            
            // Crear un ImageIcon con la imagen redimensionada
            ImageIcon icono = new ImageIcon(imagenRedimensionada);
            
            // Crear un JLabel con el ImageIcon y agregarlo al jPanel9
            JLabel label = new JLabel(icono);
            jPanel9.add(label);
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen desde la URL: " + e.getMessage());
        }
    }
    
    // Actualizar la disposición del panel
    jPanel9.revalidate();
    jPanel9.repaint();
}





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelRound1 = new Clases.PanelRound();
        myButton1 = new Vista.MyButton();
        jNombreU = new javax.swing.JLabel();
        myButton5 = new Vista.MyButton();
        myButton6 = new Vista.MyButton();
        myButton7 = new Vista.MyButton();
        myButton8 = new Vista.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 210, 190));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 610, 210, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setLayout(new java.awt.GridLayout(1, 4, 10, 0));
        jPanel4.add(jPanel9);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 860, 100));
        jPanel4.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 860, 220));
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 210, 90));
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 210, 90));
        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 210, 190));
        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 210, 90));

        jLabel1.setText("OFERTAS ESPECIALES");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 120, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 870, 20));

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

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    }//GEN-LAST:event_myButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jNombreU;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private Vista.MyButton myButton1;
    private Vista.MyButton myButton5;
    private Vista.MyButton myButton6;
    private Vista.MyButton myButton7;
    private Vista.MyButton myButton8;
    private Clases.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
