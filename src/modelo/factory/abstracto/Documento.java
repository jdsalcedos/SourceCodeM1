package modelo.factory.abstracto;

import java.time.LocalDate;

public abstract class Documento {
	protected int idDocumento;
	protected int idEditorial;
	protected int idAutor;
	protected String titulo;
	protected LocalDate fechaPublicacion;
	protected String isbn;
	protected String tipoDocumento;
	protected String estadoVisualizacion;
	
	
	
	public Documento(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, String estadoVisualizacion) {
		this.idDocumento = idDocumento;
		this.idEditorial = idEditorial;
		this.idAutor = idAutor;
		this.titulo = titulo;
		this.fechaPublicacion = fechaPublicacion;
		this.isbn = isbn;
		this.tipoDocumento = tipoDocumento;
		this.estadoVisualizacion = estadoVisualizacion;
	}
	public Documento() {
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public void setEstadoVisualizacion(String estadoVisualizacion) {
		this.estadoVisualizacion = estadoVisualizacion;
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public String getEstadoVisualizacion() {
		return estadoVisualizacion;
	}
	
	
}
