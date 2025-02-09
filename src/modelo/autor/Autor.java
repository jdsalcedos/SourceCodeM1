package modelo.autor;

public class Autor {
	private int idAutor;
	private String nombre;
	private String correo;
	private String contrasena;
	private String direccion;
	private String telefono;
	
	public Autor(int idAutor, String nombre, String correo, String contrasena, String direccion, String telefono) {
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public Autor() {
		
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
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
		return "Autor: \nid: "+idAutor+"\nnombre: "+nombre+"\ncorreo: "+correo+"\ndireccion: "+direccion+"\ntelefono: "+telefono;
	}
	
}
