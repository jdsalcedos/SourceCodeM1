package modelo.factory.abstracto;

import java.time.LocalDate;

import modelo.factory.documento.*;
import modelo.state.VisualizacionState;


public interface DocumentoFactory {
	
	public default Documento crearLibro(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, VisualizacionState estadoVisualizacion, String numPaginas) {
		return new Libro(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
				tipoDocumento, estadoVisualizacion, numPaginas);
	};
	
	public default Documento crearPonencia(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, VisualizacionState estadoVisualizacion, String congreso) {
		return new Ponencia(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
			tipoDocumento,estadoVisualizacion, congreso);
	};
	
	public default Documento crearArticulo(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, VisualizacionState estadoVisualizacion, String ssn) {
		return new ArticuloCientifico(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
			tipoDocumento,estadoVisualizacion, ssn);
	};
}
