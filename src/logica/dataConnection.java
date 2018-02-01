package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Clase que permite realizar la conexión a la Base de Datos
 * @author Mateo
 */
public class dataConnection {

	
	private static final String user = "root";
	private static final String password = "";
	private static final String dataBase = "instituto_montenegro";
	private static final String url = "jdbc:mysql://localhost/" + dataBase;
	private static Connection connection = null;

        /**
         * Constructor vacio de la clase dataConnection
         */
	public dataConnection() {
		super();
	}

        /**
         * Método que realiza la conexión a la base de datos
         * @return La conexión a la base de datos
         */
	public static Connection conexion() {

		try {
			Class.forName("com.mysql.jdbc.Connection");
			connection = DriverManager.getConnection(url, user,password);
		} catch (SQLException ex) {
			System.out.println("Problema al conectarse a: " + url);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		return connection;
	}

        /**
         * 
         * @param query
         * @return 
         */
	public ResultSet getQuery(String query) {
		Statement state = null;
		ResultSet result = null;
		try {
			state = (Statement) connection.createStatement();
			result = state.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

        /**
         * 
         * @param query 
         */
	public void setQuery(String query) {
		Statement state = null;
		try {
			state = (Statement) connection.createStatement();
			state.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
