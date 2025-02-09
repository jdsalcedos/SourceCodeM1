package modelo.facade.historial;

import java.time.LocalDate;

public class HistorialCambio {
	private int idHistorial;
	private int idUsuario;
	private int idDocumento;
	private String accion;
	private LocalDate fechaModificacion;
	
	public HistorialCambio() {
	}
	
	public HistorialCambio(int idHistorial, int idUsuario, int idDocumento, String accion,
			LocalDate fechaModificacion) {
		super();
		this.idHistorial = idHistorial;
		this.idUsuario = idUsuario;
		this.idDocumento = idDocumento;
		this.accion = accion;
		this.fechaModificacion = fechaModificacion;
	}

	public int getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
