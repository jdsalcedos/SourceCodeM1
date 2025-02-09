package modelo.state;

import control.DAO.documentos.DocumentoDAO;
import modelo.factory.abstracto.Documento;

public class EstadoOculto implements VisualizacionState{

	@Override
	public void actualizarEstadoBD(DocumentoDAO dao, Documento doc) {
		dao.actualizarEstadoEnBD(doc, "Dado de alta");
	}

	
}
