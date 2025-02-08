package control.DAO;

import java.util.ArrayList;

import modelo.usuario.Usuario;

public class UsuarioDAO implements InterfaceDAO<Usuario>{

	//esta es la lista que va a tener los datos de todos los Usuarios de la base de datos
	private ArrayList<Usuario> datos;
	
	public UsuarioDAO() {
		datos = new ArrayList<Usuario>();
	}
	
	
	// toca reescribir todos los metodos para que funcionen con Documentos
	
	@Override
	public String getAll() {
		String rta = "";
		if(!datos.isEmpty()) {
			for (Usuario user : datos) {
				rta += user + "\n"; //esto es porque la clase Autor debe tener un metodo toString y por eso guarda bien el String
			}
		}
		return rta;
	}

	@Override
	public Usuario getOne(int id) {
		Usuario rta = null;
		if(!datos.isEmpty()) {
			for(Usuario user : datos) {
				rta = user;
			}
		}
		return rta;
	}

	@Override
	public boolean add(Usuario aut) {
		if(find(aut) == null) {
			datos.add(aut);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Usuario antiguo, Usuario nuevo) {
		Usuario user = find(antiguo);
		if(user != null) {
			datos.remove(user);
			user.setIdUsuario(nuevo.getIdUsuario());
			user.setNombre(nuevo.getNombre());
			user.setCorreo(nuevo.getCorreo());
			user.setDireccion(nuevo.getDireccion());
			user.setTelefono(nuevo.getTelefono());
			datos.add(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Usuario userDelete) {
		Usuario user = find(userDelete);
		if(user != null) {
			datos.remove(user);
			return true;
		}
		return false;
	}

	@Override
	public Usuario find(Usuario x) {
		Usuario encontrado = null;
		if(!datos.isEmpty()) {
			for (Usuario aut : datos) {
				if(aut.getIdUsuario() == x.getIdUsuario()) {
					encontrado = aut;
				}
			}
		}
		return encontrado;
	}

}
