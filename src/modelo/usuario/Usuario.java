package modelo.usuario;

public class Usuario {
	private int idUsuario;
	private String nombre;
	private String correo;
	private String contrasena;
	private String direccion;
	private String telefono;
	
	
	public Usuario(int idUsuario, String nombre, String correo, String contrasena, String direccion, String telefono) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Usuario() {
	
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Usuario: \nid: "+idUsuario+"\nnombre: "+nombre+"\ncorreo: "+correo+"\ndireccion: "+direccion+"\ntelefono: "+telefono;
	}
	
}
