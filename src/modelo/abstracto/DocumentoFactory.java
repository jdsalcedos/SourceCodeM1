package modelo.abstracto;

import java.time.LocalDate;
import modelo.documento.*;


public interface DocumentoFactory {
	public default Documento crearLibro(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, int numPaginas) {
		return new Libro(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
				tipoDocumento, numPaginas);
	};
	public default Documento crearPonencia(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String congreso) {
		return new Ponencia(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
			tipoDocumento, congreso);
	};
	public default Documento crearArticulo(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String ssn) {
		return new ArticuloCientifico(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
			tipoDocumento, ssn);
	};
}
