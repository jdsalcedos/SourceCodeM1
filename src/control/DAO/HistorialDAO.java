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

public class HistorialDAO implements InterfaceDAO<HistorialCambio>{
	
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String accion;
	private HistorialCambio hc = HistorialCambio.getInstance();
	
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
		try {
			cn = (Connection) ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("select * from historial_cambio where id_historial=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				hc.setIdHistorial(id);
				hc.setIdUsuario(rs.getInt("id_usuario"));
				hc.setIdDocumento(rs.getInt("id_documento"));
				hc.setAccion(rs.getString("accion"));
				hc.setFechaModificacion(rs.getDate("fecha_modificacion").toLocalDate());
				hc.setIdAutor(rs.getInt("id_autor"));
			}
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return hc;
	}

	@Override
	//SE ACTUALIZAN LOS VALORES DEL SINGLETON,
	//se pone el parámetro en null y luego se ejecuta la función
	public void add(HistorialCambio noseusa) {
	    // Validar que solo uno de los dos IDs tenga valor
	    if ((hc.getIdAutor() != null && hc.getIdUsuario() != null) || 
	        (hc.getIdAutor() == null && hc.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Crear";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, hc.getIdHistorial());
	        pst.setInt(2, hc.getIdDocumento());
	        pst.setObject(3, hc.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, hc.getIdAutor(), Types.INTEGER);   // Permite NULL
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
	//SE ACTUALIZA EL VALOR DEL OBJETO SINGLETON,
	//Se ponen los parámetros en null y se ejecuta la función
	public boolean update(HistorialCambio noseusa, HistorialCambio tampocoseusa) {
		//modificar
		// Validar que solo uno de los dos IDs tenga valor
	    if ((hc.getIdAutor() != null && hc.getIdUsuario() != null) || 
	        (hc.getIdAutor() == null && hc.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Modificar";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, hc.getIdHistorial());
	        pst.setInt(2, hc.getIdDocumento());
	        pst.setObject(3, hc.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, hc.getIdAutor(), Types.INTEGER);   // Permite NULL
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
	
	//SE ACTUALIZAN LOS VALORES DEL SINGLETON,
	//se pone el parámetro en null y luego se ejecuta la función
	public boolean reservado(HistorialCambio noseusa) {
		//modificar, reservar, devolver
		// Validar que solo uno de los dos IDs tenga valor
	    if ((hc.getIdAutor() != null && hc.getIdUsuario() != null) || 
	        (hc.getIdAutor() == null && hc.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Reservar";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, hc.getIdHistorial());
	        pst.setInt(2, hc.getIdDocumento());
	        pst.setObject(3, hc.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, hc.getIdAutor(), Types.INTEGER);   // Permite NULL
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
	
	//SE ACTUALIZAN LOS VALORES DEL SINGLETON,
	//se pone el parámetro en null y luego se ejecuta la función
	public boolean devolver(HistorialCambio noseusa) {
		//modificar, reservar, devolver
		// Validar que solo uno de los dos IDs tenga valor
	    if ((hc.getIdAutor() != null && hc.getIdUsuario() != null) || 
	        (hc.getIdAutor() == null && hc.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Devolver";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, hc.getIdHistorial());
	        pst.setInt(2, hc.getIdDocumento());
	        pst.setObject(3, hc.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, hc.getIdAutor(), Types.INTEGER);   // Permite NULL
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
	//SE ACTUALIZAN LOS VALORES DEL SINGLETON,
	//se pone el parámetro en null y luego se ejecuta la función
	public boolean delete(HistorialCambio noseusa) {
		// Validar que solo uno de los dos IDs tenga valor
	    if ((hc.getIdAutor() != null && hc.getIdUsuario() != null) || 
	        (hc.getIdAutor() == null && hc.getIdUsuario() == null)) {
	        throw new IllegalArgumentException("Debe haber exactamente un ID entre id_autor o id_usuario.");
	    }
	    try {
	        accion = "Eliminar";
	        cn = ConexionBD.getConexion();
	        pst = cn.prepareStatement("INSERT INTO historial_cambio VALUES (?, ?, ?, ?, ?, ?)");
	        pst.setInt(1, hc.getIdHistorial());
	        pst.setInt(2, hc.getIdDocumento());
	        pst.setObject(3, hc.getIdUsuario(), Types.INTEGER); // Permite NULL
	        pst.setObject(4, hc.getIdAutor(), Types.INTEGER);   // Permite NULL
	        pst.setString(5, accion.trim());
	        pst.setDate(6, Date.valueOf(LocalDate.now()));
	        pst.executeUpdate();
	        pst.close();
	        ConexionBD.desconectar();
	        return true;
	    } catch (SQLException ex) {
	    }
	    return false;
	}

}
