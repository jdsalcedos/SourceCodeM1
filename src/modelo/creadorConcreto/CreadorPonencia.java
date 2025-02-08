package modelo.creadorConcreto;

import java.time.LocalDate;
import modelo.Ponencia;
import modelo.abstracto.*;

public class CreadorPonencia implements DocumentoFactory{
	
	public Documento creador(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, String congreso) {
		return new Ponencia(idDocumento,idEditorial,idAutor,titulo,fechaPublicacion,isbn,tipoDocumento,congreso);
	}
}
