package modelo.abstracto;

import java.time.LocalDate;

public interface DocumentoFactory {
	public default Documento crearLibro(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, int numPaginas) {
		return null;
	};
	public default Documento crearPonencia(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String congreso) {
		return null;
	};
	public default Documento crearArticulo(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String ssn) {
		return null;
	};
}
