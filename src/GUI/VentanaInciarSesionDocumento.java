/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.dataConnection;
import logica.institutoMontenegro;

/**
 *
 * @author user
 */
public class VentanaInciarSesionDocumento extends javax.swing.JFrame {

    int doc;
    institutoMontenegro instituto;
    // atributos para el manejo de la base de datos
    PreparedStatement pst;
    Connection cn;
    ResultSet result;
    public static VentanaInciarSesionDocumento ventana;

    /**
     * Creates new form InciarSesionDocumenot
     */
    public VentanaInciarSesionDocumento() {
        initComponents();
        instituto=new institutoMontenegro();
    }

    /**
     * 
     * @return 
     */
      public static VentanaInciarSesionDocumento getInstaceSingleton(){
        if(ventana==null){
            ventana= new VentanaInciarSesionDocumento();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonRegistrarIngreso = new javax.swing.JButton();
        jTextFieldDocumentoIdentidad = new javax.swing.JTextField();
        jButtonAtras = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelMensaje = new javax.swing.JLabel();
        jLabelDocuentoRegistroEstudiante = new javax.swing.JLabel();
        jLabelNombresRegistrarEstudiante = new javax.swing.JLabel();
        jLabelApellidosRegistrarEstudiante = new javax.swing.JLabel();
        jTextFieldDocumentoRegistrarEstudiante = new javax.swing.JTextField();
        jTextFieldNombreRegistrarEstudiante = new javax.swing.JTextField();
        jTextFieldApellidosRegistrarEstudiante = new javax.swing.JTextField();
        jButtonRegistrarEstudiante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Ingreso Por Documento");
        setIconImage(getIconImage());
        setName("VentanaRegistrarIngreoDoc"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Iniciar Sesión Por Documento");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Documento T.I/C.C:");

        jButtonRegistrarIngreso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonRegistrarIngreso.setText("Registrar Ingreso");
        jButtonRegistrarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarIngresoActionPerformed(evt);
            }
        });

        jTextFieldDocumentoIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDocumentoIdentidadKeyTyped(evt);
            }
        });

        jButtonAtras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAtras.setText("Atras");
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Estudiante"));

        jLabelMensaje.setBackground(new java.awt.Color(255, 51, 51));
        jLabelMensaje.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabelMensaje.setText("Estudiante Ocasional por favor llena los siguentes campos");

        jLabelDocuentoRegistroEstudiante.setText("Documento C.C/T.I:");

        jLabelNombresRegistrarEstudiante.setText("Nombres:");

        jLabelApellidosRegistrarEstudiante.setText("Apellidos:");

        jTextFieldDocumentoRegistrarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDocumentoRegistrarEstudianteActionPerformed(evt);
            }
        });
        jTextFieldDocumentoRegistrarEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDocumentoRegistrarEstudianteKeyTyped(evt);
            }
        });

        jTextFieldNombreRegistrarEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreRegistrarEstudianteKeyTyped(evt);
            }
        });

        jTextFieldApellidosRegistrarEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidosRegistrarEstudianteKeyTyped(evt);
            }
        });

        jButtonRegistrarEstudiante.setText("Registrar Estudiante");
        jButtonRegistrarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarEstudianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonRegistrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNombresRegistrarEstudiante)
                            .addComponent(jLabelDocuentoRegistroEstudiante)
                            .addComponent(jLabelApellidosRegistrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombreRegistrarEstudiante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jTextFieldApellidosRegistrarEstudiante, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDocumentoRegistrarEstudiante))))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDocumentoRegistrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDocuentoRegistroEstudiante))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreRegistrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombresRegistrarEstudiante))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldApellidosRegistrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidosRegistrarEstudiante))
                .addGap(18, 18, 18)
                .addComponent(jButtonRegistrarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRegistrarIngreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAtras))
                    .addComponent(jTextFieldDocumentoIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDocumentoIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrarIngreso)
                    .addComponent(jButtonAtras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Registrar Estudiante Ocasional");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // TODO add your handling code here:
        VentanaIngresoEstudiante ventana = new VentanaIngresoEstudiante();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonRegistrarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarEstudianteActionPerformed
        if(jTextFieldDocumentoRegistrarEstudiante.getText().length()<=11){
        try {
            // TODO add your handling code here:
            String nombres = jTextFieldNombreRegistrarEstudiante.getText();
            String apellidos = jTextFieldApellidosRegistrarEstudiante.getText();
            String doc = jTextFieldDocumentoRegistrarEstudiante.getText();
           
            int documento;

            if (validarDocumento(doc)) {
                documento = Integer.parseInt(doc);
                this.doc = documento;
                //validar que ingrese los campos obligatorios para registrar en
                //la base de datos
                if (nombres.length() != 0 && apellidos.length() != 0 && documento != 0) {
                    Date fecha; // TODO Auto-generated catch block
                    fecha = (Date) instituto.fechaHoy();

                    cn = dataConnection.conexion();

                    try {
                        pst = cn.prepareStatement("insert into estudiante_ocasional(documento,nombres,apellidos,fechaIngreso)values (?,?,?,?)");

                        pst.setInt(1, documento);
                        pst.setString(2, nombres);
                        pst.setString(3, apellidos);
                        pst.setDate(4, fecha);

                        int res = pst.executeUpdate();
                        if (res > 0) {

                            JOptionPane.showMessageDialog(null, "Se ha guardado el registro(estudiante Ocasional)");
                            jTextFieldDocumentoIdentidad.setText("");
                            jTextFieldApellidosRegistrarEstudiante.setText("");
                            jTextFieldDocumentoRegistrarEstudiante.setText("");
                            jTextFieldNombreRegistrarEstudiante.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "Algo salio mal, vuelve a intentar");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VentanaInciarSesionDocumento.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            //validar que ingrese los campos
        } catch (ParseException ex) {
            Logger.getLogger(VentanaInciarSesionDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }}else{
            JOptionPane.showMessageDialog(null, "Documento con mas de 11 digitos, vuelva a intentar");
            jTextFieldApellidosRegistrarEstudiante.setText("");
            jTextFieldDocumentoRegistrarEstudiante.setText("");
            jTextFieldNombreRegistrarEstudiante.setText("");
        }
    }//GEN-LAST:event_jButtonRegistrarEstudianteActionPerformed

    private void jButtonRegistrarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarIngresoActionPerformed
      if(jTextFieldDocumentoIdentidad.getText().length()<=11){
        try {
            // TODO add your handling code here:

            int documento = Integer.parseInt(jTextFieldDocumentoIdentidad.getText());
            Date fecha;
            Date ultimoIngresoFecha;
            fecha = (Date) instituto.fechaHoy();
            ultimoIngresoFecha = (Date) instituto.ultimaFechaIngreso(documento);

            instituto.actualizarUltimoIngreso(fecha, documento);
            cn = dataConnection.conexion();
            try {
                pst = cn.prepareStatement("select * from estudiante where documento=?");
                pst.setInt(1, documento);

                result = pst.executeQuery();
                if (result.next()) {
                    if (instituto.validarFechas(fecha, ultimoIngresoFecha) == false) {
                        instituto.insertarRegistro(documento, fecha, ultimoIngresoFecha);
                        JOptionPane.showMessageDialog(null, "Bienvenido estudiante");
                        jTextFieldDocumentoIdentidad.setText("");
                        jTextFieldApellidosRegistrarEstudiante.setText("");
                        jTextFieldDocumentoRegistrarEstudiante.setText("");
                        jTextFieldNombreRegistrarEstudiante.setText("");
                    } else {

                        JOptionPane.showMessageDialog(null, "EL ESTUDIANTE YA INGRESO!!");
                        jTextFieldDocumentoIdentidad.setText("");
                        jTextFieldApellidosRegistrarEstudiante.setText("");
                        jTextFieldDocumentoRegistrarEstudiante.setText("");
                        jTextFieldNombreRegistrarEstudiante.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El estudiante no se encuentra en la base de datos");
                    jTextFieldDocumentoIdentidad.setText("");
                    jTextFieldApellidosRegistrarEstudiante.setText("");
                    jTextFieldDocumentoRegistrarEstudiante.setText("");
                    jTextFieldNombreRegistrarEstudiante.setText("");
                }
            } catch (SQLException | ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } catch (ParseException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
      }else{
          limpiar();
          JOptionPane.showMessageDialog(null, "Identificacion con mas de 11 digitos, vuelve a ingresar");
      
      
      }

    }//GEN-LAST:event_jButtonRegistrarIngresoActionPerformed

    private void jTextFieldDocumentoRegistrarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDocumentoRegistrarEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDocumentoRegistrarEstudianteActionPerformed

    private void jTextFieldDocumentoIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDocumentoIdentidadKeyTyped
        // TODO add your handling code here:
        noTeclearLetras(evt);
        noteclearCaracteres(evt);
    }//GEN-LAST:event_jTextFieldDocumentoIdentidadKeyTyped

    private void jTextFieldDocumentoRegistrarEstudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDocumentoRegistrarEstudianteKeyTyped
        // TODO add your handling code here:
        noTeclearLetras(evt);
        noteclearCaracteres(evt);
    }//GEN-LAST:event_jTextFieldDocumentoRegistrarEstudianteKeyTyped

    private void jTextFieldNombreRegistrarEstudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreRegistrarEstudianteKeyTyped
        // TODO add your handling code here:
        noTeclearNumeros(evt);
        noteclearCaracteres(evt);
    }//GEN-LAST:event_jTextFieldNombreRegistrarEstudianteKeyTyped

    private void jTextFieldApellidosRegistrarEstudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidosRegistrarEstudianteKeyTyped
        // TODO add your handling code here:
        noTeclearNumeros(evt);
        noteclearCaracteres(evt);
    }//GEN-LAST:event_jTextFieldApellidosRegistrarEstudianteKeyTyped

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/Escudo.png"));

        return retValue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonRegistrarEstudiante;
    private javax.swing.JButton jButtonRegistrarIngreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelApellidosRegistrarEstudiante;
    private javax.swing.JLabel jLabelDocuentoRegistroEstudiante;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JLabel jLabelNombresRegistrarEstudiante;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldApellidosRegistrarEstudiante;
    private javax.swing.JTextField jTextFieldDocumentoIdentidad;
    private javax.swing.JTextField jTextFieldDocumentoRegistrarEstudiante;
    private javax.swing.JTextField jTextFieldNombreRegistrarEstudiante;
    // End of variables declaration//GEN-END:variables

    public void limpiar(){
    jTextFieldDocumentoRegistrarEstudiante.setText("");
      jTextFieldNombreRegistrarEstudiante.setText("");
      jTextFieldApellidosRegistrarEstudiante.setText("");
    }
    /**
     * Metodo que permite validar que el documento sea de 10 caracteres
     *
     * @param documento
     * @return
     */
    public boolean validarDocumento(String documento) {
        boolean resultado = false;

        if (documento.length() <= 11) {
            for (int i = 0; i < documento.length(); i++) {
                if (esNumero(documento.charAt(i))) {
                    resultado = true;
                } else {
                    return false;
                }
            }

        }
        return resultado;
    }

    public Date fechaInicio() {
        String date1 = "1999-05-24";
        Date fecha = java.sql.Date.valueOf(date1);
        return fecha;
    }

    /**
     * Metodo que permite validar si el char ingresado es numero
     *
     * @param c
     * @return flag
     */
    private boolean esNumero(char c) {
        if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
                || c == '0') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que permite registrar el ingreso de los estudiantes que poseen una
     * huella
     */
    public void registrarIngreso() throws ParseException {
        Date fecha; // TODO Auto-generated catch block
        Date ultimoIngresoFecha;
        fecha = (Date) instituto.fechaHoy();
        ultimoIngresoFecha = (Date) instituto.ultimaFechaIngreso(doc);
        instituto.actualizarUltimoIngreso(fecha, doc);
        cn = dataConnection.conexion();
        try {
            pst = cn.prepareStatement("select * from estudiante_ocasional where documento=?");
            pst.setInt(1, doc);

            result = pst.executeQuery();
            if (result.next()) {
                if (instituto.validarFechas(fecha, ultimoIngresoFecha) == false) {
                    instituto.insertarRegistro(doc, fecha, ultimoIngresoFecha);
                    JOptionPane.showMessageDialog(null, "Bienvenido estudiante");
                } else {

                    JOptionPane.showMessageDialog(null, "EL ESTUDIANTE YA INGRESO!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El estudiante no se encuentra en la base de datos");
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(VentanaIngresoEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void noteclearCaracteres(KeyEvent evt) {
        int cadena = (int) evt.getKeyChar();
        if (cadena >= 33 && cadena <= 47
                || cadena >= 58 && cadena <= 64
                || cadena >= 91 && cadena <= 96
                || cadena >= 123 && cadena <= 127) {
            JOptionPane.showMessageDialog(null, "no ingrese caracteres especiales en los campos de texto");
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }

    }

    /**
     * Metodo para cuando se dijite una letra en un campo de numeros
     *
     * @param evt
     */
    public void noTeclearLetras(KeyEvent evt) {
        if (Character.isLetter((char) evt.getKeyChar())) {
            JOptionPane.showMessageDialog(null, "INGRESE SOLO NÚMEROS");
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }

    /**
     * Metodo para cuando se dijite un numero en un campo de letras
     *
     * @param evt
     */
    public void noTeclearNumeros(KeyEvent evt) {
        if (Character.isDigit((char) evt.getKeyChar())) {
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS");
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }
}
