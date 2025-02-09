package control.DAO.documentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import control.DAO.InterfaceDAO;
import control.conexion.ConexionBD;
import modelo.factory.abstracto.Documento;
import modelo.factory.creadorConcreto.CreadorDocumento;

public class DocumentoDAO implements InterfaceDAO<Documento> {

	private Connection cn;
	private PreparedStatement pst;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private ResultSet rs;
	private ResultSet rs2;

	public DocumentoDAO() {
		// gestor
		cn = null;
		pst = null;
		pst2 = null;
		pst3 = null;
		rs = null;
		rs2 = null;
	}

	

	@Override
	public ArrayList<Documento> getAll() {
		ArrayList<Documento> docs = new ArrayList<Documento>();
		try {
			cn = ConexionBD.getConexion();
			pst = cn.prepareStatement("SELECT * FROM documento");
			rs = pst.executeQuery();

			pst2 = cn.prepareStatement("SELECT * FROM documento_autor");
			rs2 = pst2.executeQuery();

			CreadorDocumento creador = new CreadorDocumento(); // Instancia del Factory

			while (rs.next() && rs2.next()) {
				int idDocumento = rs.getInt("id_documento");
				int idEditorial = rs.getInt("id_editorial");
				int idAutor = rs2.getInt("id_autor");
				String titulo = rs.getString("titulo");
				LocalDate fechaPublicacion = rs.getDate("fecha_publicacion").toLocalDate();
				String isbn = rs.getString("ISBN");
				String tipoDocumento = rs.getString("tipo_documento");
				String estadoVisualizacion = rs.getString("estado_visualizacion");

				// Usar el Factory Method para crear el documento correcto
				Documento doc = creador.creadorDocumento(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion,
						isbn, tipoDocumento, estadoVisualizacion);

				docs.add(doc);
			}
			

			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println(docs);
		return docs;
	}

	@Override
	public Documento getOne(int id) {
		Documento doc = null;
		try {
			cn = ConexionBD.getConexion();
			pst = cn.prepareStatement("SELECT * FROM documento WHERE id_documento = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();

			pst2 = cn.prepareStatement("SELECT * FROM documento_autor WHERE id_documento = ?");
			pst2.setInt(1, id);
			rs2 = pst2.executeQuery();

			CreadorDocumento creador = new CreadorDocumento(); // Instancia del Factory

			if (rs.next() && rs2.next()) {
				int idEditorial = rs.getInt("id_editorial");
				int idAutor = rs2.getInt("id_autor");
				String titulo = rs.getString("titulo");
				LocalDate fechaPublicacion = rs.getDate("fecha_publicacion").toLocalDate();
				String isbn = rs.getString("isbn");
				String tipoDocumento = rs.getString("tipo_documento");
				String estadoVisualizacion = rs.getString("estado_visualizacion");

				// Usar el Factory Method para crear el documento correcto
				doc = creador.creadorDocumento(id, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento,
						estadoVisualizacion);
			}
			System.out.println(doc);

			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return doc; // Retorna el documento encontrado o null si no existe
	}

	@Override
	public void add(Documento doc) {
		//logica para mandar al DAO correspondiente para que se cree en la BD
	}

	@Override
	public boolean update(Documento antiguo, Documento nuevo) {
		try {
			cn = ConexionBD.getConexion();

			// Actualización en la tabla "documento"
			pst = cn.prepareStatement("UPDATE documento SET id_editorial = ?, titulo = ?, "
					+ "ISBN = ? WHERE id_documento = ?");

			
			pst.setInt(1, nuevo.getIdEditorial());
			pst.setString(2, nuevo.getTitulo()); // Conversión LocalDate → java.sql.Date
			pst.setString(3, nuevo.getIsbn());
			pst.setInt(4, antiguo.getIdDocumento()); // Cláusula WHERE para actualizar solo el documento correcto


			int filasAfectadas = pst.executeUpdate();

			pst.close();
			ConexionBD.desconectar();
			System.out.println("documento modificado con exito");

			return filasAfectadas > 0; // Devuelve true si al menos una fila fue afectada en
																// ambas tablas
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Documento docDelete) {
		try {
	        cn = ConexionBD.getConexion();

	        // 1. Eliminar de las tablas específicas según el tipo de documento
	        if (docDelete.getTipoDocumento().equals("Libro")) {
	            pst = cn.prepareStatement("DELETE FROM libro WHERE id_documento = ?");
	        } else if (docDelete.getTipoDocumento().equals("Ponencia")) {
	            pst = cn.prepareStatement("DELETE FROM ponencia WHERE id_documento = ?");
	        } else if (docDelete.getTipoDocumento().equals("Articulo cientifico")) {
	            pst = cn.prepareStatement("DELETE FROM articulo_cientifico WHERE id_documento = ?");
	        }
	        
	        pst.setInt(1, docDelete.getIdDocumento());
	        pst.executeUpdate();
	        pst.close();

	        // 2. Eliminar de la tabla intermedia documento_autor
	        pst2 = cn.prepareStatement("DELETE FROM documento_autor WHERE id_documento = ?");
	        pst2.setInt(1, docDelete.getIdDocumento());
	        pst2.executeUpdate();
	        pst2.close();

	        // 3. Finalmente, eliminar de la tabla documento
	        pst3 = cn.prepareStatement("DELETE FROM documento WHERE id_documento = ?");
	        pst3.setInt(1, docDelete.getIdDocumento());
	        int filasAfectadas = pst3.executeUpdate();
	        pst3.close();

	        ConexionBD.desconectar();
	        System.out.println("documento eliminado con exito");
	        
	        return filasAfectadas > 0; // Devuelve true si el documento se eliminó correctamente
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

}
