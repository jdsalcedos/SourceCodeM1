package modelo.abstracto;

import java.time.LocalDate;

public abstract class Documento {
	protected int idDocumento;
	protected int idEditorial;
	protected int idAutor;
	protected String titulo;
	//atributo tipo fecha
	protected LocalDate fechaPublicacion;
	protected String isbn;
	protected String tipoDocumento;
	protected String estadoVisualizacion;
	
	public Documento(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion, String isbn,
			String tipoDocumento) {
		super();
		this.idDocumento = idDocumento;
		this.idEditorial = idEditorial;
		this.idAutor = idAutor;
		this.titulo = titulo;
		this.fechaPublicacion = fechaPublicacion;
		this.isbn = isbn;
		this.tipoDocumento = tipoDocumento;
	}
	

}
