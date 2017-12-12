package logica;

/**
 * Clase que representa a un estdiante en el sistema
 * @author Mateo
 */
public class Estudiante {
	private String nombres;
	private String apellidos;
	private int documentoIdentidad;
	private String grado;
	private String sexo;
	private String tipoPoblacion;
	private String modeloPedagogico;

        /**
         * Constructor de la clase estudiante con parametros
         * @param nombres nombres del estudiante
         * @param apellidos apelldios del estudiante
         * @param documentoIdentidad Documento de identidad del estudiante
         * @param grado grado del estudiante
         * @param sexo genero sexual del estudiante
         * @param tipoPoblacion tipo de población del estudiante
         * @param modeloPedagogico modelo pedagogico del estudiante
         */
	public Estudiante(String nombres, String apellidos, int documentoIdentidad,
			String grado, String sexo, String tipoPoblacion,
			String modeloPedagogico) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.documentoIdentidad = documentoIdentidad;
		this.grado = grado;
		this.sexo = sexo;
		this.tipoPoblacion = tipoPoblacion;
		this.modeloPedagogico = modeloPedagogico;
	}

        /**
         * Constructor vacio de la clase estudiante
         */
	public Estudiante() {
		super();
	}

        /**
         * Método para obtener los nombres del estudiante
         * @return Retorna los nombres del estudiante
         */
	public String getNombres() {
		return nombres;
	}

        /**
         * Método para asignarle un nombre a un estudiate
         * @param nombres Nombres del estudiante
         */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

        /**
         * Método para obtener el valor del atributo apellido de un estudiante
         * @return Retorna los apellidos del estudiante
         */
	public String getApellidos() {
		return apellidos;
	}

        /**
         * Método para asignarle un valor a la variable apellidos
         * @param apellidos Apellidos a asignarle a un estudiante
         */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

        /**
         * Método para obtener el valor del documento de identidad de un estudiante
         * @return Valor del atributo documento de identidad
         */
	public int getDocumentoIdentidad() {
		return documentoIdentidad;
	}

        /**
         * Método para Asignarle un valor al atributo Documento de identidad de un estudiante
         * @param documentoIdentidad Valor que se asigna a la variable documento de identidad
         */
	public void setDocumentoIdentidad(int documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

        /**
         * Método para obtener el grado de un estudiante
         * @return El grado del estudiante
         */
	public String getGrado() {
		return grado;
	}

        /**
         * Método para asignarle un valor a la variable grado de un estudiante
         * @param grado Grado del estudiante
         */
	public void setGrado(String grado) {
		this.grado = grado;
	}

        /**
         * Método para Obtener el género sexual de un estudiante
         * @return El género sexual del estudiante
         */
	public String getSexo() {
		return sexo;
	}

        /**
         * Método para asignarle un valor a la variable sexo de un estudiante
         * @param sexo Valor de la varible sexoa asignar
         */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

        /**
         * Método para obtener el tipo de población de un estudiante
         * @return Tipo de Población del estdudiante
         */
	public String getTipoPoblacion() {
		return tipoPoblacion;
	}

        /**
         * Método para asignar un valor a la variable tipo población de un estudiante
         * @param tipoPoblacion  Valor a asignar a la variable Tipo Población
         */
	public void setTipoPoblacion(String tipoPoblacion) {
		this.tipoPoblacion = tipoPoblacion;
	}

        /**
         * Método para obtener el modelo pedagocio de un estudiante
         * @return Valor de la variable modelo pedagogico del estudiante
         */
	public String getModeloPedagogico() {
		return modeloPedagogico;
	}

        /**
         * Método para asignarle un valor a la variable Modelo Pedagogico del estudiante
         * @param modeloPedagogico Valor a asignar a la variable modelo pedagogico
         */
	public void setModeloPedagogico(String modeloPedagogico) {
		this.modeloPedagogico = modeloPedagogico;
	}
}
