package modelo.factory.creadorConcreto;

import java.time.LocalDate;

import modelo.factory.abstracto.*;
import modelo.state.EstadoVisible;
import modelo.state.VisualizacionState;

public class CreadorDocumento implements DocumentoFactory{
/*El dato que va a ser el parámetro de los if vendrá de la vista, 
 *al momento de querer crear un documento. 
 *Se recoge ese dato y posteriormente se manda a esta clase para poder validar
y decidir cual tipo de documento es el que se quiere crear.*/
	
	
	public Documento creadorDocumento(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, VisualizacionState estadoVisualizacion) {
		
		if (estadoVisualizacion == null) {
	        estadoVisualizacion = new EstadoVisible(); // Estado predeterminado
	    }
		
		switch (tipoDocumento) {
			case "Libro":
				String numPaginas = "15";
				return crearLibro(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion, numPaginas);
			case "Ponencia":
				String congreso = "COP16";
				return crearPonencia(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion, congreso);
			case "Articulo cientifico":
				String ssn = "1234684";
				return crearArticulo(idDocumento, idEditorial, idAutor, titulo, fechaPublicacion, isbn, tipoDocumento, estadoVisualizacion, ssn);
			default:
				throw new IllegalArgumentException("Tipo de documento no válido: "+ tipoDocumento);
		}
	}
	
//Main que simula la creacion de documentos la cual debe ser realizada con los datos de la Vista y el DAO
	
	
//	public static void main(String[] args) {
		//Crea la fábrica que implementa el método 
//		CreadorDocumento fabrica = new CreadorDocumento();
//      // Crear instancias de CreadorDocumento con diferentes tipos de documentos
//      Documento libro = fabrica.creadorDocumento(1, 101, 201, "El Gran Libro", LocalDate.of(2022, 5, 10), "978-3-16-148410-0", "Libro");
//      Documento ponencia = fabrica.creadorDocumento(2, 102, 202, "Avances en IA", LocalDate.of(2023, 6, 15), "978-1-23-456789-7", "Ponencia");
//      Documento articulo = fabrica.creadorDocumento(3, 103, 203, "Estudio Científico", LocalDate.of(2021, 3, 20), "978-0-12-345678-9", "Articulo cientifico");
//
//      System.out.println(libro.toString());
//      System.out.println(ponencia.toString());
//      System.out.println(articulo.toString());
//      System.out.println(articulo.getIdAutor());
//    }
	
	
}
