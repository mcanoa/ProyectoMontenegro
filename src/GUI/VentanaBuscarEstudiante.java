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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.dataConnection;

/**
 *
 * @author user
 */
public class VentanaBuscarEstudiante extends javax.swing.JFrame {

    PreparedStatement pst;
    Connection cn;
    ResultSet res;

    
    /**
     * Creates new form BuscarEstudiante
     */
    public VentanaBuscarEstudiante() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBuscarEstudiante = new javax.swing.JPanel();
        jLabelDocumentoBuscar = new javax.swing.JLabel();
        jTextFieldDocumentoABuscar = new javax.swing.JTextField();
        jButtonBuscarEstudiante = new javax.swing.JButton();
        jComboBoxTipoBusqueda = new javax.swing.JComboBox<String>();
        jPanelDatosEstudiante = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldGrado = new javax.swing.JTextField();
        jTextFieldSexo = new javax.swing.JTextField();
        jTextFieldDocumento = new javax.swing.JTextField();
        jTextFieldTipoPoblacion = new javax.swing.JTextField();
        jTextFieldMetodologia = new javax.swing.JTextField();
        jPanelHuellaEstudiante = new javax.swing.JPanel();
        jPanelContenedorHuella = new javax.swing.JPanel();
        jLabelImagenHuella = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Estudiante");
        setIconImage(getIconImage());
        setName("VentanaBuscarEstudiante"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanelBuscarEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBuscarEstudiante.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Estudiante", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabelDocumentoBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelDocumentoBuscar.setText("Documento Del Estudiante:");

        jTextFieldDocumentoABuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldDocumentoABuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDocumentoABuscarKeyTyped(evt);
            }
        });

        jButtonBuscarEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonBuscarEstudiante.setText("Buscar Estudiante");
        jButtonBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEstudianteActionPerformed(evt);
            }
        });

        jComboBoxTipoBusqueda.setBackground(new java.awt.Color(240, 240, 240));
        jComboBoxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Documento" }));

        javax.swing.GroupLayout jPanelBuscarEstudianteLayout = new javax.swing.GroupLayout(jPanelBuscarEstudiante);
        jPanelBuscarEstudiante.setLayout(jPanelBuscarEstudianteLayout);
        jPanelBuscarEstudianteLayout.setHorizontalGroup(
            jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                        .addComponent(jLabelDocumentoBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDocumentoABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxTipoBusqueda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarEstudianteLayout.createSequentialGroup()
                        .addGap(0, 425, Short.MAX_VALUE)
                        .addComponent(jButtonBuscarEstudiante)))
                .addContainerGap())
        );
        jPanelBuscarEstudianteLayout.setVerticalGroup(
            jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarEstudianteLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanelBuscarEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocumentoBuscar)
                    .addComponent(jTextFieldDocumentoABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarEstudiante))
        );

        jPanelDatosEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDatosEstudiante.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Estudiante"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Documento C.C/T.I:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombres:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Grado:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Sexo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tipo Población:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Metodología:");

        jTextFieldNombres.setEditable(false);
        jTextFieldNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldNombres.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNombres.setDoubleBuffered(true);

        jTextFieldApellidos.setEditable(false);
        jTextFieldApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldApellidos.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldApellidos.setDoubleBuffered(true);

        jTextFieldGrado.setEditable(false);
        jTextFieldGrado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldGrado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldGrado.setDoubleBuffered(true);

        jTextFieldSexo.setEditable(false);
        jTextFieldSexo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldSexo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldSexo.setDoubleBuffered(true);

        jTextFieldDocumento.setEditable(false);
        jTextFieldDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldDocumento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldDocumento.setDoubleBuffered(true);

        jTextFieldTipoPoblacion.setEditable(false);

        jTextFieldMetodologia.setEditable(false);

        javax.swing.GroupLayout jPanelDatosEstudianteLayout = new javax.swing.GroupLayout(jPanelDatosEstudiante);
        jPanelDatosEstudiante.setLayout(jPanelDatosEstudianteLayout);
        jPanelDatosEstudianteLayout.setHorizontalGroup(
            jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosEstudianteLayout.createSequentialGroup()
                .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosEstudianteLayout.createSequentialGroup()
                        .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosEstudianteLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(26, 26, 26))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTipoPoblacion, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(jTextFieldMetodologia)))
                    .addGroup(jPanelDatosEstudianteLayout.createSequentialGroup()
                        .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDocumento)
                            .addComponent(jTextFieldApellidos)
                            .addComponent(jTextFieldGrado)
                            .addComponent(jTextFieldSexo)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanelDatosEstudianteLayout.setVerticalGroup(
            jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosEstudianteLayout.createSequentialGroup()
                .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTipoPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldMetodologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanelHuellaEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHuellaEstudiante.setBorder(javax.swing.BorderFactory.createTitledBorder("Huella Estudiante"));

        jPanelContenedorHuella.setBackground(new java.awt.Color(255, 255, 255));

        jLabelImagenHuella.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelContenedorHuellaLayout = new javax.swing.GroupLayout(jPanelContenedorHuella);
        jPanelContenedorHuella.setLayout(jPanelContenedorHuellaLayout);
        jPanelContenedorHuellaLayout.setHorizontalGroup(
            jPanelContenedorHuellaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorHuellaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenHuella, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelContenedorHuellaLayout.setVerticalGroup(
            jPanelContenedorHuellaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorHuellaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenHuella, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelHuellaEstudianteLayout = new javax.swing.GroupLayout(jPanelHuellaEstudiante);
        jPanelHuellaEstudiante.setLayout(jPanelHuellaEstudianteLayout);
        jPanelHuellaEstudianteLayout.setHorizontalGroup(
            jPanelHuellaEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedorHuella, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelHuellaEstudianteLayout.setVerticalGroup(
            jPanelHuellaEstudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedorHuella, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Buscar un estudiante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelDatosEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelHuellaEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanelBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelDatosEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHuellaEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEstudianteActionPerformed
        
        String docu=jTextFieldDocumentoABuscar.getText();
        
        String tipoBusqueda=(String) jComboBoxTipoBusqueda.getSelectedItem();
         switch(tipoBusqueda){
             case "Documento":
                 break;
             case "Nombre":
                 break;
         }
        if(tipoBusqueda.equals("Documento")){
            try {
                // TODO add your handling code here:
                if(docu.length()<11){
                int documento = Integer.parseInt(jTextFieldDocumentoABuscar.getText());
                cn = dataConnection.conexion();
                pst = cn.prepareStatement(
                        "select documento,nombres,apellidos,grado,sexo,tipoPoblacion,modeloPedagogico from estudiante WHERE documento=?");
                pst.setInt(1, documento);
                res = pst.executeQuery();

                if (res.next()) {

                    jTextFieldDocumento.setText(String.valueOf(res.getInt("documento")));
                    jTextFieldNombres.setText(res.getString("nombres"));
                    jTextFieldApellidos.setText(res.getString("apellidos"));
                    jTextFieldGrado.setText(res.getString("grado"));
                    jTextFieldSexo.setText(res.getString("sexo"));
                    jTextFieldTipoPoblacion.setText(res.getString("tipoPoblacion"));
                    jTextFieldMetodologia.setText(res.getString("modeloPedagogico"));

                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "El estudiante no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                }else{
                    jTextFieldDocumentoABuscar.setText("");
                    JOptionPane.showMessageDialog(null, "Documento invalido");
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentanaBuscarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(tipoBusqueda.equals("Nombre")){
            //separar la cadena en nombres y apellidos
            String[] partes=docu.split(" ");
            String apellidos= partes[partes.length-2]+" "+partes[partes.length-1];
            
            String nombres = "";
            for(int i=0;i<partes.length-2;i++){
                nombres=nombres+partes[i]+" ";
            }
            
            try {
                buscarNombre(nombres, apellidos);
            } catch (Exception ex) {
                Logger.getLogger(VentanaBuscarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(tipoBusqueda.equals("DOCUMENTOINVALIDO")){
            jTextFieldDocumentoABuscar.setText("");
            JOptionPane.showMessageDialog(null, "Documento mayor a 11 digitos, ingrese de nuevo el numero");
        }
        
    }//GEN-LAST:event_jButtonBuscarEstudianteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        VentanaAdministrador.cambiarestado(true);
    }//GEN-LAST:event_formWindowClosed

    private void jTextFieldDocumentoABuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDocumentoABuscarKeyTyped
        // TODO add your handling code here:
       // noTeclearLetras(evt);
        noteclearCaracteres(evt);
    }//GEN-LAST:event_jTextFieldDocumentoABuscarKeyTyped

    public void limpiar() {
        jTextFieldDocumentoABuscar.setText("");
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/Escudo.png"));

        return retValue;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarEstudiante;
    private javax.swing.JComboBox<String> jComboBoxTipoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDocumentoBuscar;
    private javax.swing.JLabel jLabelImagenHuella;
    private javax.swing.JPanel jPanelBuscarEstudiante;
    private javax.swing.JPanel jPanelContenedorHuella;
    private javax.swing.JPanel jPanelDatosEstudiante;
    private javax.swing.JPanel jPanelHuellaEstudiante;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldDocumento;
    private javax.swing.JTextField jTextFieldDocumentoABuscar;
    private javax.swing.JTextField jTextFieldGrado;
    private javax.swing.JTextField jTextFieldMetodologia;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldSexo;
    private javax.swing.JTextField jTextFieldTipoPoblacion;
    // End of variables declaration//GEN-END:variables

    public void noteclearCaracteres(KeyEvent evt) {
        int cadena = (int) evt.getKeyChar();
        if (cadena >= 33 && cadena <= 47
                || cadena >= 58 && cadena <= 64
                || cadena >= 91 && cadena <= 96
                || cadena >= 123 && cadena <= 127) {
            JOptionPane.showMessageDialog(null, "no ingrese caracters especiales en los campos de texo");
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

    /**
     * Metodo que permite buscar un estudiante por el nombres y apellidos
     * @param nombre, nombre del estudiante.
     * @param apellidos, apellidos del estudiante.
     * @throws java.lang.Exception
     */
    public void buscarNombre(String nombre, String apellidos) throws Exception{
        
        
        if(nombre!=null && apellidos != null){
            cn = dataConnection.conexion();
                pst = cn.prepareStatement(
                        "select documento,nombres,apellidos,grado,sexo,tipoPoblacion,modeloPedagogico from estudiante WHERE nombres=? && apellidos=?");
                pst.setString(1, nombre);
                pst.setString(2, apellidos);
                res = pst.executeQuery();
                if (res.next()) {

                    jTextFieldDocumento.setText(String.valueOf(res.getInt("documento")));
                    jTextFieldNombres.setText(res.getString("nombres"));
                    jTextFieldApellidos.setText(res.getString("apellidos"));
                    jTextFieldGrado.setText(res.getString("grado"));
                    jTextFieldSexo.setText(res.getString("sexo"));
                    jTextFieldTipoPoblacion.setText(res.getString("tipoPoblacion"));
                    jTextFieldMetodologia.setText(res.getString("modeloPedagogico"));

                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "El estudiante no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

        }
    }
    
   
}
