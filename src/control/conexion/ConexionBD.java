package control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import control.DAO.AutorDAO;
import control.DAO.HistorialDAO;
import control.DAO.ReservaDAO;
import control.DAO.UsuarioDAO;
import modelo.autor.Autor;
import modelo.facade.historial.HistorialCambio;
import modelo.facade.reserva.Reserva;
import modelo.usuario.Usuario;

public class ConexionBD {

	private static ConexionBD instancia = null;
	private static Connection cn = null;
	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/biblioteca";
	private static final String username = "root";
	private static final String password = "";

	private ConexionBD() {
	}

	public static ConexionBD getInstancia() {

		if (instancia == null) {
			instancia = new ConexionBD();
		}
		return instancia;
	}

	public static Connection getConexion() {

		try {
			Class.forName(Controlador);
			System.out.println("Controlador Cargado");

			cn = DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException ex) {

			ex.printStackTrace();
		}

		return cn;

	}

	public static void desconectar() {
		cn = null;
		System.out.println("desconectado con exito");
	}
	

	
	  public static void main(String[] args) {
	  try { 
		  //conexión con la db
		  cn = ConexionBD.getConexion();
		  //se trae el objeto del DAO
//			 ReservaDAO reserva=new ReservaDAO();
//			 Reserva res = new Reserva();
//			 res.setIdDocumento(1); 
//			 res.setIdUsuario(1);
//			 reserva.add(res);
			 //System.out.println("---- Obteniendo la reserva agregada ----"); Reserva
			 //reservaRecuperada = reserva.getOne(3);
			 //System.out.println("Reserva recuperada: " + reservaRecuperada.toString());
			 //System.out.println(reservaRecuperada.getEstadoReserva()); 
			 //reserva.update(reservaRecuperada,null);
			 //Reserva reservaActual =reserva.getOne(3);
			 //System.out.println("Reserva actualizada: " + reservaActual.getEstadoReserva());
			 //reserva.delete(reservaActual);
			 
	      
	      HistorialDAO historial=new HistorialDAO();
	      HistorialCambio cambio=new HistorialCambio();
	      cambio.setIdAutor(1);
	      cambio.setIdDocumento(1);
	      cambio.setFechaModificacion(LocalDate.now());
	      //historial.add(cambio);
	      //cambio.setIdAutor(null);
	      historial.delete(cambio);
	  } catch (Exception ex) { 
		  ex.printStackTrace(); 
	  	} 
	  }
	 
}
