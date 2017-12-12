package logica;

/**
 * Clase que representa el administrador del sistema
 *
 * @author Mateo
 */
public class Administrador {

    private String nombres;
    private String apellidos;
    private int documento;
    private String nickname;

    /**
     * Constructor con los parametros de un administrador del sistema
     *
     * @param nombres
     * @param apellidos
     * @param documento
     * @param nickname
     */
    public Administrador(String nombres, String apellidos, int documento,
            String nickname) {
        super();
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.nickname = nickname;
    }

    /**
     * Constructor de la clase vacio
     */
    public Administrador() {
        super();
    }

    /**
     * Método para obetener el nombre del administrador
     *
     * @return El nombre del administrador
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método para asignarle un nombre al administrador
     *
     * @param nombres Nombre del administrador
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método para obtener los apellidos del administrador
     * @return Los apellidos del administrador
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método para asignarle un valor al atributo apellidos del administrador
     * @param apellidos Apellidos del administrador
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método para Obtener el Documento del Administrador.
     * @return El número de documento del administrador
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * Método para asignarle un número de documento al administrador
     * @param documento Documento del administrador
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * Método para obtener el Nickname del Administrador
     * @return En Nickname del Administrador
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Método para asignarle un Nockname al Administrador para que inicie sesión
     * @param nickname Nickname del administrador
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
