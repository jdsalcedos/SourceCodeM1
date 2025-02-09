package control.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import control.conexion.ConexionBD;
import modelo.facade.historial.HistorialCambio;
import modelo.facade.reserva.Reserva;

public class HistorialDAO implements InterfaceDAO<HistorialCambio>{
	
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String accion;
	
	public HistorialDAO() {
		// gestor
		cn = null;
		pst = null;
		rs = null;
		accion = null;
	}
	public ArrayList<HistorialCambio> getAll() {
		return null;
	}

	@Override
	public HistorialCambio getOne(int id) {
		HistorialCambio cambio = null;
		try {
			cn = (Connection) ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("select * from historial_cambio where id_historial=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				cambio= new HistorialCambio();
				cambio.setIdHistorial(id);
				cambio.setIdUsuario(rs.getInt("id_usuario"));
				cambio.setIdDocumento(rs.getInt("id_documento"));
				cambio.setAccion(rs.getString("accion"));
				cambio.setFechaModificacion(rs.getDate("fecha_modificacion").toLocalDate());
				cambio.setIdAutor(rs.getInt("id_autor"));
			}
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cambio;
	}

	@Override
	public void add(HistorialCambio x) {
	    // Validar que solo uno de los dos IDs tenga valor
	    if ((x.getIdAutor() != null && x.getIdUsuario() != null) || 
	        (x.getIdAutor() == null && x.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Crear";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, x.getIdHistorial());
	        pst.setInt(2, x.getIdDocumento());
	        pst.setObject(3, x.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, x.getIdAutor(), Types.INTEGER);   // Permite NULL
	        pst.setString(5, accion.trim());
	        pst.setDate(6, Date.valueOf(LocalDate.now()));
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}



	@Override
	public boolean update(HistorialCambio x, HistorialCambio y) {
		//modificar
		// Validar que solo uno de los dos IDs tenga valor
	    if ((x.getIdAutor() != null && x.getIdUsuario() != null) || 
	        (x.getIdAutor() == null && x.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Modificar";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, x.getIdHistorial());
	        pst.setInt(2, x.getIdDocumento());
	        pst.setObject(3, x.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, x.getIdAutor(), Types.INTEGER);   // Permite NULL
	        pst.setString(5, accion.trim());
	        pst.setDate(6, Date.valueOf(LocalDate.now()));
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        return true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
	public boolean reservado(HistorialCambio x) {
		//modificar, reservar, devolver
		// Validar que solo uno de los dos IDs tenga valor
	    if ((x.getIdAutor() != null && x.getIdUsuario() != null) || 
	        (x.getIdAutor() == null && x.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Reservar";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, x.getIdHistorial());
	        pst.setInt(2, x.getIdDocumento());
	        pst.setObject(3, x.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, x.getIdAutor(), Types.INTEGER);   // Permite NULL
	        pst.setString(5, accion.trim());
	        pst.setDate(6, Date.valueOf(LocalDate.now()));
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        return true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
	public boolean devolver(HistorialCambio x) {
		//modificar, reservar, devolver
		// Validar que solo uno de los dos IDs tenga valor
	    if ((x.getIdAutor() != null && x.getIdUsuario() != null) || 
	        (x.getIdAutor() == null && x.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Devolver";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, x.getIdHistorial());
	        pst.setInt(2, x.getIdDocumento());
	        pst.setObject(3, x.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, x.getIdAutor(), Types.INTEGER);   // Permite NULL
	        pst.setString(5, accion.trim());
	        pst.setDate(6, Date.valueOf(LocalDate.now()));
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        return true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

	@Override
	public boolean delete(HistorialCambio x) {
		// Validar que solo uno de los dos IDs tenga valor
	    if ((x.getIdAutor() != null && x.getIdUsuario() != null) || 
	        (x.getIdAutor() == null && x.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Eliminar";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, x.getIdHistorial());
	        pst.setInt(2, x.getIdDocumento());
	        pst.setObject(3, x.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, x.getIdAutor(), Types.INTEGER);   // Permite NULL
	        pst.setString(5, accion.trim());
	        pst.setDate(6, Date.valueOf(LocalDate.now()));
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        return true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

}
