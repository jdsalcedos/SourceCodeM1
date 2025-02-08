package control.conexion;

public class ConexionBD {
	
    private static ConexionBD instancia = null;
    private static Connection cn = null;
    private static final String Controlador = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/biblioteca"; 
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

}
