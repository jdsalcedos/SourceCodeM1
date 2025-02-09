package control.DAO.documentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import control.DAO.InterfaceDAO;
import control.conexion.ConexionBD;
import modelo.factory.documento.Ponencia;

public class PonenciaDAO implements InterfaceDAO<Ponencia> {

	private Connection cn;
	private PreparedStatement pst;
	// gestor

	public PonenciaDAO() {
		// gestor
		cn = null;
		pst = null;
	}

	@Override
	public ArrayList<Ponencia> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ponencia getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Ponencia pon) {
		try {
			cn = ConexionBD.getConexion();

			pst = (PreparedStatement) cn.prepareStatement("insert into documento values(?,?,?,?,?,?,?)");
			pst.setInt(1, pon.getIdDocumento());
			pst.setString(2, pon.getTitulo().trim());
			pst.setDate(3, java.sql.Date.valueOf(pon.getFechaPublicacion()));
			pst.setInt(4, pon.getIdEditorial());
			pst.setString(5, pon.getIsbn().trim());
			pst.setString(6, pon.getTipoDocumento().trim());
			pst.setString(7, pon.getEstadoVisualizacion().trim());
			pst.executeUpdate();

			pst = (PreparedStatement) cn.prepareStatement("insert into ponencia values(?,?)");
			pst.setInt(1, pon.getIdDocumento());
			pst.setString(2, pon.getCongreso());
			pst.executeUpdate();

			pst = (PreparedStatement) cn.prepareStatement("insert into documento_autor values(?,?)");
			pst.setInt(1, pon.getIdDocumento());
			pst.setInt(2, pon.getIdAutor());
			pst.executeUpdate();

			pst.close();
			ConexionBD.desconectar();
			System.out.println("ponencia agregada con exito");

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	@Override
	public boolean update(Ponencia x, Ponencia y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Ponencia x) {
		// TODO Auto-generated method stub
		return false;
	}

}
