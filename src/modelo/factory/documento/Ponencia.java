package modelo.factory.documento;

import java.time.LocalDate;

import modelo.factory.abstracto.Documento;
import modelo.state.VisualizacionState;
import modelo.visitor.DocumentoVisitor;

public class Ponencia extends Documento{
	private String congreso;

	public Ponencia(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, VisualizacionState estadoVisualizacion, String congreso) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion);
		this.congreso=congreso;
	}

	public String getCongreso() {
		return congreso;
	}

	public void setCongreso(String congreso) {
		this.congreso = congreso;
	}

	@Override
	public void aceptar(DocumentoVisitor visitor) {
		visitor.visit(this);
		
	}
	
}
