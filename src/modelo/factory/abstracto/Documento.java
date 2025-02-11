package modelo.factory.abstracto;

import java.time.LocalDate;

import control.DAO.documentos.DocumentoDAO;
import modelo.state.EstadoVisible;
import modelo.state.VisualizacionState;
import modelo.visitor.DocumentoVisitor;

public abstract class Documento {
	protected int idDocumento;
	protected int idEditorial;
	protected int idAutor;
	protected String titulo;
	protected LocalDate fechaPublicacion;
	protected String isbn;
	protected String tipoDocumento;
	protected VisualizacionState estadoVisualizacion;

	public Documento(int idDocumento, int idEditorial, int idAutor, String titulo, LocalDate fechaPublicacion,
			String isbn, String tipoDocumento, VisualizacionState estadoVisualizacion) {
		this.idDocumento = idDocumento;
		this.idEditorial = idEditorial;
		this.idAutor = idAutor;
		this.titulo = titulo;
		this.fechaPublicacion = fechaPublicacion;
		this.isbn = isbn;
		this.tipoDocumento = tipoDocumento;
		this.estadoVisualizacion = estadoVisualizacion != null ? estadoVisualizacion : new EstadoVisible();
	}

	public Documento() {
	}

	abstract public void aceptar(DocumentoVisitor visitor);
	
	
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

	public VisualizacionState getEstadoVisualizacion() {
		return estadoVisualizacion;
	}
	public void setEstadoVisualizacion(VisualizacionState estadoVisualizacion) {
		this.estadoVisualizacion = estadoVisualizacion;
	}

	public void cambiarEstado(VisualizacionState nuevoEstado, DocumentoDAO dao) {
		this.estadoVisualizacion = nuevoEstado;
		nuevoEstado.actualizarEstado(dao, this);
	}
	
	@Override
	public String toString() {
		return "nombre: " + titulo + " estado visualizacion: "+ estadoVisualizacion.getEstado() + " id autor: "+ idAutor +"\n";
	}

}
