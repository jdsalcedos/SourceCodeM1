package modelo;

import java.time.LocalDate;

import modelo.abstracto.Documento;

public class Libro extends Documento{
	private int numPaginas;

	public Libro(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, int numPaginas) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento);
		this.numPaginas=numPaginas;
	}

}
