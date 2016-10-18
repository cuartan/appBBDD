package gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import modelo.Alumno;
import modelo.Usuario;

public class GestorBD {
	public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	public static final String IPSERVERDB = "localhost/";
	public static final String DBNAME_MYSQL = "ibaiondo";
	public static final String DBUSER = "root";
	public static final String DBPASS = "";

	private static GestorBD instance = null;

	private Connection conn;

	public static GestorBD getInstance() {
		if (instance == null)
			instance = new GestorBD();
		return instance;
	}

	public void establecerConexion() throws ClassNotFoundException, SQLException {

		Class.forName(DRIVER_MYSQL);
		conn = DriverManager.getConnection("jdbc:mysql://" + IPSERVERDB + DBNAME_MYSQL, DBUSER, DBPASS);
		System.out.println("Has conectado con la base de datos mysql");

	}

	public void cerrarConexion() throws SQLException {
		if (conn != null) {
			conn.close();
			System.out.println("Conexión cerrada con la base de datos");
		}
	}

	public Usuario loginUsuario(String nombre, String clave) throws ClassNotFoundException, SQLException {
		Usuario u = null;
		establecerConexion();
		String sqlString = "SELECT * FROM usuario where nombre=? AND clave=?";
		PreparedStatement ps = conn.prepareStatement(sqlString);
		ps.setString(1, nombre);
		ps.setString(2, clave);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			u = new Usuario();
			u.setNombre(rs.getString("nombre"));
			u.setClave(rs.getString("clave"));
		}
		rs.close();
		ps.close();
		cerrarConexion();
		return u;
	}

	public ArrayList<Alumno> obtenerAlumnos() throws ClassNotFoundException, SQLException {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		establecerConexion();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM alumno");
		
		while(rs.next()){
			Alumno a=new Alumno();
			a.setNombre(rs.getString("NombreAlumno"));
			a.setApellido(rs.getString("apellido"));
			a.setDni(rs.getString("DNI"));
			a.setDomicilio(rs.getString("domicilio"));
			alumnos.add(a);
		}

		rs.close();
		st.close();
		cerrarConexion();
		return alumnos;
	}

}
