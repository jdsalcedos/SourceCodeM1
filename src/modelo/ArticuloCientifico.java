package modelo;

import java.time.LocalDate;

import modelo.abstracto.Documento;

public class ArticuloCientifico extends Documento{
	private String ssn;

	public ArticuloCientifico(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, String ssn) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento);
		this.ssn = ssn;
	}
	
}
