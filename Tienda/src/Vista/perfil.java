
package Vista;

import Conexion.Sesion;
import Conexion.Usuarios;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class perfil extends javax.swing.JFrame {

    /**
     * Creates new form perfill
     */
    public perfil() {
        initComponents();
        setTitle("Perfil");
        setResizable(false);
        setLocationRelativeTo(null);
        
        int id = Sesion.usuarioId;
        Usuarios usuarios = new Usuarios(); // Crea una instancia de la clase Usuarios
        String nombreU = usuarios.obtenerNombreUsuario(id); // Llama al método obtenerNombreUsuario(id)
        jNombreU.setText(nombreU);
        
        String nombreUser = usuarios.obtenerUsuario(id);
        jUsername.setText(nombreUser);
        jID.setText(String.valueOf(id));
        
        String Apellido = usuarios.obtenerApellido(id);
        String nombreCompleto = nombreU + " " + Apellido;
        jNombreC.setText(nombreCompleto);

        String Edad = usuarios.obtenerEdad(id);
        jEdad.setText(Edad);

        String rutaImagen = usuarios.obtenerRutaImagen(id); // Llama al método obtenerRutaImagen(id)
        if (rutaImagen != null) {
            ImageIcon icon = usuarios.createRoundImage(rutaImagen); // Llama al método createRoundImage(rutaImagen)
            if (icon != null) {
                Image img1 = icon.getImage();
                Image newimg1 = img1.getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen para myButton1
                ImageIcon icon1 = new ImageIcon(newimg1);
                myButton1.setIcon(icon1);

                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(118, 118, java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
                icon = new ImageIcon(newimg);
                myButton3.setIcon(icon);
                
            } else {
                System.out.println("No hay imagen disponible");
                myButton3.setText("Cargar imagen");
            }
        } else {
            System.out.println("No hay imagen disponible");
           
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

        jPanel1 = new javax.swing.JPanel();
        myButton3 = new Vista.MyButton();
        jID = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        myButton1 = new Vista.MyButton();
        jNombreU = new javax.swing.JLabel();
        myButton5 = new Vista.MyButton();
        myButton6 = new Vista.MyButton();
        myButton7 = new Vista.MyButton();
        myButton8 = new Vista.MyButton();
        jLabel1 = new javax.swing.JLabel();
        panelRound2 = new Clases.PanelRound();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelRound3 = new Clases.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        myButton4 = new Vista.MyButton();
        jLabel12 = new javax.swing.JLabel();
        jNombreC = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jEdad = new javax.swing.JLabel();
        jUsername = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myButton3.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton3.setBorderPainted(false);
        myButton3.setColorClick(new java.awt.Color(255, 255, 255));
        myButton3.setColorOver(new java.awt.Color(255, 255, 255));
        myButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myButton3.setRadius(120);
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 120, 120));

        jID.setBackground(new java.awt.Color(255, 255, 255));
        jID.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jID.setForeground(new java.awt.Color(255, 255, 255));
        jID.setText("??");
        jPanel1.add(jID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 260, 20));

        panelRound1.setBackground(new java.awt.Color(0, 102, 102));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 780, 40, 20));

        panelRound2.setBackground(new java.awt.Color(102, 102, 102));
        panelRound2.setForeground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(70);
        panelRound2.setRoundBottomRight(70);
        panelRound2.setRoundTopLeft(70);
        panelRound2.setRoundTopRight(70);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Plataforma: (???)");
        panelRound2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("años");
        panelRound2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Género: (???)");
        panelRound2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Imagen Juego");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        panelRound2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 250));

        panelRound3.setBackground(new java.awt.Color(51, 51, 51));
        panelRound3.setForeground(new java.awt.Color(255, 255, 255));
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound2.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1080, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Jugando: (Juego)");
        panelRound2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        myButton4.setForeground(new java.awt.Color(255, 255, 255));
        myButton4.setText("Cerrar Sesión");
        myButton4.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton4.setBorderPainted(false);
        myButton4.setColor(new java.awt.Color(153, 0, 0));
        myButton4.setColorClick(new java.awt.Color(204, 0, 0));
        myButton4.setColorOver(new java.awt.Color(51, 51, 51));
        myButton4.setFocusPainted(false);
        myButton4.setRadius(50);
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        panelRound2.add(myButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 380, 140, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Nombre Completo:");
        panelRound2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jNombreC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jNombreC.setForeground(new java.awt.Color(255, 255, 255));
        jNombreC.setText("???");
        panelRound2.add(jNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 90, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Edad:");
        panelRound2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jEdad.setForeground(new java.awt.Color(255, 255, 255));
        jEdad.setText("???");
        panelRound2.add(jEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 30, -1));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 1080, 480));

        jUsername.setBackground(new java.awt.Color(255, 255, 255));
        jUsername.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jUsername.setForeground(new java.awt.Color(255, 255, 255));
        jUsername.setText("????");
        jPanel1.add(jUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 260, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jugando: (Juego)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID#");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Biblioteca().setVisible(true);
    }//GEN-LAST:event_myButton5ActionPerformed

    private void myButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton6ActionPerformed

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton7ActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_myButton8ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Copia la imagen al directorio 'img'
                String destinationPath = "./src/img/" + selectedFile.getName();
                Files.copy(selectedFile.toPath(), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);

                // Guarda el nombre de la imagen en la base de datos SQL
                myButton3.setText("");
                Usuarios usuarios = new Usuarios();
                usuarios.guardarNombreImagen(Sesion.usuarioId, selectedFile.getName());
            } catch (IOException e) {
                System.out.println("Error al copiar la imagen: " + e.getMessage());
            }
        }
        
        //Obtener Imagen
        Usuarios usuarios = new Usuarios();
        String rutaImagen = usuarios.obtenerRutaImagen(Sesion.usuarioId); // Llama al método obtenerRutaImagen(id)
        if (rutaImagen != null) {
            ImageIcon icon = usuarios.createRoundImage(rutaImagen); // Llama al método createRoundImage(rutaImagen)
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(110, 110, java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
            icon = new ImageIcon(newimg);
            myButton3.setIcon(icon);
        } else {
            System.out.println("Imagen no encontrada");
        }


    }//GEN-LAST:event_myButton3ActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new perfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jEdad;
    private javax.swing.JLabel jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jNombreC;
    private javax.swing.JLabel jNombreU;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jUsername;
    private Vista.MyButton myButton1;
    private Vista.MyButton myButton3;
    private Vista.MyButton myButton4;
    private Vista.MyButton myButton5;
    private Vista.MyButton myButton6;
    private Vista.MyButton myButton7;
    private Vista.MyButton myButton8;
    private Clases.PanelRound panelRound1;
    private Clases.PanelRound panelRound2;
    private Clases.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}