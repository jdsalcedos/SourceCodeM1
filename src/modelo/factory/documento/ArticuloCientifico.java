package modelo.factory.documento;

import java.time.LocalDate;

import modelo.factory.abstracto.Documento;

public class ArticuloCientifico extends Documento{
	private String ssn;

	public ArticuloCientifico(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, String estadoVisualizacion, String ssn) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion);
		this.ssn = ssn;
	}
	@Override
	public String toString() {
	    return "ArticuloCientifico{" +
	            "idDocumento=" + idDocumento +
	            ", idEditorial=" + idEditorial +
	            ", idAutor=" + idAutor +
	            ", titulo='" + titulo + '\'' +
	            ", fechaPublicacion=" + fechaPublicacion +
	            ", isbn='" + isbn + '\'' +
	            ", ssn='" + ssn + '\'' +
	            '}';
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
}
