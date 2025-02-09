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
			/*
			 * ReservaDAO reserva=new ReservaDAO(); //Se crea un objeto de reserva Reserva
			 * res= new Reserva(); //Se le añaden parámetros res.setIdReserva(3); //
			 * Suponiendo que este ID es único res.setIdDocumento(1); res.setIdUsuario(1);
			 * //Se añade el objeto a la base de datos reserva.add(res); //se trae el objeto
			 * y se imprimen sus valores
			 * System.out.println("---- Obteniendo la reserva agregada ----"); Reserva
			 * reservaRecuperada = reserva.getOne(3);
			 * System.out.println("Reserva recuperada: " + reservaRecuperada.toString());
			 * System.out.println(reservaRecuperada.getEstadoReserva()); //Se usa el objeto
			 * anterior para actualizar datos en la DB reserva.update(reservaRecuperada,
			 * null); //Se traen los nuevos datos de la DB Reserva reservaActual =
			 * reserva.getOne(3); //Se muestran al usuario
			 * System.out.println("Reserva actualizada: " +
			 * reservaActual.getEstadoReserva()); //Se eleimina el objeto de la DB
			 * reserva.delete(reservaActual);
			 */
	      
	      HistorialDAO historial=new HistorialDAO();
	      HistorialCambio cambio=new HistorialCambio();
	      cambio.setIdUsuario(1);
	      cambio.setIdDocumento(1);
	      cambio.setIdHistorial(3);
	      cambio.setFechaModificacion(LocalDate.now());
	      historial.add(cambio);
	  } catch (Exception ex) { 
		  ex.printStackTrace(); 
	  	} 
	  }
	 
}
