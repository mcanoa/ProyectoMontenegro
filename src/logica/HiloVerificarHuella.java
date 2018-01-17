package logica;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Image;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HiloVerificarHuella implements Runnable {

    // Varible que permite establecer las capturas de la huellas, para determina
    // sus caracteristicas
    // y poder estimar la creacion de un template de la huella para luego poder
    // guardarla
    private final DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    // Esta variable tambien captura una huella del lector y crea sus
    // caracteristcas para auntetificarla
    // o verificarla con alguna guardada en la BD
    private final DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

    // Variable que para crear el template de la huella luego de que se hallan
    // creado las caracteriticas
    // necesarias de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";

    public HiloVerificarHuella(JLabel imagenHuella) {

        this.imagenHuella = imagenHuella;
        instituto = new institutoMontenegro();

    }

    @Override
    public void run() {

        try {
            ProcesarCaptura(sample);
        } catch (IOException | ParseException ex) {
            System.err.println("Error");
        }
    }

    public void setSample(DPFPSample sample) {
        this.sample = sample;
    }

    public void ProcesarCaptura(DPFPSample sample) throws IOException, ParseException {

        // Procesar la muestra de la huella y crear un conjunto de
        // características con el propósito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo agrega a su
        // reclutador si es bueno
        if (featuresverificacion != null) {
            try {
                System.out.println("Las Caracteristicas de la Huella han sido creada");
                Reclutador.addFeatures(featuresverificacion);// Agregar las
                // caracteristicas
                // de la huella a la
                // plantilla a crear

                setTemplate(Reclutador.getTemplate());

                // Dibuja la huella dactilar capturada.
                Image image = CrearImagenHuella(sample);
                DibujarHuella(image);

                //identifica despues de capturar la huella
                boolean respuesta = identificarHuella();
                if (respuesta) {
                    registrarIngreso();
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede registrar el ingreso del estudiante", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                //limpia el reclutador de las huellas
                Reclutador.clear();
                setTemplate(null);

            } catch (DPFPImageQualityException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
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

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        imagenHuella.setIcon(new ImageIcon(
                image.getScaledInstance(imagenHuella.getWidth(), imagenHuella.getHeight(), Image.SCALE_DEFAULT)));
    }

    /**
     * Identifica a una persona registrada por medio de su huella digital
     *
     * @return
     * @throws java.io.IOException
     */
    public boolean identificarHuella() throws IOException {
        try {

            cn = dataConnection.conexion();

            //Obtiene todas las huellas de la bd
            pst = cn.prepareStatement("SELECT nombres,documento,huella FROM estudiante where huella is not null");
            rst = pst.executeQuery();

            //Si se encuentra el nombre en la base de datos
            while (rst.next()) {
                //Lee la plantilla de la base de datos
                byte templateBuffer[] = rst.getBytes("huella");
                String nombre = rst.getString("nombres");
                this.documento = rst.getString("documento");

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
                    JOptionPane.showMessageDialog(null, "Bienvenido " + nombre, "Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
                    setTemplate(null);
                    return true;
                }
            }
            Reclutador.clear();
            setTemplate(null);
            cn.close();
            return false;
        } catch (SQLException e) {
            //Si ocurre un error lo indica en la consola
            JOptionPane.showMessageDialog(null, "Error al identificar huella dactilar.\n"
                    + "intente de Nuevo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Metodo que permite registrar el ingreso de los estudiantes que poseen una
     * huella
     * @throws java.text.ParseException
     */
    public void registrarIngreso() throws ParseException {
        Date fecha; // TODO Auto-generated catch block
        Date ultimoIngresoFecha;
        fecha = (Date) instituto.fechaHoy();
        ultimoIngresoFecha = (Date) instituto.ultimaFechaIngreso(documento);
        instituto.actualizarUltimoIngreso(fecha, documento);
        cn = dataConnection.conexion();
        try {
            pst = cn.prepareStatement("select * from estudiante where documento=?");
            pst.setString(1, documento);

            rst = pst.executeQuery();
            if (rst.next()) {
                if (instituto.validarFechas(fecha, ultimoIngresoFecha) == false) {
                    instituto.insertarRegistro(documento, fecha, ultimoIngresoFecha);

                } else {

                    JOptionPane.showMessageDialog(null, "EL ESTUDIANTE YA INGRESO");

                }
            } else {
                JOptionPane.showMessageDialog(null, "El estudiante no se encuentra en la base de datos");
            }
        } catch (SQLException e1) {
        }
    }

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
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

    private final institutoMontenegro instituto;
    private Connection cn;
    private PreparedStatement pst;
    private ResultSet rst;
    private String documento;

    private JLabel imagenHuella;
    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;
    private DPFPSample sample;
}
