/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import logica.dataConnection;
import logica.institutoMontenegro;

/**
 *
 * @author user
 */
public class VentanaCrearEstudiante extends javax.swing.JFrame {

    institutoMontenegro instituto;


    // atributos para el manejo de la base de datos
    PreparedStatement pst;
    Connection cn;
    ResultSet result;

    /**
     * Creates new form VentanaCrearEstudiante
     */
    public VentanaCrearEstudiante() {
        instituto= new institutoMontenegro();
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

        jLabelDocumento = new javax.swing.JLabel();
        jLabelNombres = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelGrado = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelMetodologia = new javax.swing.JLabel();
        jLabelTipoPoblacion = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldDocumento = new javax.swing.JTextField();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jComboBoxJornada = new javax.swing.JComboBox<>(metodologias);
        jComboBoxZonaAlumno = new javax.swing.JComboBox<>(tipoPoblacion);
        jComboBoxGrupo = new javax.swing.JComboBox<>(genero);
        jButtonCrearEstudiante = new javax.swing.JButton();
        jPanelHuella = new javax.swing.JPanel();
        jPanelContenedorHuella = new javax.swing.JPanel();
        jLabelImagenHuella = new javax.swing.JLabel();
        jButtonGuardarHuella = new javax.swing.JButton();
        jComboBoxGrado = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Estudiante");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabelDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelDocumento.setText("Documento C.C/T.I:");

        jLabelNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNombres.setText("Nombres:");

        jLabelApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelApellidos.setText("Apellidos:");

        jLabelGrado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelGrado.setText("Grado:");

        jLabelSexo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelSexo.setText("Grupo:");

        jLabelMetodologia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMetodologia.setText("Jornada:");

        jLabelTipoPoblacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelTipoPoblacion.setText("Zona Alumno:");

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTitulo.setText("Crear Estudiante");

        jTextFieldDocumento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDocumentoKeyTyped(evt);
            }
        });

        jTextFieldNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombresKeyTyped(evt);
            }
        });

        jTextFieldApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidosKeyTyped(evt);
            }
        });

        jComboBoxJornada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jComboBoxZonaAlumno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButtonCrearEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCrearEstudiante.setText("Guardar Estudiante");
        jButtonCrearEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearEstudianteActionPerformed(evt);
            }
        });

        jPanelHuella.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHuella.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huella Dactilar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelContenedorHuellaLayout = new javax.swing.GroupLayout(jPanelContenedorHuella);
        jPanelContenedorHuella.setLayout(jPanelContenedorHuellaLayout);
        jPanelContenedorHuellaLayout.setHorizontalGroup(
            jPanelContenedorHuellaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenedorHuellaLayout.createSequentialGroup()
                .addComponent(jLabelImagenHuella, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelContenedorHuellaLayout.setVerticalGroup(
            jPanelContenedorHuellaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenedorHuellaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenHuella, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelHuellaLayout = new javax.swing.GroupLayout(jPanelHuella);
        jPanelHuella.setLayout(jPanelHuellaLayout);
        jPanelHuellaLayout.setHorizontalGroup(
            jPanelHuellaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHuellaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelContenedorHuella, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHuellaLayout.setVerticalGroup(
            jPanelHuellaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHuellaLayout.createSequentialGroup()
                .addComponent(jPanelContenedorHuella, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonGuardarHuella.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGuardarHuella.setText("Guardar Huella");
        jButtonGuardarHuella.setEnabled(false);
        jButtonGuardarHuella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarHuellaActionPerformed(evt);
            }
        });

        jComboBoxGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCrearEstudiante)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelDocumento)
                                .addComponent(jLabelNombres, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelSexo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelGrado, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabelApellidos)
                            .addComponent(jLabelMetodologia)
                            .addComponent(jLabelTipoPoblacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDocumento)
                            .addComponent(jTextFieldNombres)
                            .addComponent(jTextFieldApellidos)
                            .addComponent(jComboBoxJornada, 0, 197, Short.MAX_VALUE)
                            .addComponent(jComboBoxZonaAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxGrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelHuella, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGuardarHuella))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addComponent(jPanelHuella, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDocumento)
                            .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombres)
                            .addComponent(jTextFieldNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelApellidos)
                            .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelGrado)
                            .addComponent(jComboBoxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSexo)
                            .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMetodologia)
                            .addComponent(jComboBoxJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipoPoblacion)
                            .addComponent(jComboBoxZonaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrearEstudiante)
                    .addComponent(jButtonGuardarHuella))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para crear un estudiante en el sistema y agregarlo a la base de datos
     * @param evt 
     */
    private void jButtonCrearEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearEstudianteActionPerformed
        
        int eleccion = JOptionPane.showConfirmDialog(null, "Seguro desea guardar el estudiante", "CONFIRMAR", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (eleccion == JOptionPane.YES_OPTION) {
            
            String nombres = jTextFieldNombres.getText();
            String apellidos = jTextFieldApellidos.getText();
            String doc = jTextFieldDocumento.getText();
            String grado = (String) jComboBoxGrado.getSelectedItem();
           /*Cambiar metodo sexo a grupo y la seleccion de sexto a once*/
            String grupo = sexoF((String) jComboBoxGrupo.getSelectedItem());
            String tipoPoblacionEstudiante = (String) jComboBoxZonaAlumno.getSelectedItem();
            String metodologia = (String) jComboBoxJornada.getSelectedItem();

            int documento;
            if (validarDocumento(doc) && validarNombreCompleto(apellidos)) {
                documento = Integer.parseInt(doc);
                if (!validarDoc(documento)) {
                    // Validar que ingrese los campos obligatorios para registrarlo en
                    // la base de datos
                    if (nombres.length() != 0 && apellidos.length() != 0 && documento != 0 && grado.length() != 0) {
                        cn = dataConnection.conexion();
                        try {
                            pst = cn.prepareStatement("insert into estudiante (documento,grupo,grado,apellidos,nombres,"
                                    + "zonaAlumno,nombreGrupo,jornada) values (?,?,?,?,?,?,?,?)");

                            pst.setInt(1, documento);
                            pst.setString(2, nombres);
                            pst.setString(3, apellidos);
                            pst.setString(4, grado);
                            pst.setString(5, grupo);
                            pst.setString(6, tipoPoblacionEstudiante);
                            pst.setString(7, metodologia);

                            int res = pst.executeUpdate();
                            if (res > 0) {
                                Date fecha = fechaIncio();
                                try {
                                    
                                    instituto.insertarRegistro(documento, fecha, fecha);
                                } catch (ParseException e1) {

                                    e1.printStackTrace();
                                }

                                setCampos();
                                eleccion = JOptionPane.showConfirmDialog(null, "Desea registrar una huella dactilar al estudiante", "TOMAR HUELLA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (eleccion == JOptionPane.YES_OPTION) {

                                    start();
                                    Iniciar();
                                    JOptionPane.showMessageDialog(null, "Por favor, colocar el dedo indice 4 veces\n en el lector de huellas");

                                }
                                if (eleccion == JOptionPane.NO_OPTION) {
                                    JOptionPane.showMessageDialog(null, "El estudiante se guardó exitosamente");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "ups...ocurrio un problema");
                            }
                            cn.close();
                        } catch (SQLException e1) {

                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por Favor llenar todos los campos de texto");
                    }
                } else {
                   
                    JOptionPane.showMessageDialog(null, "Ya existe un estudiante con ese documento");
                }
            } else {
                 JOptionPane.showMessageDialog(null, "Por favor, ingrese un documento valido y \nel nombre completo del estudiante");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante no se guardó");
        }

    }//GEN-LAST:event_jButtonCrearEstudianteActionPerformed

    private void jButtonGuardarHuellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarHuellaActionPerformed
        // TODO add your handling code here:
        String documento = jTextFieldDocumento.getText();

        guardarHuella(documento);
        Reclutador.clear();
        jLabelImagenHuella.setIcon(null);
        stop();
        jTextFieldApellidos.setEditable(true);
        jTextFieldDocumento.setEditable(true);
        jComboBoxGrado.setEditable(true);
        jTextFieldNombres.setEditable(true);
        

    }//GEN-LAST:event_jButtonGuardarHuellaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        VentanaAdministrador.cambiarestado(true);
    }//GEN-LAST:event_formWindowClosed

    private void jTextFieldDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDocumentoKeyTyped
        noteclearCaracteres(evt);
        noTeclearLetras(evt);
    }//GEN-LAST:event_jTextFieldDocumentoKeyTyped

    private void jTextFieldNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombresKeyTyped
        noTeclearNumeros(evt);
        noteclearCaracteres(evt);
    }//GEN-LAST:event_jTextFieldNombresKeyTyped

    private void jTextFieldApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidosKeyTyped
        noTeclearNumeros(evt);
        noteclearCaracteres(evt);
    }//GEN-LAST:event_jTextFieldApellidosKeyTyped

    private void jComboBoxGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGradoActionPerformed

    /**
     * 
     */
    public void limpiar() {
        jTextFieldDocumento.setText("");
        jTextFieldNombres.setText("");
        jTextFieldApellidos.setText("");
        jComboBoxGrado.setSelectedItem("");
        jComboBoxGrupo.setSelectedIndex(0);
        jComboBoxZonaAlumno.setSelectedItem(0);
        jComboBoxJornada.setSelectedItem(0);
    }

    /**
     * 
     * @return 
     */
    public Date fechaIncio() {
        String date1 = "1999-05-24";
        Date fecha = java.sql.Date.valueOf(date1);
        return fecha;
    }

    /**
     * 
     */
    public void setCampos() {
        jTextFieldApellidos.setEditable(false);
        jTextFieldNombres.setEditable(false);
        jTextFieldDocumento.setEditable(false);
        jComboBoxGrado.setEditable(false);
        jComboBoxJornada.setEditable(false);
        jComboBoxGrupo.setEditable(false);
        jComboBoxZonaAlumno.setEditable(false);
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
     * Metodo que permite validar que los campos esten llenos
     * @param documento
     * @param nombre
     * @param apellidos
     * @param grado
     * @return 
     */
    public boolean validarCamposObligatorios(JTextField documento, JTextField nombre, JTextField apellidos,
            JTextField grado) {

        return false;
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

    /**
     * Borrar
     * @param sexo
     * @return 
     */
    public String sexoF(String sexo) {
        if ("FEMENINO".equals(sexo)) {
            return "F";
        } else {
            return "M";
        }
    }

    /**
     * 
     * @return 
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/Escudo.png"));

        return retValue;
    }
    // Varible que permite iniciar el dispositivo de lector de huella conectado
    // con sus distintos metodos.
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

    // Varible que permite establecer las capturas de la huellas, para determina
    // sus caracteristicas
    // y poder estimar la creacion de un template de la huella para luego poder
    // guardarla
    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    // Esta variable tambien captura una huella del lector y crea sus
    // caracteristcas para auntetificarla
    // o verificarla con alguna guardada en la BD
    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

    // Variable que para crear el template de la huella luego de que se hallan
    // creado las caracteriticas
    // necesarias de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";

    /**
     * Metodo que sirve para iniciar el lector de huellas
     */
    protected void Iniciar() {
        Lector.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("La Huella Digital ha sido Capturada");
                        ProcesarCaptura(e.getSample());
                    }
                });
            }
        });

        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El Sensor de Huella Digital esta
                        // Activado o Conectado");
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El Sensor de Huella Digital esta
                        // Desactivado o no Conectado");
                    }
                });
            }
        });

        Lector.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El dedo ha sido colocado sobre el Lector
                        // de Huella");
                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El dedo ha sido quitado del Lector de
                        // Huella");
                    }
                });
            }
        });

        Lector.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("Error: "+e.getError());
                    }
                });
            }
        });
    }

    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;

    public void ProcesarCaptura(DPFPSample sample) {
        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el proposito de inscripcion.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el proposito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo a�ade a su
        // reclutador si es bueno
        if (featuresinscripcion != null) {
            try {
                System.out.println("Las Características de la Huella han sido creada");
                Reclutador.addFeatures(featuresinscripcion);// Agregar las
                // caracteristicas
                // de la huella a la
                // plantilla a crear

                // Dibuja la huella dactilar capturada.
                Image image = CrearImagenHuella(sample);
                DibujarHuella(image);

                // btnVerificar.setEnabled(true);
                // btnIdentificar.setEnabled(true);
            } catch (DPFPImageQualityException ex) {
                System.err.println("Error: " + ex.getMessage());
            } finally {
                // EstadoHuellas();
                // Comprueba si la plantilla se ha creado.
                switch (Reclutador.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY: // informe de exito y detiene la
                        // captura de huellas
                        stop();
                        setTemplate(Reclutador.getTemplate());
                        // EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya
                        // puede Verificarla o Identificarla");
                        // btnIdentificar.setEnabled(false);
                        // btnVerificar.setEnabled(false);
                        JOptionPane.showMessageDialog(null, "Ya puede guardar el estudiante");
                        jButtonGuardarHuella.setEnabled(true);
                        jButtonGuardarHuella.grabFocus();
                        break;

                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la
                        // captura de huellas
                        Reclutador.clear();
                        stop();
                        // EstadoHuellas();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(VentanaCrearEstudiante.this,
                                "La Plantilla de la Huella no pudo ser creada, Repita el Proceso",
                                "Inscripción de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
                        start();
                        break;
                }
            }
        }
    }

    public void start() {
        Lector.startCapture();
        // EnviarTexto("Utilizando el Lector de Huella Dactilar ");
    }

    public void stop() {
        Lector.stopCapture();
        // EnviarTexto("No se esta usando el Lector de Huella Dactilar ");
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        jLabelImagenHuella.setIcon(new ImageIcon(
                image.getScaledInstance(jLabelImagenHuella.getWidth(), jLabelImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    /*
		  * Guarda los datos de la huella digital actual en la base de datos
     */
    public void guardarHuella(String documento) {
        int doc = Integer.parseInt(documento);
        String nombres = jTextFieldNombres.getText();
        //Obtiene los datos del template de la huella actual
        ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
        Integer tamanoHuella = template.serialize().length;

        //Pregunta el nombre de la persona a la cual corresponde dicha huella
//		     String nombre = JOptionPane.showInputDialog("Nombre:");
        try {
            //Establece los valores para la sentencia SQL
            cn = dataConnection.conexion();
            PreparedStatement guardarStmt = cn.prepareStatement("INSERT INTO huella(documento,nombres, huella) values(?,?,?)");

            guardarStmt.setString(1, documento);
            guardarStmt.setString(2, nombres);
            guardarStmt.setBinaryStream(3, datosHuella, tamanoHuella);
            //Ejecuta la sentencia
            guardarStmt.execute();
            guardarStmt.close();
            JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");
            limpiar();
            cn.close();
            //btnGuardar.setEnabled(false);
            //btnVerificar.grabFocus();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al guardar los datos de la huella.");
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrearEstudiante;
    private javax.swing.JButton jButtonGuardarHuella;
    private javax.swing.JComboBox jComboBoxGrado;
    private javax.swing.JComboBox<String> jComboBoxGrupo;
    private javax.swing.JComboBox<String> jComboBoxJornada;
    private javax.swing.JComboBox<String> jComboBoxZonaAlumno;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelDocumento;
    private javax.swing.JLabel jLabelGrado;
    private javax.swing.JLabel jLabelImagenHuella;
    private javax.swing.JLabel jLabelMetodologia;
    private javax.swing.JLabel jLabelNombres;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTipoPoblacion;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelContenedorHuella;
    private javax.swing.JPanel jPanelHuella;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldDocumento;
    private javax.swing.JTextField jTextFieldNombres;
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

    public boolean validarDoc(int documento) {
        try {
            cn = dataConnection.conexion();
            pst = cn.prepareStatement("select documento from estudiante");
            result = pst.executeQuery();
            while (result.next()) {
                int a = result.getInt("documento");
                if (a == documento) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(VentanaCrearEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    /**
     * Metodo que permite verificar que el estudiante tenga los dos apellidos
     * @return 
     */
    public boolean validarNombreCompleto(String apell){
        
        String[] apellidos=apell.split(" ");
        return apellidos.length==2;
    }
}
