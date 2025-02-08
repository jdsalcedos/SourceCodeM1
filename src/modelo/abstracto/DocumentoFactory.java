package modelo.abstracto;

import java.time.LocalDate;

public abstract class DocumentoFactory {

	public abstract Documento crearLibro(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, int numPaginas);
	public abstract Documento crearPonencia(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String congreso);
	public abstract Documento crearArticulo(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String ssn);
}
