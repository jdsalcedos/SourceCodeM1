package modelo.state;

import control.DAO.documentos.DocumentoDAO;
import modelo.factory.abstracto.Documento;

public class EstadoOculto extends VisualizacionState{

	public static final  String ESTADO = "Dado de baja";
	
	@Override
	public
	void actualizarEstado(DocumentoDAO dao, Documento doc) {
		
		dao.actualizarEstadoEnBD(doc, ESTADO);
	}
	
	@Override
	public String getEstado() {
		return ESTADO;
	}
	
}
