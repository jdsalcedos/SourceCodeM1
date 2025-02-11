package control.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.conexion.ConexionBD;
import modelo.usuario.Usuario;

public class UsuarioDAO implements InterfaceDAO<Usuario> {

	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	// gestor

	public UsuarioDAO() {
		// gestor
		cn = null;
		pst = null;
		rs = null;
	}

	
	@Override
	public Usuario getOne(int id) {
		Usuario user = null;
		try {
			cn = (Connection) ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("select * from usuario where id_usuario=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				user = new Usuario();
				user.setIdUsuario(id);
				user.setNombre(rs.getString("nombre"));
				user.setCorreo(rs.getString("correo"));
				user.setContrasena(rs.getString("contrasena"));
				user.setDireccion(rs.getString("direccion"));
				user.setTelefono(rs.getString("telefono"));
			}
			System.out.println("Metodo getOne: " + user);
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			System.out.println("Entro a la excepcion en usuarioDAO");
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public void add(Usuario user) {
		try {
			cn = ConexionBD.getConexion();

			pst = (PreparedStatement) cn.prepareStatement("insert into usuario values(?,?,?,?,?,?)");
			pst.setInt(1, user.getIdUsuario());
			pst.setString(2, user.getNombre().trim());
			pst.setString(3, user.getCorreo().trim());
			pst.setString(4, user.getContrasena().trim());
			pst.setString(5, user.getDireccion().trim());
			pst.setString(6, user.getTelefono().trim());

			pst.executeUpdate();
			pst.close();
			ConexionBD.desconectar();
			System.out.println("Agregado el usuario. Este print es de la clase UsuarioDao");
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	@Override
	public boolean update(Usuario antiguo, Usuario nuevo) {

		return false;
	}

	@Override
	public boolean delete(Usuario userDelete) {

		return false;
	}

}
