/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import GUI.VentanaGestionEstudiante;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import java.awt.Image;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mateo
 */
public class HiloGuardarHuella implements Runnable {

    // Varible que permite iniciar el dispositivo de lector de huella conectado
    // con sus distintos metodos.
    private final DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    // Varible que permite establecer las capturas de la huellas, para determina
    // sus caracteristicas
    // y poder estimar la creacion de un template de la huella para luego poder
    // guardarla
    public final DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    // Variable que para crear el template de la huella luego de que se hallan
    // creado las caracteriticas
    // necesarias de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";
    public DPFPFeatureSet featuresinscripcion;
    private JButton botonGuardar;

    public HiloGuardarHuella(JLabel imagenHuella, JButton botonGuardar) {
        instituto = new institutoMontenegro();
        this.imagenHuella = imagenHuella;
        this.botonGuardar = botonGuardar;
        Iniciar();
    }

    /**
     * Metodo que sirve para iniciar el lector de huellas
     */
    protected void Iniciar() {
        Lector.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                ProcesarCaptura(e.getSample());
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        // EnviarTexto("La Huella Digital ha sido Capturada");
//                        ProcesarCaptura(e.getSample());
//                    }
//                });
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

    }

    public void ProcesarCaptura(DPFPSample sample) {
        // Procesar la muestra de la huella y crear un conjunto de
        // caracter�sticas con el proposito de inscripcion.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

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

            } catch (DPFPImageQualityException ex) {
                System.err.println("Error: " + ex.getMessage());

            } finally {

                // Comprueba si la plantilla se ha creado.
                switch (Reclutador.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY: // informe de exito y detiene la
                        // captura de huellas
                        stop();
                        setTemplate(Reclutador.getTemplate());

                        JOptionPane.showMessageDialog(null, "Ya puede guardar el estudiante");
                        datosHuella = new ByteArrayInputStream(template.serialize());
                        VentanaGestionEstudiante.setDatosHuella(datosHuella);
                        VentanaGestionEstudiante.setTamanoHuella(template.serialize().length);
                        System.err.println("Datos Huella creada y pasada a la clase ventana gestion estudiante");

                      
                        botonGuardar.setEnabled(true);
                        botonGuardar.grabFocus();
                        break;

                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la
                        // captura de huellas
                        Reclutador.clear();
                        stop();
                        EstadoHuellas();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(null, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
                        start();
                        break;
                }
            }
        }
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        imagenHuella.setIcon(new ImageIcon(
                image.getScaledInstance(imagenHuella.getWidth(), imagenHuella.getHeight(), Image.SCALE_DEFAULT)));

    }

    private DPFPTemplate getTemplate() {
        return template;
    }

    private void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    private void start() {
        Lector.startCapture();
    }

    private void stop() {
        Lector.stopCapture();
    }

    /**
     * Support for reporting bound property changes for Object properties. This
     * method can be called when a bound property has changed and it will send
     * the appropriate PropertyChangeEvent to any registered
     * PropertyChangeListeners.
     *
     * @param propertyName the property whose value has changed
     * @param oldValue the property's previous value
     * @param newValue the property's new value
     */
    protected void firePropertyChange(String propertyName,
            Object oldValue, Object newValue) {
        PropertyChangeSupport changeSupport;
        synchronized (getObjectLock()) {
            changeSupport = this.changeSupport;
        }
        if (changeSupport == null
                || (oldValue != null && newValue != null && oldValue.equals(newValue))) {
            return;
        }
        changeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    /*
     * In some cases using "this" as an object to synchronize by
     * can lead to a deadlock if client code also uses synchronization
     * by a component object. For every such situation revealed we should
     * consider possibility of replacing "this" with the package private
     * objectLock object introduced below. So far there're 3 issues known:
     * - CR 6708322 (the getName/setName methods);
     * - CR 6608764 (the PropertyChangeListener machinery);
     * - CR 7108598 (the Container.paint/KeyboardFocusManager.clearMostRecentFocusOwner methods).
     *
     * Note: this field is considered final, though readObject() prohibits
     * initializing final fields.
     */
    private transient Object objectLock = new Object();

    Object getObjectLock() {
        return objectLock;
    }

    /**
     * If any <code>PropertyChangeListeners</code> have been registered, the
     * <code>changeSupport</code> field describes them.
     *
     * @serial
     * @since 1.2
     * @see #addPropertyChangeListener
     * @see #removePropertyChangeListener
     * @see #firePropertyChange
     */
    private PropertyChangeSupport changeSupport;

    /**
     *
     * @param sample
     * @param purpose
     * @return
     */
    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {

        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    @Override
    public void run() {

        start();
        
    }

    public void EstadoHuellas() {
        System.out.println("Muestra de Huellas Necesarias para Guardar Template " + Reclutador.getFeaturesNeeded());

    }

    private final institutoMontenegro instituto;
    private Connection cn;
    private PreparedStatement pst;
    private ResultSet rst;
    private JLabel imagenHuella;
    ByteArrayInputStream datosHuella;
    Integer tamanoHuella;
    DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();

}
