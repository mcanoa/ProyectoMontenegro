package logica;

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
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Image;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mateo
 */
public class GestionHuella extends JFrame{
    
    
    // atributos para el manejo de la base de datos
    private  PreparedStatement pst;
    private  Connection cn;
    private  ResultSet result;
    
    private  DPFPFeatureSet featuresinscripcion;
    private  DPFPFeatureSet featuresverificacion;
    
    /**
     * Varible que permite iniciar el dispositivo de lector de huella conectado
     * con sus distintos metodos.
     */
    private static final DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

    // Varible que permite establecer las capturas de la huellas, para determina
    // sus caracteristicas
    // y poder estimar la creacion de un template de la huella para luego poder
    // guardarla
    private static final DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    // Esta variable tambien captura una huella del lector y crea sus
    // caracteristcas para auntetificarla
    // o verificarla con alguna guardada en la BD
    private static final DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

    
    /**
     * Variable que para crear el template de la huella luego de que se hallan
     * creado las caracteriticas necesarias de la huella si no ha ocurrido ningun problema
     */
    private DPFPTemplate template;
    
    private String TEMPLATE_PROPERTY = "template";

    /**
     * Metodo que se activa cuando una huella digital ha sido colocada en el huellero
     * @param JLabelImagenHuella Para dibujar la huella
     */
    public void iniciar(JLabel JLabelImagenHuella) {
        Lector.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(() -> {
                    // EnviarTexto("La Huella Digital ha sido Capturada");
                    ProcesarCaptura(e.getSample(),JLabelImagenHuella);
                });
            }
        });

        /**
         * Porción de codigo que detecta si el lector de huella esta conectado
         */
        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        // EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
                    }
                });
            }

            /**
             * Porcion de codigo que sirve para detectar que el lector esta desconectado
             * @param e 
             */
            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(() -> {
                    // EnviarTexto("El Sensor de Huella Digital esta
                    // Desactivado o no Conectado");
                });
            }
        });

//        Lector.addSensorListener(new DPFPSensorAdapter() {
//            @Override
//            public void fingerTouched(final DPFPSensorEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        // EnviarTexto("El dedo ha sido colocado sobre el Lector
//                        // de Huella");
//                    }
//                });
//            }

//            @Override
//            public void fingerGone(final DPFPSensorEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        // EnviarTexto("El dedo ha sido quitado del Lector de
//                        // Huella");
//                    }
//                });
//            }
//        });

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



    public  void ProcesarCaptura(DPFPSample sample, JLabel JLableImagenHuella) {
        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el proposito de inscripcion.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el proposito de verificacion.
//        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

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
                DibujarHuella(image,JLableImagenHuella);

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
                        break;

                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la
                        // captura de huellas
                        Reclutador.clear();
                        stop();
                        // EstadoHuellas();
                        setTemplate(null);
//                        JOptionPane.showMessageDialog(VentanaCrearEstudiante.this,
//                                "La Plantilla de la Huella no pudo ser creada, Repita el Proceso",
//                                "Inscripción de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
                        
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

    public JLabel DibujarHuella(Image image, JLabel jLabelImagenHuella) {
        jLabelImagenHuella.setIcon(new ImageIcon(
                image.getScaledInstance(jLabelImagenHuella.getWidth(), jLabelImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
        return jLabelImagenHuella;
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = template;
        template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }
    
     /**
      * 
      * @param sample
      * @param purpose
      * @return 
      */
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
    public void guardarHuella(String documento, String nombres) {
        int doc = Integer.parseInt(documento);
        
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
    
    /**
     * Identifica a una persona registrada por medio de su huella digital
     * @return 
     * @throws java.io.IOException
     */
    public boolean identificarHuella() throws IOException {
        try {
            //Establece los valores para la sentencia SQL
            cn = dataConnection.conexion();

            //Obtiene todas las huellas de la bd
            PreparedStatement identificarStmt = cn.prepareStatement("SELECT nombres,documento,huella FROM huella");
            ResultSet rs = identificarStmt.executeQuery();

            //Si se encuentra el nombre en la base de datos
            while (rs.next()) {
                //Lee la plantilla de la base de datos
                byte templateBuffer[] = rs.getBytes("huella");
                String nombre = rs.getString("nombres");
                int documento= rs.getInt("documento");
             
                //Crea una nueva plantilla a partir de la guardada en la base de datos
                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
                setTemplate(referenceTemplate);

                // Compara las caracteriticas de la huella recientemente capturda con la
                // alguna plantilla guardada en la base de datos que coincide con ese tipo
                DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

                //compara las plantilas (actual vs bd)
                //Si encuentra correspondencia dibuja el mapa
                //e indica el nombre de la persona que coincidio.
                if (result.isVerified()) {
                    //crea la imagen de los datos guardado de las huellas guardadas en la base de datos
                    JOptionPane.showMessageDialog(null, "Las huella capturada es de " + nombre, "Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
            //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
            JOptionPane.showMessageDialog(null, "No existe ningún registro que coincida con la huella", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
            setTemplate(null);
        } catch (SQLException e) {
            //Si ocurre un error lo indica en la consola
            System.err.println("Error al identificar huella dactilar." + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }
}
