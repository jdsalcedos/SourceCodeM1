package control.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import control.conexion.ConexionBD;
import modelo.facade.historial.HistorialCambio;
import modelo.facade.reserva.Reserva;

public class HistorialDAO implements InterfaceDAO<HistorialCambio>{
	
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public HistorialDAO() {
		// gestor
		cn = null;
		pst = null;
		rs = null;
	}

	@Override
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
		try {
			cn = ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("insert into historial_cambio values(?,?,?,?,?)");
			pst.setInt(1, x.getIdHistorial());
			pst.setInt(2, x.getIdDocumento());
			pst.setInt(3, x.getIdUsuario());
			pst.setString(4, "Crear".trim());
			pst.setDate(5, Date.valueOf(LocalDate.now()));
			pst.executeUpdate();
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
	}
		
	}

	@Override
	public boolean update(HistorialCambio x, HistorialCambio y) {
		//crear, eliminar, modificar, reservar, devolver
		
		return false;
	}

	@Override
	public boolean delete(HistorialCambio x) {
		// TODO Auto-generated method stub
		return false;
	}

}
