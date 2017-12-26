/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.dataConnection;

/**
 *
 * @author user
 */
public class VentanaIngresoAdministrador extends JFrame {

    Connection cn;
    PreparedStatement pst;
    ResultSet rst;

    public static VentanaIngresoAdministrador ventana;
    
    /**
     * Creates new form LogInAdministrador
     */
    public VentanaIngresoAdministrador() {
        initComponents();
        
        this.getContentPane().setBackground(Color.white);
    }

    public static VentanaIngresoAdministrador getInstanceSingleton(){
        if(ventana==null){
            ventana=new VentanaIngresoAdministrador();
        }
        return ventana;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordAdministrador = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNickname = new javax.swing.JTextField();
        jButtonIniciarSesion = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio Sesion Administrador");
        setIconImage(getIconImage());
        setName("VentanaLogInAdminstrador"); // NOI18N
        setResizable(false);

        jPasswordAdministrador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordAdministradorKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Ingreso Administrador");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Ingresar el nombre de usuario del administrador y su contraseña");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre de Usuario:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Contraseña:");

        jTextFieldNickname.setEditable(false);
        jTextFieldNickname.setText("administrador");

        jButtonIniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonIniciarSesion.setText("Iniciar Sesión");
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });

        jButtonAtras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAtras.setText("Atrás");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonIniciarSesion)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAtras))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNickname)
                                .addComponent(jPasswordAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        // TODO add your handling code here:

        String nickname = jTextFieldNickname.getText();

        char[] arrayC = jPasswordAdministrador.getPassword();
        if (arrayC.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor Ingrear una contraseña.", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            String password = new String(arrayC);
            cn = dataConnection.conexion();
            try {
                pst = cn.prepareStatement("select * from administrador where nickname=? and password=?");
                pst.setString(1, nickname);
                pst.setString(2, password);
                rst = pst.executeQuery();

                if (rst.next()) {
                   JOptionPane.showMessageDialog(null, "Bienvenido " + rst.getString("nombres"));
                   VentanaAdministrador.getInstanceSingleton().setVisible(true);
                   this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña erronea");
                    jPasswordAdministrador.setText("");
                }
            } catch (SQLException e1) {

                e1.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        
        VentanaPrincipal.getInstaceSingleton().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jPasswordAdministradorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordAdministradorKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonIniciarSesionActionPerformed(null);
        }
    }//GEN-LAST:event_jPasswordAdministradorKeyPressed

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/Escudo.png"));

        return retValue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordAdministrador;
    private javax.swing.JTextField jTextFieldNickname;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param cadena
     * @return
     */
    public boolean validarTexto(String cadena) {
        return !(cadena == null && cadena.isEmpty() && cadena.length() == 0);
    }

}
