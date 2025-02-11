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
import modelo.factory.documento.ArticuloCientifico;
import modelo.factory.documento.Libro;
import modelo.factory.documento.Ponencia;
import modelo.state.EstadoOculto;
import modelo.state.EstadoVisible;
import modelo.state.VisualizacionState;
import modelo.visitor.UpdateDocumentoVisitor;

public class DocumentoDAO implements InterfaceDAO<Documento> {

	private Connection cn;
	private PreparedStatement pst;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private ResultSet rs;
	private ResultSet rs2;

	public DocumentoDAO() {
		cn = null;
		pst = null;
		pst2 = null;
		pst3 = null;
		rs = null;
		rs2 = null;
	}
	
	public ArrayList<Documento> getAllByAutor(int id) {

		ArrayList<Documento> docs = new ArrayList<Documento>();
		try {
			cn = ConexionBD.getConexion();
			
			String consulta = "SELECT d.* FROM documento d " +
                    "INNER JOIN documento_autor da ON d.id_documento = da.id_documento " +
                    "WHERE da.id_autor = ?";
			
			pst = cn.prepareStatement(consulta);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			CreadorDocumento creador = new CreadorDocumento(); // Instancia del Factory

			while (rs.next()) {
				int idDocumento = rs.getInt("id_documento");
				int idEditorial = rs.getInt("id_editorial");
				int idAutor = rs.getInt(id);
				String titulo = rs.getString("titulo");
				LocalDate fechaPublicacion = rs.getDate("fecha_publicacion").toLocalDate();
				String isbn = rs.getString("ISBN");
				String tipoDocumento = rs.getString("tipo_documento");
				String estadoVisualizacionStr = rs.getString("estado_visualizacion");
				
				VisualizacionState estadoVisualizacion = estadoVisualizacionStr.equals("Dado de alta") ? new EstadoVisible() : new EstadoOculto();

				// Usar el Factory Method para crear el documento correcto
				Documento doc = creador.creadorDocumento(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion,
						isbn, tipoDocumento, estadoVisualizacion);
				
				docs.add(doc);
				System.out.println(doc.getIdAutor() +" nombre: " + doc.getTitulo());

			}
			
			System.out.println("MOSTRANDO LOS DOCUMENTOS....");
			System.out.println(docs.toString());
			pst.close();
			
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
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
				String estadoVisualizacionStr = rs.getString("estado_visualizacion");

				VisualizacionState estadoVisualizacion = estadoVisualizacionStr.equals("Dado de alta") ? new EstadoVisible() : new EstadoOculto();

				// Usar el Factory Method para crear el documento correcto
				doc = creador.creadorDocumento(id, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento,
						estadoVisualizacion);
			}
			System.out.println("MOSTRANDO SOLO 1");
//			System.out.println(doc.toString());

			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return doc; // Retorna el documento encontrado o null si no existe
	}

	@Override
	public void add(Documento doc) {
		// logica para mandar al DAO correspondiente para que se cree en la BD
	}

