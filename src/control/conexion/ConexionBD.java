package control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.DAO.AutorDAO;
import control.DAO.UsuarioDAO;
import modelo.autor.Autor;
import modelo.usuario.Usuario;

public class ConexionBD {

	private static ConexionBD instancia = null;
	private static Connection cn = null;
	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/biblioteca";
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
		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();
		}

		return cn;

	}

	public static void desconectar() {
		cn = null;
		System.out.println("desconectado con exito");
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * try { cn = ConexionBD.getConexion();
	 * 
	 * 
	 * UsuarioDAO dao = new UsuarioDAO(); Usuario nuevoUsuario = new Usuario(3,
	 * "juan", "jdalsceod@3", "576357", "calle 43", "222222"); Usuario nuevoUsuario2
	 * = new Usuario(4, "johan", "johan@21", "75742", "calle 1", "333333333");
	 * 
	 * dao.add(nuevoUsuario); dao.add(nuevoUsuario2);
	 * 
	 * dao.getAll();
	 * 
	 * dao.getOne(4);
	 * 
	 * 
	 * 
	 * } catch (Exception ex) { ex.printStackTrace(); } }
	 */
}
