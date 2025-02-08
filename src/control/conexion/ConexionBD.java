package control.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
	
    private static ConexionBD instancia = null;
    private static Connection cn = null;
    private static final String Controlador = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/biblioteca"; 
    private static final String username = "root";
    private static final String password = "";
    
    private static PreparedStatement pst;
    private static ResultSet rs;
    
    private ConexionBD() {}

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
   
    } public static void desconectar() {
        cn = null;
    }

    
// ACA ESTA EL CODIGO EJEMPLO PARA LAS CONSULTAS, ESTO DEBE IR EN LAS CLASES DAO
    
    
//    public static void main(String[] args) {
//    	Connection cn = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//
//        try {
//            cn = ConexionBD.getConexion();
//            if (cn == null) {
//                System.out.println("No se pudo establecer la conexión.");
//                return;
//            }
//
//            pst = cn.prepareStatement("SELECT * FROM autor");
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//                System.out.println("Usuario: " + rs.getString("telefono")); // Nombre de la columna sobre la que se quiere consultar
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}

