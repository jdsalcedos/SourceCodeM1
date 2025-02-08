package modelo.creadorConcreto;

import java.time.LocalDate;
import modelo.ArticuloCientifico;
import modelo.abstracto.*;

public class CreadorArticulo implements DocumentoFactory{

	public Documento creador(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String ssn) {
		return new ArticuloCientifico(idDocumento,idEditorial,idAutor,titulo,fechaPublicacion,isbn,tipoDocumento,ssn);
	}
}
