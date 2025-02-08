package modelo.creadorConcreto;

import modelo.Libro;
import modelo.abstracto.*;
import java.time.LocalDate;

public class CreadorLibro implements DocumentoFactory{
	
	public Documento creador(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento, int numPaginas) {
		return new Libro(idDocumento,idEditorial,idAutor,titulo,fechaPublicacion,isbn,tipoDocumento,numPaginas);
	}
	
}
