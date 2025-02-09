package modelo.facade.historial;

import java.time.LocalDate;

public class HistorialCambio {
	private int idHistorial;
	private Integer idUsuario;
	private int idDocumento;
	private Integer idAutor;
	private String accion;
	private LocalDate fechaModificacion;
	
	public HistorialCambio() {
	}
	
	public HistorialCambio(int idHistorial, int idUsuario, int idDocumento, int idAutor, String accion,
			LocalDate fechaModificacion) {
		super();
		this.idHistorial = idHistorial;
		this.idUsuario = idUsuario;
		this.idDocumento = idDocumento;
		this.idAutor = idAutor;
		this.accion = accion;
		this.fechaModificacion = fechaModificacion;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public int getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(LocalDate fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	
	
}
