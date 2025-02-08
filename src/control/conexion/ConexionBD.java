package control.conexion;

import java.sql.*;

public class ConexionBD {
	
    private static ConexionBD instancia = null;
    private static Connection cn = null;
    private static final String url = "direccion.base.datos"; //incluir la direccion especifica (ver video)
    private static final String username = "root";
    private static final String password = "";
    
    private ConexionBD() {}

    public static ConexionBD getInstancia() {

        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }
    
    public static Connection getConexion() {
        try {
            cn = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
            ex.printStackTrace();
            }
         return cn;
   
    } public static void desconectar() {
        cn = null;
    }
    
}
