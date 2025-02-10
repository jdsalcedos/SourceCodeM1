package control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static ConexionBD instancia = null;
	private static Connection cn = null;
	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
//	private static final String url = "jdbc:mysql://127.0.0.1:3306/biblioteca";
	private static final String url = "jdbc:mysql://localhost:3306/biblioteca?serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "";

	private ConexionBD() {
	}

	public static ConexionBD getInstancia() {

		if (instancia == null) {
			instancia = new ConexionBD();
		}
		return instancia;
	}

	public static Connection getConexion() {

		try {
			Class.forName(Controlador);
			System.out.println("Controlador Cargado");
			cn = DriverManager.getConnection(url, username, password);
			System.out.println("✅ Conexión exitosa a la base de datos.");
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return cn;

	}

	public static void desconectar() {
		cn = null;
		System.out.println("desconectado con exito");
	}

//	public static void main(String[] args) {
//		try {
//			// conexión con la db
//			cn = ConexionBD.getConexion();
//			if (cn != null) {
//				System.out.println("🔗 Conexión establecida correctamente.");
//			} else {
//				System.out.println("🚫 No se pudo conectar.");
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}

}
