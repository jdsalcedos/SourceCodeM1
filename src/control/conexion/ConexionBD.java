package control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.DAO.AutorDAO;
import control.DAO.ReservaDAO;
import control.DAO.UsuarioDAO;
import modelo.autor.Autor;
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
		  cn = ConexionBD.getConexion();
		  ReservaDAO reserva=new ReservaDAO();
//		  Reserva res= new Reserva();
//		  res.setIdReserva(3);  // Suponiendo que este ID es único
//	      res.setIdDocumento(1);
//	      res.setIdUsuario(1);
//	      res.setEstadoReserva("Reservado");
	      
//	      reserva.add(res);
//	      System.out.println("---- Obteniendo la reserva agregada ----");
	      Reserva reservaRecuperada = reserva.getOne(3);
//	      System.out.println("Reserva recuperada: " + reservaRecuperada.toString());
	      reserva.update(reservaRecuperada, null);
	      System.out.println("Reserva actualizada: " + reservaRecuperada.getEstadoReserva());
//	      reserva.delete(res);
	  } catch (Exception ex) { 
		  ex.printStackTrace(); 
	  	} 
	  }
	 
}
