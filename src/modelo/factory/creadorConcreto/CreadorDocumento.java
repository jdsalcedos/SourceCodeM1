package modelo.factory.creadorConcreto;

import java.time.LocalDate;

import modelo.factory.abstracto.*;
import modelo.state.EstadoVisible;
import modelo.state.VisualizacionState;

public class CreadorDocumento implements DocumentoFactory{
	
	
	public Documento creadorDocumento(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, VisualizacionState estadoVisualizacion) {
		
		if (estadoVisualizacion == null) {
	        estadoVisualizacion = new EstadoVisible(); // Estado predeterminado
	    }
		
		switch (tipoDocumento) {
			case "Libro":
				
				String numPaginas = "";
				return crearLibro(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion, numPaginas);
			case "Ponencia":
				String congreso = "";
				return crearPonencia(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion, congreso);
			case "Articulo cientifico":
				String ssn = "";
				return crearArticulo(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion, ssn);
			default:
				throw new IllegalArgumentException("Tipo de documento no válido: "+ tipoDocumento);
		}
	}

}
