package modelo.state;

import control.DAO.documentos.DocumentoDAO;
import modelo.factory.abstracto.Documento;

public abstract class VisualizacionState {
	
	public String nuevoEstado;
	
	public abstract void actualizarEstado(DocumentoDAO dao, Documento doc);
	
	public abstract String getEstado();
}
