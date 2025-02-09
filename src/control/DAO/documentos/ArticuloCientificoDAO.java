package control.DAO.documentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import control.DAO.InterfaceDAO;
import control.conexion.ConexionBD;
import modelo.factory.documento.ArticuloCientifico;

public class ArticuloCientificoDAO implements InterfaceDAO<ArticuloCientifico>{

	private Connection cn;
	private PreparedStatement pst;
	// gestor
	
	public ArticuloCientificoDAO() {
		// gestor
		cn = null;
		pst = null;
	}
	
	@Override
	public ArrayList<ArticuloCientifico> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticuloCientifico getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(ArticuloCientifico ac) {
		try {
			cn = ConexionBD.getConexion();

			pst = (PreparedStatement) cn.prepareStatement("insert into documento values(?,?,?,?,?,?,?)");
			pst.setInt(1, ac.getIdDocumento());
			pst.setString(2, ac.getTitulo().trim());
			pst.setDate(3, java.sql.Date.valueOf(ac.getFechaPublicacion()));
			pst.setInt(4, ac.getIdEditorial());
			pst.setString(5, ac.getIsbn().trim());
			pst.setString(6, ac.getTipoDocumento().trim());
			pst.setString(7, ac.getEstadoVisualizacion().trim());
			pst.executeUpdate();

			pst = (PreparedStatement) cn.prepareStatement("insert into articulo_cientifico values(?,?)");
			pst.setInt(1, ac.getIdDocumento());
			pst.setString(2, ac.getSsn());
			pst.executeUpdate();
			
			pst = (PreparedStatement) cn.prepareStatement("insert into documento_autor values(?,?)");
			pst.setInt(1, ac.getIdDocumento());
			pst.setInt(2, ac.getIdAutor());
			pst.executeUpdate();

			pst.close();
			ConexionBD.desconectar();
			System.out.println("Articulo agregado con exito");

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	@Override
	public boolean update(ArticuloCientifico x, ArticuloCientifico y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ArticuloCientifico x) {
		// TODO Auto-generated method stub
		return false;
	}

}
