package control.DAO.documentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import control.DAO.InterfaceDAO;
import control.conexion.ConexionBD;
import modelo.factory.documento.Libro;

public class LibroDAO implements InterfaceDAO<Libro> {

	private Connection cn;
	private PreparedStatement pst;

	public LibroDAO() {
		cn = null;
		pst = null;
	}

	
	@Override
	public Libro getOne(int id) {
		return null;
	}

	@Override
	public void add(Libro lib) {
		try {
			cn = ConexionBD.getConexion();

			pst = (PreparedStatement) cn.prepareStatement("insert into documento values(?,?,?,?,?,?,?)");
			pst.setInt(1, lib.getIdDocumento());
			pst.setString(2, lib.getTitulo().trim());
			pst.setDate(3, java.sql.Date.valueOf(lib.getFechaPublicacion()));
			pst.setInt(4, lib.getIdEditorial());
			pst.setString(5, lib.getIsbn().trim());
			pst.setString(6, lib.getTipoDocumento().trim());
			pst.setString(7, lib.getEstadoVisualizacion().getEstado());
			pst.executeUpdate();

			pst = (PreparedStatement) cn.prepareStatement("insert into libro values(?,?)");
			pst.setInt(1, lib.getIdDocumento());
			pst.setString(2, lib.getNumPaginas());
			pst.executeUpdate();

			pst = (PreparedStatement) cn.prepareStatement("insert into documento_autor values(?,?)");
			pst.setInt(1, lib.getIdDocumento());
			pst.setInt(2, lib.getIdAutor());
			pst.executeUpdate();

			pst.close();
			ConexionBD.desconectar();
			System.out.println("libro agregado con exito");

		} catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	@Override
	public boolean update(Libro x, Libro y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Libro x) {
		// TODO Auto-generated method stub
		return false;
	}

}
