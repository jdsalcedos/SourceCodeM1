package control.DAO;

import modelo.autor.Usuario;
import java.util.ArrayList;

public class AutorDAO implements InterfaceDAO<Usuario>{

	
	//esta es la lista que va a tener los datos de todos los Autores de la base de datos
	private ArrayList<Usuario> datos;
	
	public AutorDAO() {
		datos = new ArrayList<Usuario>();
	}

	@Override
	public String getAll() {
		String rta = "";
		if(!datos.isEmpty()) {
			for (Usuario aut : datos) {
				rta += aut + "\n"; //esto es porque la clase Autor debe tener un metodo toString y por eso guarda bien el String
			}
		}
		return rta;
	}

	@Override
	public Usuario getOne(int id) {
		Usuario rta = null;
		if(!datos.isEmpty()) {
			for(Usuario aut : datos) {
				rta = aut;
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
		Usuario aut = find(antiguo);
		if(aut != null) {
			datos.remove(aut);
			aut.setIdAutor(nuevo.getIdAutor());
			aut.setNombre(nuevo.getNombre());
			aut.setCorreo(nuevo.getCorreo());
			aut.setDireccion(nuevo.getDireccion());
			aut.setTelefono(nuevo.getTelefono());
			datos.add(aut);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Usuario autDelete) {
		Usuario aut = find(autDelete);
		if(aut != null) {
			datos.remove(aut);
			return true;
		}
		return false;
	}

	@Override
	public Usuario find(Usuario x) {
		Usuario encontrado = null;
		if(!datos.isEmpty()) {
			for (Usuario aut : datos) {
				if(aut.getIdAutor() == x.getIdAutor()) {
					encontrado = aut;
				}
			}
		}
		return encontrado;
	}
	
}
