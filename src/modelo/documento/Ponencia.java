package modelo.documento;

import java.time.LocalDate;
import modelo.abstracto.Documento;

public class Ponencia extends Documento{
	private String congreso;

	public Ponencia(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, String congreso) {
		super(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento);
		this.congreso=congreso;
	}
	
}
