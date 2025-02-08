package modelo.factory.documento;

import java.time.LocalDate;

import modelo.factory.abstracto.Documento;

public class Libro extends Documento{
	private String numPaginas;

	public Libro(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String numPaginas) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento);
		this.numPaginas=numPaginas;
	}

	@Override
	public String toString() {
	    return "Libro{" +
	            "idDocumento=" + idDocumento +
	            ", idEditorial=" + idEditorial +
	            ", idAutor=" + idAutor +
	            ", titulo='" + titulo + '\'' +
	            ", fechaPublicacion=" + fechaPublicacion +
	            ", isbn='" + isbn + '\'' +
	            ", numPaginas=" + numPaginas +
	            '}';
	}
	
	public String getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}

}
