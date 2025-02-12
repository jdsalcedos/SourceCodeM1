package modelo.state;

import control.DAO.documentos.DocumentoDAO;
import modelo.factory.abstracto.Documento;

public class EstadoVisible extends VisualizacionState{


	public static final String ESTADO = "Dado de alta";
		
	@Override
	public
	void actualizarEstado(DocumentoDAO dao, Documento doc) {
		
		dao.actualizarEstadoEnBD(doc, ESTADO);
	}
	
	public @Override
	String getEstado() {
		return ESTADO;
	}

}
