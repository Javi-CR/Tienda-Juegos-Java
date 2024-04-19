/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Conexion.Sesion;
import Conexion.Tienda;
import Conexion.Usuarios;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;


/**
 *
 * @author javie
 */
public class Biblioteca extends javax.swing.JFrame {

    /**
     * Creates new form Biblioteca1
     */
    public Biblioteca() {
        initComponents();
        setTitle("Biblioteca");
        setResizable(false);
        setLocationRelativeTo(null);

        int id = Sesion.usuarioId;
        Usuarios usuarios = new Usuarios(); // Crea una instancia de la clase Usuarios
        String nombreUsuario = usuarios.obtenerNombreUsuario(id); // Llama al método obtenerNombreUsuario(id)
        jNombreU.setText(nombreUsuario);

        String rutaImagen = usuarios.obtenerRutaImagen(id); // Llama al método obtenerRutaImagen(id)
        if (rutaImagen != null) {
            ImageIcon icon = usuarios.createRoundImage(rutaImagen); // Llama al método createRoundImage(rutaImagen)
            if (icon != null) {
                Image img1 = icon.getImage();
                Image newimg1 = img1.getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen para myButton1
                ImageIcon icon1 = new ImageIcon(newimg1);
                myButton1.setIcon(icon1);
            } else {
                System.out.println("No hay imagen disponible");
            }
        } else {
            System.out.println("No hay imagen disponible");

        }

        actualizarJList();

        jList.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                Tienda tienda = new Tienda();
                String nombreJuegoSeleccionado = jList.getSelectedValue();
                String[] detallesJuego = tienda.obtenerDetallesJuegoPorNombre(nombreJuegoSeleccionado);
                if (detallesJuego != null) {

                    try {
                        // Obtén la URL de la imagen
                        URL url = new URL(detallesJuego[7]);

                        // Crea un ImageIcon con la imagen de la URL
                        ImageIcon icon = new ImageIcon(url);

                        // Redimensiona la imagen al tamaño del label
                        Image image = icon.getImage();
                        Image resizedImage = image.getScaledInstance(jLabelimagen.getWidth(), jLabelimagen.getHeight(), java.awt.Image.SCALE_SMOOTH);

                        // Crea un nuevo ImageIcon con la imagen redimensionada
                        ImageIcon resizedIcon = new ImageIcon(resizedImage);

                        // Configura el label con el nuevo ImageIcon
                        jLabelimagen.setIcon(resizedIcon);
                    } catch (MalformedURLException j) {
                        System.out.println("La URL proporcionada no es válida: " + j.getMessage());
                    } catch (IllegalArgumentException j) {
                        System.out.println("Error al cargar la imagen: " + j.getMessage());
                    }

                    
                    jLabelnJuego.setText(detallesJuego[1]);  // Asume que 'NOMBREJUEGO' es el segundo elemento en 'detallesJuego'
                    jLabelnFecha.setText(detallesJuego[2]);  // Asume que 'FECHALANZAMIENTO' es el tercer elemento en 'detallesJuego'
                }
            }
        });

    }

    public final void actualizarJList() {
        // Obtén el ID del usuario actual
        Tienda tienda = new Tienda();
        int id = Sesion.usuarioId;

        // Obtén los nombres de los juegos del usuario actual
        List<String> nombresJuegos = tienda.obtenerNombresJuegos(id);

        // Crea un modelo para la JList
        DefaultListModel<String> model = new DefaultListModel<>();

        // Añade los nombres de los juegos al modelo
        for (String nombreJuego : nombresJuegos) {
            model.addElement(nombreJuego);
        }

        // Configura la JList con el modelo
        jList.setModel(model);
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound5 = new Clases.PanelRound();
        myButton10 = new Vista.MyButton();
        Tiempo_de_Juego = new javax.swing.JLabel();
        jLabelnFecha = new javax.swing.JLabel();
        Logros2 = new javax.swing.JLabel();
        jLabelnJuego = new javax.swing.JLabel();
        jLabelimagen = new javax.swing.JLabel();
        panelRound3 = new Clases.PanelRound();
        panelRound4 = new Clases.PanelRound();
        panelRound2 = new Clases.PanelRound();
        panelRound1 = new Clases.PanelRound();
        myButton1 = new Vista.MyButton();
        jNombreU = new javax.swing.JLabel();
        myButton5 = new Vista.MyButton();
        myButton6 = new Vista.MyButton();
        myButton7 = new Vista.MyButton();
        myButton8 = new Vista.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound5.setBackground(new java.awt.Color(68, 68, 68));
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelRound5.add(myButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 40));

        Tiempo_de_Juego.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Tiempo_de_Juego.setForeground(new java.awt.Color(204, 204, 204));
        Tiempo_de_Juego.setText("Tiempo de Juego");
        panelRound5.add(Tiempo_de_Juego, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabelnFecha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabelnFecha.setForeground(new java.awt.Color(204, 204, 204));
        jLabelnFecha.setText("fecha");
        panelRound5.add(jLabelnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        Logros2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Logros2.setForeground(new java.awt.Color(204, 204, 204));
        Logros2.setText("Fecha de Compra:");
        panelRound5.add(Logros2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 110, -1));

        jLabelnJuego.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabelnJuego.setForeground(new java.awt.Color(204, 204, 204));
        jLabelnJuego.setText("Juego");
        panelRound5.add(jLabelnJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(794, 20, 350, -1));

        jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, 1180, 60));

        jLabelimagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 1180, 570));

        panelRound3.setBackground(new java.awt.Color(68, 68, 68));

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 10));

        panelRound4.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        jPanel1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 20, 780));

        panelRound2.setBackground(new java.awt.Color(68, 68, 68));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 830, 160, 10));

        panelRound1.setBackground(new java.awt.Color(0, 102, 102));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myButton1.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton1.setBorderPainted(false);
        myButton1.setColorClick(new java.awt.Color(255, 255, 255));
        myButton1.setColorOver(new java.awt.Color(255, 255, 255));
        myButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myButton1.setRadius(40);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
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

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 60));

        jList.setBackground(new java.awt.Color(68, 68, 68));
        jList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 8));
        jList.setForeground(new java.awt.Color(255, 255, 255));
        jList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(jList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 180, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Biblioteca().setVisible(true);
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

    private void myButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton10ActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logros2;
    private javax.swing.JLabel Tiempo_de_Juego;
    private javax.swing.JLabel jLabelimagen;
    private javax.swing.JLabel jLabelnFecha;
    private javax.swing.JLabel jLabelnJuego;
    private javax.swing.JList<String> jList;
    private javax.swing.JLabel jNombreU;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Vista.MyButton myButton1;
    private Vista.MyButton myButton10;
    private Vista.MyButton myButton5;
    private Vista.MyButton myButton6;
    private Vista.MyButton myButton7;
    private Vista.MyButton myButton8;
    private Clases.PanelRound panelRound1;
    private Clases.PanelRound panelRound2;
    private Clases.PanelRound panelRound3;
    private Clases.PanelRound panelRound4;
    private Clases.PanelRound panelRound5;
    // End of variables declaration//GEN-END:variables
}
