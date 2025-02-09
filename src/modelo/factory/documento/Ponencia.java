package modelo.factory.documento;

import java.time.LocalDate;

import modelo.factory.abstracto.Documento;

public class Ponencia extends Documento{
	private String congreso;

	public Ponencia(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, String estadoVisualizacion, String congreso) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion);
		this.congreso=congreso;
	}

	public String getCongreso() {
		return congreso;
	}

	public void setCongreso(String congreso) {
		this.congreso = congreso;
	}
	
}
