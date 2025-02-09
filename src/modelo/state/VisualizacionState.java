package modelo.state;

import control.DAO.documentos.DocumentoDAO;
import modelo.factory.abstracto.Documento;

public interface VisualizacionState {
	void actualizarEstadoBD(DocumentoDAO dao, Documento doc);
}
