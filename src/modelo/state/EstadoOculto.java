package modelo.state;

import control.DAO.documentos.DocumentoDAO;
import modelo.factory.abstracto.Documento;

public class EstadoOculto extends VisualizacionState{

	public String nuevoEstado = "Dado de baja";
	
	@Override
	public
	void actualizarEstado(DocumentoDAO dao, Documento doc) {
		
		dao.actualizarEstadoEnBD(doc, nuevoEstado);
	}
	
	@Override
	public String getEstado() {
		return this.nuevoEstado;
	}
	
}
