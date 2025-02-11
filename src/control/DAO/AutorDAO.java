package control.DAO;


import java.sql.*;
import java.util.ArrayList;

import control.conexion.ConexionBD;
import modelo.autor.Autor;

public class AutorDAO implements InterfaceDAO<Autor> {

	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	// gestor

	public AutorDAO() {
		// gestor
		cn = null;
		pst = null;
		rs = null;
	}


	@Override
	public Autor getOne(int id) {
		Autor aut = null;
		try {
			cn = (Connection) ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("select * from autor where id_autor=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				aut = new Autor();
				aut.setIdAutor(id);
				aut.setNombre(rs.getString("nombre"));
				aut.setCorreo(rs.getString("correo"));
				aut.setDireccion(rs.getString("direccion"));
				aut.setTelefono(rs.getString("telefono"));
			}
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
			;
		}
		System.out.println(aut);
		return aut;
	}

	@Override
	public void add(Autor aut) {

		try {
			cn = ConexionBD.getConexion();

			pst = (PreparedStatement) cn.prepareStatement("insert into autor values(?,?,?,?,?,?)");
			pst.setInt(1, aut.getIdAutor());
			pst.setString(2, aut.getNombre().trim());
			pst.setString(3, aut.getCorreo().trim());
			pst.setString(4, aut.getContrasena().trim());
			pst.setString(5, aut.getDireccion().trim());
			pst.setString(6, aut.getTelefono().trim());

			pst.executeUpdate();
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	@Override
	public boolean update(Autor antiguo, Autor nuevo) {

		return false;
	}

	@Override
	public boolean delete(Autor autDelete) {

		return false;
	}

}
