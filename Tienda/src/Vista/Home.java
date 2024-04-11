/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

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
        mostrarImagenJuego(5); // Llama al método para obtener la imagen del juego con ID 1
        mostrarImagenesDescuento();
       
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
        Label1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        Label2 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        Label4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label1.setFont(new java.awt.Font("URW Geometric Light", 0, 24)); // NOI18N
        Label1.setForeground(new java.awt.Color(255, 255, 255));
        Label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label1.setText("INICIO");
        Label1.setToolTipText("");
        jPanel1.add(Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 110, 40));

        jTextField2.setBackground(new java.awt.Color(230, 230, 230));
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("Buscador");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 180, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/F3.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 200, 40));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 210, 190));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 610, 210, 90));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setLayout(new java.awt.GridLayout(1, 4, 10, 0));
        jPanel4.add(jPanel9);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 860, 100));
        jPanel4.getAccessibleContext().setAccessibleName("");

        Label2.setFont(new java.awt.Font("URW Geometric Light", 0, 24)); // NOI18N
        Label2.setForeground(new java.awt.Color(255, 255, 255));
        Label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label2.setText("PERFIL");
        Label2.setToolTipText("");
        jPanel1.add(Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 130, 40));

        Label3.setFont(new java.awt.Font("URW Geometric Light", 0, 24)); // NOI18N
        Label3.setForeground(new java.awt.Color(255, 255, 255));
        Label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label3.setText("BIBLIOTECA");
        Label3.setToolTipText("");
        jPanel1.add(Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 160, 40));

        Label4.setFont(new java.awt.Font("URW Geometric Light", 0, 24)); // NOI18N
        Label4.setForeground(new java.awt.Color(255, 255, 255));
        Label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label4.setText("COMUNIDAD");
        Label4.setToolTipText("");
        jPanel1.add(Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 150, 40));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 860, 220));
        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 210, 90));
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 210, 90));
        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 210, 190));
        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 210, 90));

        jLabel1.setText("OFERTAS ESPECIALES");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 120, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 870, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 900, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
   
    }//GEN-LAST:event_jTextField2ActionPerformed

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
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
