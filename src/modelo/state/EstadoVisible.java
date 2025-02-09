package modelo.state;

import control.DAO.documentos.DocumentoDAO;
import modelo.factory.abstracto.Documento;

public class EstadoVisible extends VisualizacionState{


	public String nuevoEstado = "Dado de alta";
		
	
	@Override
	public
	void actualizarEstado(DocumentoDAO dao, Documento doc) {
		
		dao.actualizarEstadoEnBD(doc, nuevoEstado);
	}
	
	public @Override
	String getEstado() {
		return this.nuevoEstado;
	}

}
