package modelo.factory.documento;

import java.time.LocalDate;

import modelo.factory.abstracto.Documento;
import modelo.state.VisualizacionState;
import modelo.visitor.DocumentoVisitor;

public class ArticuloCientifico extends Documento{
	private String ssn;

	public ArticuloCientifico(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, VisualizacionState estadoVisualizacion, String ssn) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion);
		this.ssn=ssn;
	}
	
	public ArticuloCientifico() {
		
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@Override
	public void aceptar(DocumentoVisitor visitor) {
		visitor.visit(this);
		
	}
}
