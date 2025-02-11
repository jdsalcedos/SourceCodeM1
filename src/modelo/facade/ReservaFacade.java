package modelo.facade;

import control.DAO.HistorialDAO;
import control.DAO.ReservaDAO;
import modelo.autor.Autor;
import modelo.facade.historial.HistorialCambio;
import modelo.facade.reserva.Reserva;
import modelo.factory.abstracto.Documento;
import modelo.usuario.Usuario;

public class ReservaFacade {
	private Reserva reserva;
	private HistorialCambio historial;
	private ReservaDAO resDAO;
	private HistorialDAO histDAO;
	public ReservaFacade() {
		reserva = new Reserva();
		historial = HistorialCambio.getInstance();
		resDAO = new ReservaDAO();
		histDAO = new HistorialDAO();
		new Usuario();
		new Autor();
	}
	
	private boolean comprobarReserva(Usuario usuario) {
		//true = disponible para reservar
		if(resDAO.getOneByUsuario(usuario.getIdUsuario()).equals("Disponible para reservar") || resDAO.getOneByUsuario(usuario.getIdUsuario()).equals(null)) {
			return true;
		}else if(resDAO.getOneByUsuario(usuario.getIdUsuario()).equals("Reservado")){
			return false;
		}else {
			return false;
		}
	}
	
	public void hacerReserva(Usuario usuario, Documento doc) {
		if(comprobarReserva(usuario)) {
			reserva.setIdUsuario(usuario.getIdUsuario());
			reserva.setIdDocumento(doc.getIdDocumento());
			resDAO.add(reserva);
			historial.setIdUsuario(usuario.getIdUsuario());
			historial.setIdDocumento(doc.getIdDocumento());
			histDAO.reservado();
		}else {
			System.out.println("El documento ya se encuentra reservado");
		}
	}
	
	
	
}