	@Override
	public boolean update(Documento antiguo, Documento nuevo) {
		try {
			cn = ConexionBD.getConexion();

			// Actualización en la tabla "documento"
			pst = cn.prepareStatement("UPDATE documento SET id_editorial = ?, titulo = ?, fecha_publicacion = ?, ISBN = ? WHERE id_documento = ?");

			pst.setInt(1, nuevo.getIdEditorial());
			pst.setString(2, nuevo.getTitulo()); 
			pst.setDate(3, java.sql.Date.valueOf(nuevo.getFechaPublicacion()));
			pst.setString(4, nuevo.getIsbn());
			pst.setInt(5, antiguo.getIdDocumento()); 

			int filasAfectadas = pst.executeUpdate();

			pst.close();
			
			UpdateDocumentoVisitor visitor = new UpdateDocumentoVisitor(this);
			nuevo.aceptar(visitor);
			
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
	
	public void actualizarEstadoEnBD(Documento doc, String nuevoEstado) {
	    try {
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("UPDATE documento SET estado_visualizacion = ? WHERE id_documento = ?");
	        pst.setString(1, nuevoEstado);
	        pst.setInt(2, doc.getIdDocumento());
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        System.out.println("SE CAMBIO EL ESTADO");
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	public ArrayList<Documento> getAllVisible() {
		ArrayList<Documento> docs = new ArrayList<Documento>();
		try {
			cn = ConexionBD.getConexion();
			pst = cn.prepareStatement("SELECT * FROM documento WHERE estado_visualizacion=?");
			pst.setString(1, "Dado de alta");
			rs = pst.executeQuery();

			pst2 = cn.prepareStatement("SELECT * FROM documento_autor");
			rs2 = pst2.executeQuery();

			CreadorDocumento creador = new CreadorDocumento(); // Instancia del Factory

			while (rs.next() && rs2.next()) {
//				System.out.println("ya entro al primer while");
//				while(rs2.next()) {
//					System.out.println("ya entro al segundo while");
//				}
				int idDocumento = rs.getInt("id_documento");
				int idEditorial = rs.getInt("id_editorial");
				int idAutor = rs2.getInt("id_autor");
				String titulo = rs.getString("titulo");
				LocalDate fechaPublicacion = rs.getDate("fecha_publicacion").toLocalDate();
				String isbn = rs.getString("ISBN");
				String tipoDocumento = rs.getString("tipo_documento");
				String estadoVisualizacionStr = rs.getString("estado_visualizacion");
				
				VisualizacionState estadoVisualizacion = estadoVisualizacionStr.equals("Dado de alta") ? new EstadoVisible() : new EstadoOculto();

				// Usar el Factory Method para crear el documento correcto
				Documento doc = creador.creadorDocumento(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion,
						isbn, tipoDocumento, estadoVisualizacion);

				docs.add(doc);
//				System.out.println("holaaaaaaaaaaaaaa");
//				System.out.println(doc.getClass());
			}
			
//			System.out.println("MOSTRANDO LOS DOCUMENTOS VISIBLES....");
//			System.out.println("TOSTRING" + docs.toString());
			
//			if(docs==null) {
//				System.out.println("es nulo");
//			}else {
//				System.out.println("tamaño: " + docs.size());
//			}
//			
//			if(!docs.isEmpty()) {
//				System.out.println("chao: " + docs.toString());
//				System.out.println("lista no vacia");
//			}else {
//				System.out.println("lista vacia");
//			}
//				
//			for(Documento doc : docs) {
//				System.out.println("titulo " + doc.getTitulo());
//			}
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return docs;
	}

	public boolean actualizarLibro(Libro libro) {
		try {
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("UPDATE libro SET num_paginas = ? WHERE id_documento = ?");
	        pst.setString(1, libro.getNumPaginas());
	        pst.setInt(2, libro.getIdDocumento());
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        System.out.println("SE CAMBIO EL ESTADO de un libro");
	        return true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return true;
	    }
		
	}

	public boolean actualizarPonencia(Ponencia ponencia) {
		try {
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("UPDATE ponencia SET congreso = ? WHERE id_documento = ?");
	        pst.setString(1, ponencia.getCongreso());
	        pst.setInt(2, ponencia.getIdDocumento());
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        System.out.println("SE CAMBIO EL ESTADO de una ponencia");
	        return true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return true;
	    }
		
	}

	public boolean actualizarArticulo(ArticuloCientifico ac) {
		try {
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("UPDATE articulo_cientifico SET SSN = ? WHERE id_documento = ?");
	        pst.setString(1, ac.getSsn());
	        pst.setInt(2, ac.getIdDocumento());
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        System.out.println("SE CAMBIO EL ESTADO de un articulo cientifico");
	        return true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return true;
	    }
		
	}

}
