package modelo.factory.documento;

import java.time.LocalDate;

import modelo.factory.abstracto.Documento;
import modelo.state.VisualizacionState;

public class Libro extends Documento{
	private String numPaginas;

	public Libro(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, VisualizacionState estadoVisualizacion, String numPaginas) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion);
		this.numPaginas=numPaginas;
	}
	
	public String getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}

}
