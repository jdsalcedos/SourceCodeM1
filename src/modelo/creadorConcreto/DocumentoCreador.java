package modelo.creadorConcreto;

import modelo.Libro;
import modelo.abstracto.*;
import java.time.LocalDate;

public class DocumentoCreador extends DocumentoFactory{

	public Documento crearLibro(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, int numPaginas) {
		return null;
	}

	public Documento crearPonencia(int idDocumento, int idEditorial, int idAutor, String titulo,
			LocalDate fechaPublicacion, String isbn, String tipoDocumento, String congreso) {
		// TODO Auto-generated method stub
		return null;
	}

	public Documento crearArticulo(int idDocumento, int idEditorial, int idAutor, String titulo,
			LocalDate fechaPublicacion, String isbn, String tipoDocumento, String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

}
