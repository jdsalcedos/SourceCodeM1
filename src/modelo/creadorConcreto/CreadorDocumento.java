package modelo.creadorConcreto;

import modelo.abstracto.*;
import java.time.LocalDate;

public class CreadorDocumento implements DocumentoFactory{
/*El dato que va a ser el parámetro de los if vendrá de la vista, 
 *al momento de querer crear un documento. 
 *Se recoge ese dato y posteriormente se manda a esta clase para poder validar
y decidir cual tipo de documento es el que se quiere crear.*/
	public CreadorDocumento(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento) {
		if(tipoDocumento=="Libro") {
			int numPaginas = 5; //El valor debe venir de la vista
			crearLibro(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
			tipoDocumento, numPaginas);
		}else if(tipoDocumento=="Ponencia") {
			String congreso = "Hola"; //El valor entra por la vista
			crearPonencia(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
			tipoDocumento, congreso);
		}else if(tipoDocumento=="Articulo cientifico") {
			String ssn = "Hola"; //el valor debe venir por la vista
			crearArticulo(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn,
			tipoDocumento, ssn);
		}
	}
	
}
