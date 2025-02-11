package control.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.conexion.ConexionBD;
import modelo.facade.reserva.Reserva;

public class ReservaDAO implements InterfaceDAO<Reserva>{
	//variables 
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	//constructor que inicializa variables
	public ReservaDAO() {
		// gestor
		cn = null;
		pst = null;
		rs = null;
	}

	

	//Función para obtener uno directamente por el ID de la reserva
	@Override
	public Reserva getOne(int id) {
		//Se instancia el objeto
		Reserva res = null;
		try {
			//Se hace la conexión y se crea el statement(query en SQL)
			cn = (Connection) ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("select * from reserva where id_reserva=?");
			//dentro del primer ? vamos a meter un parámetro
			pst.setInt(1, id);
			//result set es el resultado de ejecutar la query
			rs = pst.executeQuery();
			//Se itera sobre el result set
			if (rs.next()) {
				//Se crea el objeto
				res= new Reserva();
				//Se ponen los parámetros de acuerdo al rs y al valor en la columna
				res.setIdReserva(id);
				res.setIdUsuario(rs.getInt("id_usuario"));
				res.setIdDocumento(rs.getInt("id_documento"));
				res.setEstadoReserva(rs.getString("estado_reserva"));
			}
			//Imprime el resultado desde la base de datos
			System.out.println("Estado: "+res.getEstadoReserva());
			//Cierra la query 
			pst.close();
			//Se desconecta de la DB de forma segura
			ConexionBD.desconectar();
			//Excepción por si acaso
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//Retorna el objeto específico que coincida con esa id 
		return res;
	}
	
	public Reserva getOneByUsuario(int id) {
		//Se instancia el objeto
		Reserva res = null;
		try {
			//Se hace la conexión y se crea el statement(query en SQL)
			cn = (Connection) ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("select * from reserva where =?");
			//dentro del primer ? vamos a meter un parámetro
			pst.setInt(1, id);
			//result set es el resultado de ejecutar la query
			rs = pst.executeQuery();
			//Se itera sobre el result set
			if (rs.next()) {
				//Se crea el objeto
				res= new Reserva();
				//Se ponen los parámetros de acuerdo al rs y al valor en la columna
				res.setIdUsuario(id);
				res.setIdReserva(rs.getInt("id_reserva"));
				res.setIdDocumento(rs.getInt("id_documento"));
				res.setEstadoReserva(rs.getString("estado_reserva"));
			}
			//Cierra la query 
			pst.close();
			//Se desconecta de la DB de forma segura
			ConexionBD.desconectar();
			//Excepción por si acaso
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//Retorna el objeto específico que coincida con esa id 
		return res;
	}

	@Override
	public void add(Reserva x) {
		try {
			//conexión y query
			cn = ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("insert into reserva values(?,?,?,?)");
			//inserta dentro de los campos genéricos los valores que entren al parámetro
			pst.setInt(1, x.getIdReserva());
			pst.setInt(2, x.getIdDocumento());
			pst.setInt(3, x.getIdUsuario());
			pst.setString(4, "Reservado");
			//ejecuta y cierra ejecución
			pst.executeUpdate();
			pst.close();
			ConexionBD.desconectar();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean update(Reserva viejo, Reserva nuevo) {
		try {
			//conexión y query
			cn = ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("update reserva set estado_reserva=? where id_reserva=?");
			//verificar de acuerdo al parámetro de la reserva
			if(viejo.getEstadoReserva().equals("Reservado")) {
				//reemplazo de la consulta genérica
				pst.setString(1, "Disponible para reservar");
				pst.setInt(2, viejo.getIdReserva());
				//ejecución de la consulta
				pst.executeUpdate();
			}else if(viejo.getEstadoReserva().equals("Disponible para reservar")){
				pst.setString(1, "Reservado");
				pst.setInt(2, viejo.getIdReserva());
				pst.executeUpdate();
			}
			//Cerrar query
			pst.close();
			//desconectar de la DB
			ConexionBD.desconectar();
			return true;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Reserva x) {
		try {
			//Conexión y query
			cn = ConexionBD.getConexion();
			pst = (PreparedStatement) cn.prepareStatement("delete from reserva where id_reserva=?");
			//Reemplaza el id a eleiminar
			pst.setInt(1, x.getIdReserva());
			//Ejecuta, cierra y se desconecta
			pst.executeUpdate();
			pst.close(); 
			ConexionBD.desconectar();
			return true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}

	

}
