/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author javie
 */
public class perfil extends javax.swing.JFrame {

    /**
     * Creates new form perfill
     */
    public perfil() {
        initComponents();
        setTitle("Perfil");
        setResizable(false);
        setLocationRelativeTo(null);
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
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        myButton1 = new Vista.MyButton();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel11 = new javax.swing.JLabel();
        myButton4 = new Vista.MyButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myButton3.setText("iconoPerfil");
        myButton3.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton3.setBorderPainted(false);
        myButton3.setColorClick(new java.awt.Color(255, 255, 255));
        myButton3.setColorOver(new java.awt.Color(255, 255, 255));
        myButton3.setRadius(120);
        jPanel1.add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 120, 120));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID#123");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 260, 20));

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

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario...");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 100, 40));

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
        jLabel7.setText("Edad: 20 años");
        panelRound2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre Completo: Javier Romero G.");
        panelRound2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

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

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 1080, 480));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Javi3504");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 260, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jugando: (Juego)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
