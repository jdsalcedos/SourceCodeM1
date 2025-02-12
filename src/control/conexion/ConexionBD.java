package control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import control.DAO.AutorDAO;
import control.DAO.HistorialDAO;
import control.DAO.ReservaDAO;
import control.DAO.UsuarioDAO;
import control.DAO.documentos.ArticuloCientificoDAO;
import control.DAO.documentos.DocumentoDAO;
import control.DAO.documentos.LibroDAO;
import modelo.facade.historial.HistorialCambio;
import modelo.factory.abstracto.Documento;
import modelo.factory.creadorConcreto.CreadorDocumento;
import modelo.factory.documento.ArticuloCientifico;
import modelo.factory.documento.Libro;
import modelo.state.*;

public class ConexionBD {

	private static ConexionBD instancia = null;
	private static Connection cn = null;
	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
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

}
