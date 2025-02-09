package control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import control.DAO.documentos.ArticuloCientificoDAO;
import control.DAO.documentos.DocumentoDAO;
import control.DAO.documentos.LibroDAO;
import control.DAO.documentos.PonenciaDAO;
import modelo.factory.abstracto.Documento;
import modelo.factory.creadorConcreto.CreadorDocumento;
import modelo.factory.documento.ArticuloCientifico;
import modelo.factory.documento.Libro;
import modelo.factory.documento.Ponencia;

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
	
	public static void main(String[] args) {

		try {
			cn = ConexionBD.getConexion();

			ArticuloCientificoDAO acDao = new ArticuloCientificoDAO();
////			LibroDAO daolibro = new LibroDAO();
			CreadorDocumento fabrica = new CreadorDocumento();
			DocumentoDAO dao = new DocumentoDAO();
//			
			//Documento ac1 = fabrica.creadorDocumento(2, 101, 1, "Articulo C 1", LocalDate.of(2012, 8, 2),"632144", "Articulo cientifico", "dado de alta");
			//acDao.add((ArticuloCientifico) ac1);
			Documento doc = dao.getOne(2);
			dao.delete(doc);
			//Documento docNew = fabrica.creadorDocumento(2, 101, 1, "Ponencia Cambiada", LocalDate.of(2014, 1, 1),"555555", "Libro", "dado de baja");
			//dao.update(doc, docNew);
//			dao.delete(doc);
			//daolibro.add((Libro) libro1);
//			//dao.getOne(2);
//			//dao.getAll();
//			dao.delete(libro1);
//			Documento nuevoDocumento = fabrica.creadorDocumento(2, 101, 1, "Sexy", LocalDate.of(2004, 10, 22),
//					"123000000", "Ponencia", "dado de alta");
			//Documento doc = dao.getOne(2);
			//dao.delete(doc);
//			Documento nuevoDocumentoModificado = fabrica.creadorDocumento(4, 101, 2, "Feo", LocalDate.of(2011, 9, 11),
//					"15462340", "Ponencia", "dado de baja");
//
//			dao.getAll();
//			dao.getOne(2);
//			dao.update(nuevoDocumento, nuevoDocumentoModificado);
//
//			System.out.println(nuevoDocumentoModificado.getClass());
			/*
			 * Documento nuevoDocumento2 = fabrica.creadorDocumento(2, 4521, 9783, "Python",
			 * LocalDate.of(2021, 1, 5), "978-3-16-148410-0", "Ponencia");
			 */

			// dao.add((Libro) nuevoDocumento);
			// dao.add(nuevoDocumento2);

			// dao.getAll();

			// dao.getOne(4);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
