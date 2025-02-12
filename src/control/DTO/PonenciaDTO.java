package control.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import modelo.state.VisualizacionState;

public class PonenciaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idDocumento;
    private int idEditorial;
    private int idAutor;
    private String titulo;
    private LocalDate fechaPublicacion;
    private String isbn;
    private String tipoDocumento;
    private VisualizacionState estadoVisualizacion;
	private String congreso;
	
	public PonenciaDTO() {
		
	}
	
	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public int getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getCongreso() {
		return congreso;
	}

	public VisualizacionState getEstadoVisualizacion() {
		return estadoVisualizacion;
	}

	public void setEstadoVisualizacion(VisualizacionState estadoVisualizacion) {
		this.estadoVisualizacion = estadoVisualizacion;
	}

	public void setCongreso(String congreso) {
		this.congreso = congreso;
	}

}
