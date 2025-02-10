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

	public static void main(String[] args) {

		try {
			cn = ConexionBD.getConexion();
//			HistorialDAO dao=new HistorialDAO();
//			HistorialCambio hc=HistorialCambio.getInstance();
//			hc.setIdDocumento(1);
//			hc.setIdUsuario(1);
//			dao.reservado(hc);
			// dao.add(hc);
			// cn = ConexionBD.getConexion();

			// ArticuloCientificoDAO acDao = new ArticuloCientificoDAO();

			DocumentoDAO dao = new DocumentoDAO();
			CreadorDocumento fabrica = new CreadorDocumento();
			LibroDAO daolibro = new LibroDAO();
//
//			Documento lib1 = fabrica.creadorDocumento(5, 101, 1, "Don Quijote", LocalDate.of(2015, 1, 2), "0971089273",
//					"Libro", null);
			
			Documento doc = dao.getOne(4);
			
			// ESTA ES LA LOGICA QUE DEBE TENER LA CREACION DEL OBJETO QUE TENDRA LOS DATOS NUEVOS 
			// DEBE RECOGER EL id_documento DE ESTA MANERA
			Documento lib2 = fabrica.creadorDocumento(doc.getIdDocumento(), 101, 2, "Don Maybe 3", LocalDate.of(2000, 10, 20), "00000000000",
					"Libro", null);
			
//			daolibro.add((Libro) lib1);
//
//			dao.getAll();

//			System.out.println("\n\n\n");
//			Documento docModificado = dao.getOne(2);
//			dao.getAllVisible();
//
//			
			
//			
//			dao.delete(dao.getOne(4));
			
			dao.update(doc, lib2);
//			
//			Documento docModificado = dao.getOne(3);
//
//			if (docModificado != null) {
//				System.out.println("Estado actual: " + docModificado.getEstadoVisualizacion().getEstado());
//
//				// 2. Cambiar el estado (de Visible a NoVisible o viceversa)
//			if (docModificado.getEstadoVisualizacion() instanceof EstadoVisible) {
//				docModificado.cambiarEstado(new EstadoOculto(), dao);
//			} else {
//				docModificado.cambiarEstado(new EstadoVisible(), dao);
//			}
//			
//			dao.getAllVisible();

//
//				// 3. Verificar el cambio
//				System.out.println("Nuevo estado: " + docModificado.getEstadoVisualizacion().getEstado());
//			} else {
//				System.out.println("Documento no encontrado.");
//			}
//			
//			
//			dao.getOne(3);
//			
//			dao.delete(docModificado);
//			
//			dao.getAll();
//			
//			System.out.println(dao.getOne(4));

			// acDao.add((ArticuloCientifico) ac1);
			// Documento doc = dao.getOne(2);
			// dao.updateEstado(doc);
			// Documento ac1 = fabrica.creadorDocumento(2, 101, 1, "Articulo C 1",
			// LocalDate.of(2012, 8, 2),"632144", "Articulo cientifico", "dado de alta");
			// acDao.add((ArticuloCientifico) ac1);
			// Documento doc = dao.getOne(2);
			// dao.delete(doc);
			// Documento docNew = fabrica.creadorDocumento(2, 101, 1, "Ponencia Cambiada",
			// LocalDate.of(2014, 1, 1),"555555", "Libro", "dado de baja");
			// dao.update(doc, docNew);
//			dao.delete(doc);
			// daolibro.add((Libro) libro1);
//			//dao.getOne(2);
//			//dao.getAll();
//			dao.delete(libro1);
//			Documento nuevoDocumento = fabrica.creadorDocumento(2, 101, 1, "Sexy", LocalDate.of(2004, 10, 22),
//					"123000000", "Ponencia", "dado de alta");
			// Documento doc = dao.getOne(2);
			// dao.delete(doc);
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
