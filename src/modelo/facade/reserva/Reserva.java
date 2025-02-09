package modelo.facade.reserva;

public class Reserva {
	private int idReserva;
	private int idDocumento;
	private int idUsuario;
	private String estadoReserva;
	
	public Reserva() {
	}
	
	public Reserva(int idReserva, int idDocumento, int idUsuario, String estadoReserva) {
		this.idReserva = idReserva;
		this.idDocumento = idDocumento;
		this.idUsuario = idUsuario;
		this.estadoReserva = estadoReserva;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEstadoReserva() {
		return estadoReserva;
	}
	public void setEstadoReserva(String estadoReserva) {
		this.estadoReserva = estadoReserva;
	}
	
	@Override
	public String toString() {
	    return "Reserva{" +
	           "idReserva=" + idReserva +
	           ", idDocumento=" + idDocumento +
	           ", idUsuario=" + idUsuario +
	           ", estadoReserva='" + estadoReserva + '\'' +
	           '}';
	}

	
	
}
