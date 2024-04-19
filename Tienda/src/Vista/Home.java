/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Conexion.Sesion;
import Conexion.Tienda;
import Conexion.Usuarios;
import java.net.URL;
import java.awt.Image;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;

/**
 *
 * @author javie
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form HOME1
     */
    public Home() {
        initComponents();
        setTitle("Home");
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
        
        Tienda tienda = new Tienda();
        // Obtén los detalles de los juegos
        String[] detallesJuego1 = tienda.obtenerDetallesJuego(1);
        String[] detallesJuego2 = tienda.obtenerDetallesJuego(2);
        String[] detallesJuego3 = tienda.obtenerDetallesJuego(3);
        String[] detallesJuego4 = tienda.obtenerDetallesJuego(4);
        String[] detallesJuego5 = tienda.obtenerDetallesJuego(5);

        try {
            // Obtén la URL de la imagen
            URL url = new URL(detallesJuego1[7]);

            // Crea un ImageIcon con la imagen de la URL
            ImageIcon icon = new ImageIcon(url);

            // Redimensiona la imagen al tamaño del label
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(jImagen1.getWidth(), jImagen1.getHeight(), java.awt.Image.SCALE_SMOOTH);

            // Crea un nuevo ImageIcon con la imagen redimensionada
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            // Configura el label con el nuevo ImageIcon
            jImagen1.setIcon(resizedIcon);
        } catch (MalformedURLException e) {
            System.out.println("La URL proporcionada no es válida: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        try {
            URL url = new URL(detallesJuego2[7]);
            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(jImagen2.getWidth(), jImagen2.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            jImagen2.setIcon(resizedIcon);
        } catch (MalformedURLException e) {
            System.out.println("La URL proporcionada no es válida: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        try {
            URL url = new URL(detallesJuego3[7]);
            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(jImagen3.getWidth(), jImagen3.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            jImagen3.setIcon(resizedIcon);
        } catch (MalformedURLException e) {
            System.out.println("La URL proporcionada no es válida: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        
        try {
            URL url = new URL(detallesJuego4[7]);
            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(jImagen4.getWidth(), jImagen4.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            jImagen4.setIcon(resizedIcon);
        } catch (MalformedURLException e) {
            System.out.println("La URL proporcionada no es válida: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }

        
        try {
            URL url = new URL(detallesJuego5[7]);
            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image resizedImage = image.getScaledInstance(jImagen5.getWidth(), jImagen5.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            jImagen5.setIcon(resizedIcon);
        } catch (MalformedURLException e) {
            System.out.println("La URL proporcionada no es válida: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }

        jNombre1.setText(detallesJuego1[1]);
        jEdad1.setText(detallesJuego1[4]);
        jPrecio1.setText(detallesJuego1[3]);

       
        jNombre2.setText(detallesJuego2[1]);
        jEdad2.setText(detallesJuego2[4]);
        jPrecio2.setText(detallesJuego2[3]);
        
        jNombre3.setText(detallesJuego3[1]);
        jEdad3.setText(detallesJuego3[4]);
        jPrecio3.setText(detallesJuego3[3]);
        
        jNombre4.setText(detallesJuego4[1]);
        jEdad4.setText(detallesJuego4[4]);
        jPrecio4.setText(detallesJuego4[3]);
        
        jNombre5.setText(detallesJuego5[1]);
        jEdad5.setText(detallesJuego5[4]);
        jPrecio5.setText(detallesJuego5[3]);
 
        System.out.println("Conectado");
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
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        myButton1 = new Vista.MyButton();
        jNombreU = new javax.swing.JLabel();
        myButton5 = new Vista.MyButton();
        myButton6 = new Vista.MyButton();
        myButton7 = new Vista.MyButton();
        myButton8 = new Vista.MyButton();
        jLabel2 = new javax.swing.JLabel();
        panelRound2 = new Clases.PanelRound();
        jImagen1 = new javax.swing.JLabel();
        jPrecio1 = new javax.swing.JLabel();
        jNombre1 = new javax.swing.JLabel();
        jEdad1 = new javax.swing.JLabel();
        ButtonC1 = new Vista.MyButton();
        panelRound3 = new Clases.PanelRound();
        jImagen2 = new javax.swing.JLabel();
        jPrecio2 = new javax.swing.JLabel();
        jNombre2 = new javax.swing.JLabel();
        jEdad2 = new javax.swing.JLabel();
        ButtonC2 = new Vista.MyButton();
        panelRound4 = new Clases.PanelRound();
        jImagen3 = new javax.swing.JLabel();
        jPrecio3 = new javax.swing.JLabel();
        jNombre3 = new javax.swing.JLabel();
        jEdad3 = new javax.swing.JLabel();
        ButtonC3 = new Vista.MyButton();
        panelRound5 = new Clases.PanelRound();
        jImagen4 = new javax.swing.JLabel();
        jPrecio4 = new javax.swing.JLabel();
        jNombre4 = new javax.swing.JLabel();
        jEdad4 = new javax.swing.JLabel();
        ButtonC4 = new Vista.MyButton();
        panelRound6 = new Clases.PanelRound();
        jImagen5 = new javax.swing.JLabel();
        jPrecio5 = new javax.swing.JLabel();
        jNombre5 = new javax.swing.JLabel();
        jEdad5 = new javax.swing.JLabel();
        ButtonC5 = new Vista.MyButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("          Juegos Destacados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1340, 60));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("          Ofertas Especiales");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1340, 70));

        panelRound2.setBackground(new java.awt.Color(102, 102, 102));
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound2.add(jImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 170));

        jPrecio1.setForeground(new java.awt.Color(255, 255, 255));
        jPrecio1.setText("Precio");
        panelRound2.add(jPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 160, 170));

        jNombre1.setForeground(new java.awt.Color(255, 255, 255));
        jNombre1.setText("Nombre");
        panelRound2.add(jNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 160, 170));

        jEdad1.setForeground(new java.awt.Color(255, 255, 255));
        jEdad1.setText("Edad");
        panelRound2.add(jEdad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 160, 170));

        ButtonC1.setText("Comprar");
        ButtonC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonC1ActionPerformed(evt);
            }
        });
        panelRound2.add(ButtonC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 60, 159, 42));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1320, 170));

        panelRound3.setBackground(new java.awt.Color(102, 102, 102));
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound3.add(jImagen2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 200, 100));

        jPrecio2.setForeground(new java.awt.Color(255, 255, 255));
        jPrecio2.setText("Precio");
        panelRound3.add(jPrecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 0, 250, 100));

        jNombre2.setForeground(new java.awt.Color(255, 255, 255));
        jNombre2.setText("Nombre");
        panelRound3.add(jNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 0, 250, 100));

        jEdad2.setForeground(new java.awt.Color(255, 255, 255));
        jEdad2.setText("Edad");
        panelRound3.add(jEdad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 0, 250, 100));

        ButtonC2.setText("Comprar");
        ButtonC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonC2ActionPerformed(evt);
            }
        });
        panelRound3.add(ButtonC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 30, 159, 42));

        jPanel1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 1320, -1));

        panelRound4.setBackground(new java.awt.Color(102, 102, 102));
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound4.add(jImagen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 200, 100));

        jPrecio3.setForeground(new java.awt.Color(255, 255, 255));
        jPrecio3.setText("Precio");
        panelRound4.add(jPrecio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 0, 250, 100));

        jNombre3.setForeground(new java.awt.Color(255, 255, 255));
        jNombre3.setText("Nombre");
        panelRound4.add(jNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, -2, 250, 100));

        jEdad3.setForeground(new java.awt.Color(255, 255, 255));
        jEdad3.setText("Edad");
        panelRound4.add(jEdad3, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, -2, 250, 100));

        ButtonC3.setText("Comprar");
        ButtonC3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonC3ActionPerformed(evt);
            }
        });
        panelRound4.add(ButtonC3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 30, 159, 42));

        jPanel1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 1320, -1));

        panelRound5.setBackground(new java.awt.Color(102, 102, 102));
        panelRound5.setForeground(new java.awt.Color(255, 255, 255));
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jImagen4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound5.add(jImagen4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 200, 100));

        jPrecio4.setForeground(new java.awt.Color(255, 255, 255));
        jPrecio4.setText("Precio");
        panelRound5.add(jPrecio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 0, 250, 100));

        jNombre4.setForeground(new java.awt.Color(255, 255, 255));
        jNombre4.setText("Nombre");
        panelRound5.add(jNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, -2, 250, 100));

        jEdad4.setForeground(new java.awt.Color(255, 255, 255));
        jEdad4.setText("Edad");
        panelRound5.add(jEdad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, -2, 250, 100));

        ButtonC4.setText("Comprar");
        ButtonC4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonC4ActionPerformed(evt);
            }
        });
        panelRound5.add(ButtonC4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 30, 159, 42));

        jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 1320, -1));

        panelRound6.setBackground(new java.awt.Color(102, 102, 102));
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound6.add(jImagen5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 200, 100));

        jPrecio5.setForeground(new java.awt.Color(255, 255, 255));
        jPrecio5.setText("Precio");
        panelRound6.add(jPrecio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 0, 250, 100));

        jNombre5.setForeground(new java.awt.Color(255, 255, 255));
        jNombre5.setText("Nombre");
        panelRound6.add(jNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, -2, 250, 100));

        jEdad5.setForeground(new java.awt.Color(255, 255, 255));
        jEdad5.setText("Edad");
        panelRound6.add(jEdad5, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, -2, 250, 100));

        ButtonC5.setText("Comprar");
        ButtonC5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonC5ActionPerformed(evt);
            }
        });
        panelRound6.add(ButtonC5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1131, 30, 159, 42));

        jPanel1.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 1320, -1));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 790, 60, 10));

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

    private void ButtonC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonC1ActionPerformed
        // TODO add your handling code here:
        Tienda tienda = new Tienda();
        int id = Sesion.usuarioId;
        int IDJuego = 1;
        tienda.comprarJuego(id, IDJuego);
    }//GEN-LAST:event_ButtonC1ActionPerformed

    private void ButtonC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonC2ActionPerformed
        // TODO add your handling code here:
        Tienda tienda = new Tienda();
        int id = Sesion.usuarioId;
        int IDJuego = 2;
        tienda.comprarJuego(id, IDJuego);
    }//GEN-LAST:event_ButtonC2ActionPerformed

    private void ButtonC3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonC3ActionPerformed
        // TODO add your handling code here:
        Tienda tienda = new Tienda();
        int id = Sesion.usuarioId;
        int IDJuego = 3;
        tienda.comprarJuego(id, IDJuego);
    }//GEN-LAST:event_ButtonC3ActionPerformed

    private void ButtonC4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonC4ActionPerformed
        // TODO add your handling code here:
          Tienda tienda = new Tienda();
        int id = Sesion.usuarioId;
        int IDJuego = 4;
        tienda.comprarJuego(id, IDJuego);
    }//GEN-LAST:event_ButtonC4ActionPerformed

    private void ButtonC5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonC5ActionPerformed
        // TODO add your handling code here:
        Tienda tienda = new Tienda();
        int id = Sesion.usuarioId;
        int IDJuego = 5;
        tienda.comprarJuego(id, IDJuego);

    }//GEN-LAST:event_ButtonC5ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.MyButton ButtonC1;
    private Vista.MyButton ButtonC2;
    private Vista.MyButton ButtonC3;
    private Vista.MyButton ButtonC4;
    private Vista.MyButton ButtonC5;
    private javax.swing.JLabel jEdad1;
    private javax.swing.JLabel jEdad2;
    private javax.swing.JLabel jEdad3;
    private javax.swing.JLabel jEdad4;
    private javax.swing.JLabel jEdad5;
    private javax.swing.JLabel jImagen1;
    private javax.swing.JLabel jImagen2;
    private javax.swing.JLabel jImagen3;
    private javax.swing.JLabel jImagen4;
    private javax.swing.JLabel jImagen5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jNombre1;
    private javax.swing.JLabel jNombre2;
    private javax.swing.JLabel jNombre3;
    private javax.swing.JLabel jNombre4;
    private javax.swing.JLabel jNombre5;
    private javax.swing.JLabel jNombreU;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPrecio1;
    private javax.swing.JLabel jPrecio2;
    private javax.swing.JLabel jPrecio3;
    private javax.swing.JLabel jPrecio4;
    private javax.swing.JLabel jPrecio5;
    private Vista.MyButton myButton1;
    private Vista.MyButton myButton5;
    private Vista.MyButton myButton6;
    private Vista.MyButton myButton7;
    private Vista.MyButton myButton8;
    private Clases.PanelRound panelRound1;
    private Clases.PanelRound panelRound2;
    private Clases.PanelRound panelRound3;
    private Clases.PanelRound panelRound4;
    private Clases.PanelRound panelRound5;
    private Clases.PanelRound panelRound6;
    // End of variables declaration//GEN-END:variables
}
