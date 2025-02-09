package control.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.conexion.ConexionBD;
import modelo.autor.Autor;
import modelo.facade.reserva.Reserva;

public class ReservaDAO implements InterfaceDAO<Reserva>{
	
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ReservaDAO() {
		// gestor
		cn = null;
		pst = null;
		rs = null;
	}

	@Override
	public ArrayList<Reserva> getAll() {
//		ArrayList<Reserva> reservas  = new ArrayList<Reserva>();
//		try {
//			cn = ConexionBD.getConexion();
//			pst = (PreparedStatement) cn.prepareStatement("select * from reserva");
//			rs = pst.executeQuery();
//			while (rs.next()) {
//				Reserva res = new Reserva();
//				res.setIdReserva(rs.getInt("id_reserva"));
//				res.setIdUsuario(rs.getInt("id_usuario"));
//				res.setIdDocumento(rs.getInt("id_documento"));
//				res.setEstadoReserva(rs.getString("estado_reserva"));
//				reservas.add(res);
//			}
//			pst.close();
//			ConexionBD.desconectar();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		System.err.println(reservas);
//		return reservas;
		return null;
	}

	@Override
	public Reserva getOne(int id) {
		Reserva res = null;
		try {
			cn = (Connection) ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("select * from reserva where id_reserva=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				res= new Reserva();
				res.setIdReserva(id);
				res.setIdUsuario(rs.getInt("id_usuario"));
				res.setIdDocumento(rs.getInt("id_documento"));
				res.setEstadoReserva(rs.getString("estado_reserva"));
			}
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}

	@Override
	public void add(Reserva x) {
		try {
			cn = ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("insert into reserva values(?,?,?,?)");
			pst.setInt(1, x.getIdReserva());
			pst.setInt(2, x.getIdDocumento());
			pst.setInt(3, x.getIdUsuario());
			pst.setString(4, "Reservado");
			pst.executeUpdate();
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean update(Reserva viejo, Reserva nuevo) {
		try {
			cn = ConexionBD.getConexion();
			
			if(viejo.getEstadoReserva().equals("Reservado")) {
				pst = (PreparedStatement) cn.prepareStatement("update reserva set estado_reserva=? where id_reserva=?");
				pst.setString(1, "Disponible para reservar");
				pst.setInt(2, viejo.getIdReserva());
				pst.executeUpdate();
			}else if(viejo.getEstadoReserva().equals("Disponible para reservar")){
				pst = (PreparedStatement) cn.prepareStatement("update reserva set estado_reserva=? where id_reserva=?");
				pst.setString(1, "Reservado");
				pst.setInt(2, viejo.getIdReserva());
				pst.executeUpdate();
			}
			pst.close();
			ConexionBD.desconectar();
			return true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean delete(Reserva x) {
		try {
			cn = ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("delete from reserva where id_reserva=?");
			pst.setInt(1, x.getIdReserva());
			pst.executeUpdate();
			pst.close(); 
			ConexionBD.desconectar();
			return true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}

	

}
